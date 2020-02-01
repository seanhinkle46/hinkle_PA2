/*Sean Hinkle, COP3330, Dr. Hollander
 * Utilizes the encryption and decryption classes to give the user
 * the choice to either encrypt a four digit integer, or decrypt an already
 * encrypted integer
*/
import java.util.Scanner;

public class Application {
	private Integer input; //stores the integer inputed by the user
	
	//reads in the input from the user, and returns an int to indicate to main
	//whether this is an encryption or decryption process
	public int readInput() {
		Scanner sc = new Scanner(System.in);
		int x = 0;
		//Prompts user to select encrypt, decrypt, or exit, sends selection to main method
		while (x != 3) {
			System.out.print("Enter 1 to encrypt a value, 2 to decrypt a value, and 3 to exit: ");
			x = sc.nextInt();
			//if user selects to encrypt or decrypt, prompts for a four digit number and stores it,
			//then returns the selection to main
			if (x == 1 || x ==2) {
				System.out.print("Please enter a four digit integer: ");
				this.input = sc.nextInt();
				return x;
			}
		}
		//if user selects to exit program, closes scanner, returns exit status to main
		sc.close();
		return 3;
	}
	
	public static void main(String[] args) {
		Application app = new Application();
		Encrypter enc = new Encrypter();
		Decrypter dec = new Decrypter();
		int x = 0;
		//loops to allow user to continually enter values
		while (x!=3) {
			x = app.readInput();
			if (x==1) {
				System.out.print("This is the encrypted data: ");
				enc.encrypt(app.input);
				enc.displayArray();
			}
			else if (x==2) {
				System.out.print("This is the decrypted data: ");
				dec.decrypt(app.input);
				dec.displayArray();
			} 
			else if (x==3) {
				System.out.println("Exiting");
			} else {
				System.out.println("Please enter a valid input");
			}
		}
	}
}