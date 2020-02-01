/*Sean Hinkle, COP3330, Dr. Hollander
 * Takes in a four digit integer, uses the following formula to encrypt it:
 * add 7 and then perform modulo 10 on each digit
 * swap the first and third and second and fourth digit
 * Then stores the encrypted int in an array of ints to be displayed later
*/

public class Encrypter {
	private int leadZeros;
	private char[] originalIntString = new char[4];
	private int[] encryptedInt = new int[4];
	
	//Calls various helper functions, then performs the mathematical 
	//operations to encrypt the integer
	public void encrypt(Integer input) {
		this.setLeadZeros(input);
		this.setOriginalIntString(input);
		
		//converting the individual digits to their encrypted value
		for (int i = 0; i < 4; i++) {
			int x = Character.getNumericValue(this.originalIntString[i]);
			x += 7;
			x = x % 10;
			//places each digit into the integer array
			encryptedInt[i] = x;
		}
		this.swapInts();
	}
	
	//Method displays the array of ints by printing one at a time, followed by a new line
	public void displayArray() {
		for (int i = 0; i < 4; i++) {
			System.out.printf("%d", this.encryptedInt[i]);
		}
		System.out.println();
	}
	
	//Swaps the first and third and second and fourth digits in the number
	public void swapInts() {
		int temp = this.encryptedInt[0];
		this.encryptedInt[0] = this.encryptedInt[2];
		this.encryptedInt[2] = temp;
		
		temp = this.encryptedInt[1];
		this.encryptedInt[1] = this.encryptedInt[3];
		this.encryptedInt[3] = temp;
	}
	
	//takes the integer input, turns it into a char array (including leading zeros)
	public void setOriginalIntString(Integer input) {
		//puts all leading zeros into the character array
		if (this.leadZeros != 0) { 
			for (int i = 0; i < this.leadZeros; i++) {
				this.originalIntString[i] = '0';
			}
		}	
		//places remaining numbers into array
		int count = this.leadZeros;
		int i = 0;
		while (count < 4) {
			this.originalIntString[count] = input.toString().charAt(i);
			i++;
			count++;
		}
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
}