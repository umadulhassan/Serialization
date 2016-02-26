/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
	public static void main(String[] args){
		//Taking user name and details
                 Scanner user_input = new Scanner(System.in);
                 System.out.println("Enter your Name");
                 String namee = user_input.nextLine();
                 System.out.println("Enter your Notes");
                 String note = user_input.nextLine();
                
		
		Details data = new Details(namee, note);
		
		//Networking stuff
		String serverName = "localhost";
		int port = 6000;
		
		try{
			Socket sSocket = new Socket(serverName, port);
			//DataOutputStream toServer = new DataOutputStream(sSocket.getOutputStream());
			
			InputStream fromServer = sSocket.getInputStream();
			OutputStream toServer = sSocket.getOutputStream();
			DataInputStream in = new DataInputStream(fromServer);
			
			ObjectOutputStream oos = new ObjectOutputStream(toServer);
			oos.writeObject(data);
			
			//toServer.writeUTF("Sup, I'm a client");
			System.out.println("Server says: " +in.readUTF());
			
			sSocket.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}