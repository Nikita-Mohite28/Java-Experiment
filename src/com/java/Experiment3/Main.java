package com.java.Experiment3;

public class Main {

	 public static void main(String[] args) { 
	        Manager mngr = new Manager("Nikita", 28 , 70000, 20000); 
	        Employee emp = new Employee("Vijaya", 23 , 60000); 
	 
	        emp.displayInfo(); 
	        System.out.println("Employee Salary: " + emp.calculateSalary()); 
	 
	        mngr.displayInfo(); 
	        System.out.println("Manager Salary: " + mngr.calculateSalary()); 
	 
	        emp.updateEmployeeData("Sanika");       
	        emp.updateEmployeeData(22);   
	        emp.updateEmployeeData(60000); 
	    } 
	} 


