//Sean Hinkle, COP3330, Dr. Hollander
//the class BMI calculator takes in height and weight (in preferred
//system of measurement) and outputs BMI with a display of BMI categories

import java.util.Scanner;

public class BMICalculator {
	private Scanner sc = new Scanner(System.in);
	private int unitType; //Metric = 1, imperial = 2
	private double weight;
	private double height;
	private double bmi;
	private String bmiCategory;
	
	public double getWeight() {
		return weight;
	}

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

	public void readUserData() {
		this.readUnitType();
		this.readMeasurementData();
	}
	
	private int readUnitType() {
		//Scanner sc = new Scanner(System.in);
		System.out.print("Enter 1 to use the metric system, 2 to use the imperial system: ");
		this.unitType = sc.nextInt();
		while (this.unitType != 1 && this.unitType != 2) {
			System.out.print("Please enter a valid number: ");
			this.unitType = sc.nextInt();
		}
		//sc.close();
		return this.unitType;
		
	}
	
	private void readMeasurementData() {
		if (this.unitType == 1) {
			this.readMetricData();
		} else {
			this.readImperialData();
		}
	}
	
	private void readMetricData() {
		//Scanner sc = new Scanner(System.in);
		System.out.print("Please enter your weight in kilograms: ");
		setWeight(sc.nextDouble());
		System.out.print("Please enter your height in meters: ");
		setHeight(sc.nextDouble());
		//sc.close();
	}
	
	private void readImperialData() {
		//Scanner sc = new Scanner(System.in);
		System.out.print("Please enter your weight in pounds: ");
		setWeight(sc.nextDouble());
		if (this.weight < 0.0) {
			System.out.println("Program exiting");
			System.exit(0);
		}
		System.out.print("Please enter your height in inches: ");
		setHeight(sc.nextDouble());
		if (this.height < 0.0) {
			System.out.println("Program exiting");
			System.exit(0);
		}
		//sc.close();
	}
	
	public void calculateBmi() {
		if (this.unitType == 1) {
			this.bmi = this.weight/(this.height*this.height);
		}
		else {
			this.bmi = (703.0*this.weight)/(this.height*this.height);
		}
		this.calculateBmiCategory();
	}
	
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
			this.bmiCategory = "Obesity";
		}
	}
	
	public void displayBmi() {
		System.out.println("Your BMI is " + this.getBmi() + 
					", you are classified as " + this.getBmiCategory());
		System.out.printf("BMI Categories:%nUnderweight =< 18.5%nNormal Weight = 18.5-24.9"
				+ "%nOverweight = 25-29.9%nObese = 30+");
	}
	
	
	public static void main(String[] args) {
		BMICalculator app = new BMICalculator();
		app.readUserData();
		app.calculateBmi();
		app.displayBmi();
	}
	
}