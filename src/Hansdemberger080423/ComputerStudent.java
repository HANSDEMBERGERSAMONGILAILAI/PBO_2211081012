/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hansdemberger080423;

/**
 *
 * @author HP
 */
import Hansdemberger080423.StudentRecord;
public class  ComputerStudent extends StudentRecord {
    private double compGrade;
    public ComputerStudent(){
        super("Ali", "Padang");
        System.out.println("InsideComputerStudent constructor");
    }
    public double getCompGrade(){
        return compGrade;
    }
    public void setCompGrade(double cGrade){
        this.compGrade = cGrade;
    }
    @Override
    public double getAverage(){
        return (getMathGrade() +getEnglishGrade() + getScienceGrade() + getCompGrade())/4;
    }
}

