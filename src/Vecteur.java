/*
 * une classe qui permet de faire des opérations avec des vecteurs de dimension 2 ou 3
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

	public Vecteur add(Vecteur ajout){
		this.x += ajout.x;
		this.y += ajout.y;
		this.z += ajout.z;
		return this;
	}
	
	public Vecteur min(Vecteur ajout){
		this.x -= ajout.x;
		this.y -= ajout.y;
		this.z -= ajout.z;
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
	
	public Vecteur add(Vecteur base, Vecteur ajout){
		this.x = base.x + ajout.x;
		this.y = base.y + ajout.y;
		this.z = base.z + ajout.z;
		return this;
	}
	
	public Vecteur min(Vecteur base, Vecteur ajout){
		this.x = base.x - ajout.x;
		this.y = base.y - ajout.y;
		this.z = base.z - ajout.z;
		return this;
	}
	
	public Vecteur mult(Vecteur base, float multiplieur){
		this.x = base.x * multiplieur;
		this.y = base.y * multiplieur;
		this.z = base.z * multiplieur;
		return this;
	}
	
	public Vecteur div(Vecteur base, float diviseur){
		this.x = base.x / diviseur;
		this.y = base.y / diviseur;
		this.z = base.z / diviseur;
		return this;
	}
}
