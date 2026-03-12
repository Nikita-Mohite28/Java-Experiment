package com.java.Experiment2; 
 
class Student { 
    int id; 
    String name;   
    double marks; 
    String course; 
 
    Student(int id, String name, double marks, String course) {      
    	this.id = id;       
    	this.name = name;       
    	this.marks = marks; 
        this.course = course; 
    } 
 
    public String toString() { 
        return "ID: " + id + ", Name: " + name + ", Marks: " + marks + ", Course: " + course; 
    } 
} 

 
 
 
 
 
 
