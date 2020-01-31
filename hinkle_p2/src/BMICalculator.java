//Sean Hinkle, COP3330, Dr. Hollander
//the class BMI calculator takes in height and weight (in preferred
//system of measurement) and outputs BMI with a display of BMI categories

import java.lang.Math;
import java.util.Scanner;

public class BMICalculator {
	private double weight;
	private double height;
	private double bmi;
	private String bmiCategory;
	
	public double getWeight() {
		return weight;
	}

	private void setWeight(double weight) {
		this.weight = weight;
	}

	public double getHeight() {
		return height;
	}

	private void setHeight(double height) {
		this.height = height;
	}

	public double getBmi() {
		return bmi;
	}

	public String getBmiCategory() {
		return bmiCategory;
	}

	public void readUserData() {
	
	}
	
	private void readUnitType() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter 1 to use the metric system, 2 to use the imperial system: ");
		int x = sc.nextInt();
		while (x != 1 && x != 2) {
			System.out.print("Please enter a valid number: ");
			x = sc.nextInt();
		}
		sc.close();
		this.readMeasurementData(x);
	}
	
	private void readMeasurementData(int dataType) {
		if (dataType == 1) {
			this.readMetricData();
		} else {
			this.readImperialData();
		}
		
	}
	
	private void readMetricData() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Please enter your weight in Kilograms: ");
		this.weight = sc.nextDouble();
	}
	
	private void readImperialData() {
		
	}
	
	public void calculateBmi() {
		
	}
	
	private void calculateBmiCategory() {
		
	}
	
	public void displayBmi() {
		
	}
	
	
	public static void main(String[] args) {
		BMICalculator bmi = new BMICalculator();
		bmi.readUnitType();
	}
	
	
}