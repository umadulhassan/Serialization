package lab3;
import java.net.*;
import java.io.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Umad Rai
 */
public class Details implements Serializable{
    public String name;
    public String notes;
    public Details(String n, String notess){
        this.name = n;
        this.notes = notess;
    }
}
