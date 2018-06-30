/*
 * Une classe qui permet de faire des opérations avec des vecteurs de dimension 2 ou 3
 * 
 * Constructeurs :
 * 		Vecteur() : Crée un vecteur nul
 * 
 * 		Vecteur(float, float) : Crée un vecteur de dimension 2 (z=0)
 * 
 * 		Vecteur(float, float, float) : Crée un vecteur de dimension 3
 * 
 * Liste des méthodes :
 * 		Vecteur fromAngle(float, float) : crée un nouveau vecteur à partir de l'angle et de la magnitude. (syntaxe : vecteur = Vecteur.fromAngle(angle, magnitude))
 * 
 * 
 *	 	Vecteur add(Vecteur) : addition entre l'objet et un autre vecteur placé en paramètre. (syntaxe : vecteur1.add(vecteur2)) Attention : modifie le vecteur
 *
 *		Vecteur add(Vecteur, Vecteur) : additionne deux vecteurs (syntaxe : vecteur3 = Vecteur.add(vecteur1, vecteur2))
 *
 *		Vecteur min(Vecteur) : soustrait un vecteur placé en paramètre à l'objet. (syntaxe : vecteur1.min(vecteur2)) Attention : modifie le vecteur
 *
 *		Vecteur min(Vecteur, Vecteur) : soustrait un vecteur à un autre (syntaxe : vecteur3 = Vecteur.min(vecteur1, vecteur2))
 *
 *		Vecteur mult(float) : multiplie l'objet par un réel. (syntaxe : vecteur.add(multiplieur)) Attention : modifie le vecteur
 *
 *		Vecteur mult(Vecteur, float) : multiplie un vecteur par un réel (syntaxe : vecteur2 = Vecteur.mult(vecteur1, multiplieur))
 *
 *		Vecteur div(float) : divise l'objet par un réel. (syntaxe : vecteur.div(diviseur)) Attention : modifie le vecteur
 *
 *		Vecteur div(Vecteur, float) : divise un vecteur par un réel (syntaxe : vecteur2 = Vecteur.div(vecteur1, diviseur))
 *
 *
 *		float[] toTab() : retourne un tableau contenant les coordonnées d'un vecteur (syntaxe : tableau = vecteur.tab())
 *
 *		String toString() : retourne une chaîne de caractère représentant le vecteur (syntaxe : chaine = vecteur.toString())
 */


public class Vecteur {
	float x,y,z;
	public Vecteur(){
		this.x = 0;
		this.y = 0;
		this.z = 0;
	}
	public Vecteur(float x, float y){
		this.x = x;
		this.y = y;
		this.z = 0;
	}
	
	public Vecteur(float x, float y, float z){
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public static Vecteur fromAngle(float angle, float magnitude){
		Vecteur vecteur = new Vecteur((float)Math.cos((double)angle)*magnitude, (float)Math.sin((double)angle)*magnitude);
		return vecteur;
	}

	public Vecteur add(Vecteur ajout){
		this.x += ajout.x;
		this.y += ajout.y;
		this.z += ajout.z;
		return this;
	}
	
	public Vecteur min(Vecteur retrait){
		this.x -= retrait.x;
		this.y -= retrait.y;
		this.z -= retrait.z;
		return this;
	}
	
	public Vecteur mult(float multiplieur){
		this.x *= multiplieur;
		this.y *= multiplieur;
		this.z *= multiplieur;
		return this;
	}
	
	public Vecteur div(float diviseur){
		this.x /= diviseur;
		this.y /= diviseur;
		this.z /= diviseur;
		return this;
	}
	
	public static Vecteur add(Vecteur base, Vecteur ajout){
		float x = base.x + ajout.x;
		float y = base.y + ajout.y;
		float z = base.z + ajout.z;
		return new Vecteur(x,y,z);
	}
	
	public static Vecteur min(Vecteur base, Vecteur retrait){
		float x = base.x - retrait.x;
		float y = base.y - retrait.y;
		float z = base.z - retrait.z;
		return new Vecteur(x,y,z);
	}
	
	public static Vecteur mult(Vecteur base, float multiplieur){
		float x = base.x * multiplieur;
		float y = base.y * multiplieur;
		float z = base.z * multiplieur;
		return new Vecteur(x,y,z);
	}
	
	public static Vecteur div(Vecteur base, float diviseur){
		float x = base.x / diviseur;
		float y = base.y / diviseur;
		float z = base.z / diviseur;
		return new Vecteur(x,y,z);
	}
	
	public float[] toTab(){
		if(z==0){
			float[] result = {x,y};
			return result;
		}else{
			float[] result = {x,y,z};
			return result;
		}
	}
	
	public String toString(){
		if(z==0){
			return "("+x+" ; "+y+")";
		}else{
			return "("+x+" ; "+y+" ; "+z+")";
		}
	}
}
