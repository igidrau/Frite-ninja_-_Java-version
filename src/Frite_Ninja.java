
public class Frite_Ninja {
	public static final int displayWidth = 1080;
	
	public static void main(String[] args) {
		Vecteur test = Vecteur.fromAngle((float)1.5708, 1);
		System.out.println(test);
		System.out.println(test.toTab()[0] + " , " + test.toTab()[1]);
		System.out.print("Bonjour monde !");

	}
}
