package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;
import entities.OutsourcedEmployee;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Employee> emp = new ArrayList<Employee>();
		
		System.out.print("Enter the number of employees: ");
		int employees = sc.nextInt();
		for (int control = 1; control <= employees; control++) {
			System.out.println("Employee #" + control + " data: ");
			System.out.print("Outsourced (y/n)? ");
			sc.nextLine();
			char decision = sc.nextLine().charAt(0);
			System.out.print("Name: ");
			String name = sc.nextLine();
			System.out.print("Hours: ");
			int hours = sc.nextInt();
			System.out.print("Value per hour: ");
			double valuePerHour = sc.nextDouble();
			if(decision == 'n') {
				emp.add(new Employee(name, hours, valuePerHour));
			}
			else if (decision == 'y') {
				System.out.print("Additional charge: ");
				double additionalCharge = sc.nextDouble();
				emp.add(new OutsourcedEmployee(name, hours, valuePerHour, additionalCharge));
			}
		}
		
		System.out.println();
		System.out.println("PAYMENTS:");
		for (Employee obj : emp) {
			System.out.println(obj.getName() + " - $ " + obj.payment());
		}
		
		sc.close();
		
	}
	
}
