/*Sean Hinkle, COP3330, Dr. Hollander
*/
import java.util.Scanner;

public class Application {
	private Integer input;
	public int readInput() {
		Scanner sc = new Scanner(System.in);
		int x = 0;
		while (x != 3) {
			System.out.print("Enter 1 to encrypt a value, 2 to decrypt a value, and 3 to exit: ");
			x = sc.nextInt();
			if (x == 1 || x ==2) {
				System.out.print("Please enter a four digit integer: ");
				this.input = sc.nextInt();
				return x;
			}
		}
		sc.close();
		return 3;
	}
	public static void main(String[] args) {
		Application app = new Application();
		Encrypter enc = new Encrypter();
		Decrypter dec = new Decrypter();
		int x = 0;
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