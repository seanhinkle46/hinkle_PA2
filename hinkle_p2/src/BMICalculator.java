/*Sean Hinkle, COP3330, Dr. Hollander
 * the class BMICalculator takes in height and weight (in preferred
 * system of measurement) and outputs the user's BMI with a display of BMI categories
*/
import java.util.Scanner;

public class BMICalculator {
	private Scanner sc = new Scanner(System.in); //declaring a scanner to use throughout the program
	private int unitType; //Metric = 1, imperial = 2
	private double weight;
	private double height;
	private double bmi;
	private String bmiCategory;
	
	public double getWeight() {
		return weight;
	}
	//ensures weight is not set beneath 0, if so, exits program
	private void setWeight(double weight) {
		if (weight < 0.0) {
			System.out.println("Program exiting");
			System.exit(0);
		} else {
			this.weight = weight;
		}
	}

	public double getHeight() {
		return height;
	}
	//ensures height is not set beneath 0, if so, exits program
	private void setHeight(double height) {
		if (this.height < 0.0) {
			System.out.println("Program exiting");
			System.exit(0);
		} else {
			this.height = height;
		}
	}

	public double getBmi() {
		return bmi;
	}

	public String getBmiCategory() {
		return bmiCategory;
	}

	//calls methods to obtain unit type, and then calls a method to read in data based on the type
	public void readUserData() {
		this.readUnitType();
		this.readMeasurementData();
	}
	
	//Prompts user to select the measurement system they want to use
	private void readUnitType() {
		System.out.print("Enter 1 to use the metric system, 2 to use the imperial system: ");
		this.unitType = sc.nextInt();
		while (this.unitType != 1 && this.unitType != 2) {
			System.out.print("Please enter a valid number: ");
			this.unitType = sc.nextInt();
		}
		
	}
	
	//Initiates the reading of input based on the measurement system
	private void readMeasurementData() {
		if (this.unitType == 1) {
			this.readMetricData();
		} else {
			this.readImperialData();
		}
	}
	
	//Reads in and stores height and weight in metric units
	private void readMetricData() {
		System.out.print("Please enter your weight in kilograms: ");
		setWeight(sc.nextDouble());
		System.out.print("Please enter your height in meters: ");
		setHeight(sc.nextDouble());
	}
	
	//Reads in and stores height and weight in metric units
	private void readImperialData() {
		System.out.print("Please enter your weight in pounds: ");
		setWeight(sc.nextDouble());
		System.out.print("Please enter your height in inches: ");
		setHeight(sc.nextDouble());
	}
	
	//Calculates BMI based on unit of measurement
	public void calculateBmi() {
		if (this.unitType == 1) {
			this.bmi = this.weight/(this.height*this.height);
		}
		else {
			this.bmi = (703.0*this.weight)/(this.height*this.height);
		}
		this.calculateBmiCategory();
	}
	
	//Assigns the appropriate BMI category 
	private void calculateBmiCategory() {
		if (this.bmi <= 18.5) {
			this.bmiCategory = "Underweight";
		}
		else if (this.bmi < 25.0) {
			this.bmiCategory = "Normal weight";
		}
		else if (this.bmi < 30.0) {
			this.bmiCategory = "Overweight";
		} else {
			this.bmiCategory = "Obese";
		}
	}
	
	//Displays user's BMI and the BMI classification chart
	public void displayBmi() {
		System.out.printf("%nYour BMI is %.2f, you are classified as %s%n",
					this.getBmi(), this.getBmiCategory());
		System.out.printf("%nBMI Categories:%nUnderweight =< 18.5%nNormal Weight = 18.5-24.9"
				+ "%nOverweight = 25-29.9%nObese = 30+");
	}
	
	
	public static void main(String[] args) {
		BMICalculator app = new BMICalculator();
		app.readUserData();
		app.calculateBmi();
		app.displayBmi();
	}
	
}