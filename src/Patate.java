import java.util.Vector;


public class Patate {
	
	int type, img;
	float masse, taille, tourne, rotation;
	Vector position, v;
	public Patate(float x, float y, float vx, float vy, float taille, int type, float rotation){
	  this.position = new Vector(2); //Vecteur position (m)
	  this.v = new Vector(2); //Vecteur vitesse (m/s)
	  this.masse = 4*PI/3*(taille)*mvpatate; //Calcul de la masse en fonction du diamètre et de la densité
	  this.taille = taille; //Taille de la patate (m)
	  this.type = type; //Type de la patate (normale, non épluchée,...)
	    
	  this.rotation = rotation; //Vitesse de rotation de la patate (rad/s)
	  this.tourne = 0; //Angle d'origine de la patate (évolue à chaque itération de la boucle en fonction de la vitesse de rotation) (rad)
	    
	  if (type == 0){
	    this.img = (int)Math.random()*4;
	  }else{
	    this.img = type+3;
	  }
	}
	  
	  void mouvementTerrestre(){ //simule le déplacement d'une patate dans un référentiel terrestre (fonctionnel)
	    PVector grav = PVector.mult(g, masse); //Vecteur représentant le poids (N)
	    PVector frottement = PVector.mult(v, -6*PI*taille*viscosite); //Vecteur représentant la force de friction (N)
	    PVector archimede = PVector.mult(g, -densite*4*PI/3*pow(taille,3)); //Vecteur représentant la poussée d'Archimède (N)
	    PVector a = grav.add(frottement).add(archimede).div(this.masse); //Vecteur représentant l'accélération (m/s²)
	    this.v = PVector.add(v, PVector.div(a, parsec * framerate)); //Vecteur représentant la vitesse (m/s)
	    this.position = PVector.add(this.position, PVector.div(this.v, parsec * framerate)); //Vecteur représentant la position de la patate par rapport à l'origine du repère (en bas à gauche)(m)
	    if(this.position.x>61*(float)displayWidth/(60*echelleTerre) || this.position.x<0){
	      this.v = new PVector(-this.v.x, this.v.y);
	    }
	    this.tourne+=this.rotation/(parsec*framerate); //Incrémentation de l'angle de la patate
	  }
	  
	  void mouvementGeo(){ //simule le déplacement d'une patate dans un référentiel géocentrique (fonctionnel)
	    float d = sqrt(pow(this.position.x,2)+pow(this.position.y,2)); //Distance entre la Terre et la patate (m)
	    float pds = Gnb*mTerrenb*this.masse/pow(d,2) * pow(10, Gpw+mTerrepw); //Valeur du poids (N)
	    PVector a = PVector.div(this.position, d).mult(-pds/this.masse); //Vecteur représentant l'accélération (m/s²)
	    this.v.add(PVector.div(a,parsec*framerate)); //Vecteur représentant la vitesse (m/s)
	    this.position.add(PVector.div(this.v, parsec*framerate)); //Vecteur représentant la position de la patate par rapport à l'origine du repère (la planète) (m)
	    this.tourne+=this.rotation/(parsec*framerate); //Incrémentation de l'angle de la patate
	  }

}
