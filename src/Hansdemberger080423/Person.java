/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hansdemberger080423;

/**
 *
 * @author HP
 */
public class Person {
    protected String name; 
    protected String address; 

public Person(){ 
    System.out.println("Inside Person:Constructor"); 
    this.name = ""; 
    this.address = ""; 
} 

 /** 
 * Constructor dengan dua parameter 
 */ 
public Person( String name, String address ){ 
    this.name = name; 
    this.address = address; 
    } 
 /** 
 * Method accessor 
 */ 

 public String getName(){ 
     System.out.println("Person  :   getName");
    return name; 
 } 
public String getAddress(){ 
    return address; 
 } 
 public void setName( String name ){ 
    this.name = name; 
 } 
 public void setAddress( String add ){ 
    this.address = add; 
 }
}