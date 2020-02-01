/*Sean Hinkle, COP3330, Dr. Hollander
 * Takes in a four digit integer (already encrypted),
 * and reverses the encrpytion formula by:
 * adding 3 and then performing modulo 10 on each digit,
 * followed by swapping the first and third, and second and fourth digits
 * Stored the decrypted int to be displayed later
*/

public class Decrypter {
	private int leadZeros;
	private char[] originalIntString = new char[4];
	private int[] decryptedInt = new int[4];
	
	//Calls various helper functions, then performs the mathematical 
	//operations to decrypt the integer
	public void decrypt(Integer input) {
		this.setLeadZeros(input);
		this.setOriginalIntString(input);
		
		//converts individual digits to their decrypted values
		for (int i = 0; i < 4; i++) {
			int x = Character.getNumericValue(this.originalIntString[i]);
			x += 3;
			x = x % 10;
			decryptedInt[i] = x;
		}
		this.swapInts();
	}
	
	//Takes the original input and converts it into a character array
	public void setOriginalIntString(Integer input) {
		//puts all leading zeros into the character array
		if (this.leadZeros != 0) { 
			for (int i = 0; i < this.leadZeros; i++) {
				this.originalIntString[i] = '0';
			}
		}	
		//places the remaining digits in the array
		int count = this.leadZeros;
		int i = 0;
		while (count < 4) {
			this.originalIntString[count] = input.toString().charAt(i);
			i++;
			count++;
		}
	}
	
	//Swaps the first and third and second and fourth digits in the number
	public void swapInts() {
		int temp = this.decryptedInt[0];
		this.decryptedInt[0] = this.decryptedInt[2];
		this.decryptedInt[2] = temp;
		
		temp = this.decryptedInt[1];
		this.decryptedInt[1] = this.decryptedInt[3];
		this.decryptedInt[3] = temp;
	}
	
	//Determines the number of leading zeros the number should have, 
	//given that it will be 4 digits
	public void setLeadZeros(Integer in) {
		if (in == 0) {
			this.leadZeros = 4;
			return;
		}
		else if (in < 10) {
			this.leadZeros = 3;
			return;
		}
		else if (in < 100) {
			this.leadZeros = 2;
			return;
		}
		else if (in < 1000) {
			this.leadZeros = 1;
			return;
		} else {
			this.leadZeros = 0;
		}
	}
	
	//Method displays the array of ints by printing one at a time, followed by a new line
	public void displayArray() {
		for (int i = 0; i < 4; i++) {
			System.out.printf("%d", this.decryptedInt[i]);
		}
		System.out.println();
	}
}