/*Sean Hinkle, COP3330, Dr. Hollander
*/

public class Encrypter {
	private int leadZeros;
	private char[] originalIntString = new char[4];
	private int[] encryptedInt = new int[4];
	
	public void encrypt(Integer input) {
		this.setLeadZeros(input);
		this.setOriginalIntString(input);
		//converting the individual digits to their encrypted value
		for (int i = 0; i < 4; i++) {
			int x = Character.getNumericValue(this.originalIntString[i]);
			x += 7;
			x = x % 10;
			encryptedInt[i] = x;
		}
		this.swapInts();
		
	}
	
	public char[] getOriginalIntString() {
		return originalIntString;
	}
	
	public void displayArray() {
		for (int i = 0; i < 4; i++) {
			System.out.printf("%d", this.encryptedInt[i]);
		}
	}
	

	public void swapInts() {
		int temp = this.encryptedInt[0];
		this.encryptedInt[0] = this.encryptedInt[2];
		this.encryptedInt[2] = temp;
		
		temp = this.encryptedInt[1];
		this.encryptedInt[1] = this.encryptedInt[3];
		this.encryptedInt[3] = temp;
	}
	
	public void setOriginalIntString(Integer input) {
		//puts all leading zeros into the character array
		if (this.leadZeros != 0) { 
			for (int i = 0; i < this.leadZeros; i++) {
				this.originalIntString[i] = '0';
			}
		}	
		//places 
		int count = this.leadZeros;
		int i = 0;
		while (count < 4) {
			this.originalIntString[count] = input.toString().charAt(i);
			i++;
			count++;
		}
	}
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