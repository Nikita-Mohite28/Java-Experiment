package com.java.Experiment3;

public class Manager extends Employee {
	 double bonus; 
	 
	    public Manager(String name, int age, double baseSalary, double bonus) {    
	    	super(name, age, baseSalary);       
	    	this.bonus = bonus; 
	    } 
	 
	    public double calculateSalary() { 
	        return baseSalary + bonus;  
	    } 
	} 

