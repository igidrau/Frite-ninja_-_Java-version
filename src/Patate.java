import java.util.Vector;


public class Patate {
	
	int type, img;
	float masse, taille, tourne, rotation;
	Vecteur position, v;
	final float mvPatate = (float)1.1;
	final Vecteur g = new Vecteur((float)9.81,(float)0);
	float viscosite = 0;
	float densite = 0;
	float parsec = 100;
	float framerate = 30;
	final float echelleTerre = 100;
	final float G = (float)6.67408E-11;
	final float mTerre = (float)5.9722E24;
	public Patate(float x, float y, float vx, float vy, float taile, int tpe, float rotaion){
		this.position = new Vecteur(x, y);
		this.v = new Vecteur (vx, vy);
		this.masse = (float)(4.18879*Math.pow(taille,3)*mvPatate); //Calcul de la masse en fonction du diam�tre et de la densit�
		this.taille = taile; //Taille de la patate (m)
		this.type = tpe; //Type de la patate (normale, non �pluch�e,...)
		
		this.rotation = rotaion; //Vitesse de rotation de la patate (rad/s)
		this.tourne = 0; //Angle d'origine de la patate (�volue � chaque it�ration de la boucle en fonction de la vitesse de rotation) (rad)
		
		if (type == 0){
			this.img = (int)Math.random()*4;
		}else{
			this.img = type+3;
		}
	}
	  
	void mouvementTerrestre(){ //simule le d�placement d'une patate dans un r�f�rentiel terrestre (fonctionnel)
		Vecteur grav = new Vecteur().mult(g, masse); //Vecteur repr�sentant le poids (N)
	    Vecteur frottement = new Vecteur().mult(v, (float)-18.8496*taille*viscosite); //Vecteur repr�sentant la force de friction (N)
	    Vecteur archimede = new Vecteur().mult(g, (float)(-densite*12.5664/3*Math.pow(taille,3))); //Vecteur repr�sentant la pouss�e d'Archim�de (N)
	    Vecteur a = grav.add(frottement).add(archimede).div(this.masse); //Vecteur repr�sentant l'acc�l�ration (m/s�)
	    this.v = new Vecteur().add(v, new Vecteur().div(a, parsec * framerate)); //Vecteur repr�sentant la vitesse (m/s)
	    this.position = new Vecteur().add(this.position, new Vecteur().div(this.v, parsec * framerate)); //Vecteur repr�sentant la position de la patate par rapport � l'origine du rep�re (en bas � gauche)(m)
	    if(this.position.x>61*(float)Frite_Ninja.displayWidth/(60*echelleTerre) || this.position.x<0){
	    	this.v = new Vecteur(-this.v.x, this.v.y);
	    }
	    this.tourne+=this.rotation/(parsec*framerate); //Incr�mentation de l'angle de la patate
	}
	  
	void mouvementGeo(){ //simule le d�placement d'une patate dans un r�f�rentiel g�ocentrique (fonctionnel)
	    float d = (float)Math.sqrt(Math.pow(this.position.x,2)+Math.pow(this.position.y,2)); //Distance entre la Terre et la patate (m)
	    float pds = (float)(G*mTerre*this.masse/Math.pow(d,2)); //Valeur du poids (N)
	    Vecteur a = new Vecteur().div(this.position, d).mult(-pds/this.masse); //Vecteur repr�sentant l'acc�l�ration (m/s�)
	    this.v.add(new Vecteur().div(a,parsec*framerate)); //Vecteur repr�sentant la vitesse (m/s)
	    this.position.add(new Vecteur().div(this.v, parsec*framerate)); //Vecteur repr�sentant la position de la patate par rapport � l'origine du rep�re (la plan�te) (m)
	    this.tourne+=this.rotation/(parsec*framerate); //Incr�mentation de l'angle de la patate
	}

}
