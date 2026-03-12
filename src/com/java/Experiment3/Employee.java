package com.java.Experiment3;

	public class Employee extends Person { 
	    double baseSalary; 
	 
	    public Employee(String name, int age, double baseSalary) {     
	    	super(name, age);       
	    	this.baseSalary = baseSalary; 
	    } 
	 
	    public double calculateSalary() { 
	        return baseSalary ;  
	    } 
	      
	    public void updateEmployeeData(String newName) {    
	    	this.name = newName;
	        System.out.println("Updated Name: " + name); 
	    } 
	 
	    public void updateEmployeeData(int newAge) {     
	    	this.age = newAge; 
	        System.out.println("Updated Age: " + age ); 
	    } 
	 
	    public void updateEmployeeData(double newSalary) {    
	    	this.baseSalary = newSalary; 
	        System.out.println("Updated Salary: " + baseSalary); 
	    } 
	} 
