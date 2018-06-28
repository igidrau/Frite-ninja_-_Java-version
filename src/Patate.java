import java.util.Vector;


public class Patate {
	
	int type, img;
	float masse, taille, tourne, rotation;
	Vector position, v;
	public Patate(float x, float y, float vx, float vy, float taille, int type, float rotation){
	  this.position = new Vector(2); //Vecteur position (m)
	  this.v = new Vector(2); //Vecteur vitesse (m/s)
	  this.masse = 4*PI/3*(taille)*mvpatate; //Calcul de la masse en fonction du diam�tre et de la densit�
	  this.taille = taille; //Taille de la patate (m)
	  this.type = type; //Type de la patate (normale, non �pluch�e,...)
	    
	  this.rotation = rotation; //Vitesse de rotation de la patate (rad/s)
	  this.tourne = 0; //Angle d'origine de la patate (�volue � chaque it�ration de la boucle en fonction de la vitesse de rotation) (rad)
	    
	  if (type == 0){
	    this.img = (int)Math.random()*4;
	  }else{
	    this.img = type+3;
	  }
	}
	  
	  void mouvementTerrestre(){ //simule le d�placement d'une patate dans un r�f�rentiel terrestre (fonctionnel)
	    PVector grav = PVector.mult(g, masse); //Vecteur repr�sentant le poids (N)
	    PVector frottement = PVector.mult(v, -6*PI*taille*viscosite); //Vecteur repr�sentant la force de friction (N)
	    PVector archimede = PVector.mult(g, -densite*4*PI/3*pow(taille,3)); //Vecteur repr�sentant la pouss�e d'Archim�de (N)
	    PVector a = grav.add(frottement).add(archimede).div(this.masse); //Vecteur repr�sentant l'acc�l�ration (m/s�)
	    this.v = PVector.add(v, PVector.div(a, parsec * framerate)); //Vecteur repr�sentant la vitesse (m/s)
	    this.position = PVector.add(this.position, PVector.div(this.v, parsec * framerate)); //Vecteur repr�sentant la position de la patate par rapport � l'origine du rep�re (en bas � gauche)(m)
	    if(this.position.x>61*(float)displayWidth/(60*echelleTerre) || this.position.x<0){
	      this.v = new PVector(-this.v.x, this.v.y);
	    }
	    this.tourne+=this.rotation/(parsec*framerate); //Incr�mentation de l'angle de la patate
	  }
	  
	  void mouvementGeo(){ //simule le d�placement d'une patate dans un r�f�rentiel g�ocentrique (fonctionnel)
	    float d = sqrt(pow(this.position.x,2)+pow(this.position.y,2)); //Distance entre la Terre et la patate (m)
	    float pds = Gnb*mTerrenb*this.masse/pow(d,2) * pow(10, Gpw+mTerrepw); //Valeur du poids (N)
	    PVector a = PVector.div(this.position, d).mult(-pds/this.masse); //Vecteur repr�sentant l'acc�l�ration (m/s�)
	    this.v.add(PVector.div(a,parsec*framerate)); //Vecteur repr�sentant la vitesse (m/s)
	    this.position.add(PVector.div(this.v, parsec*framerate)); //Vecteur repr�sentant la position de la patate par rapport � l'origine du rep�re (la plan�te) (m)
	    this.tourne+=this.rotation/(parsec*framerate); //Incr�mentation de l'angle de la patate
	  }

}
