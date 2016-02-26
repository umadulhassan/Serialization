/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3_server;
import java.net.*;
import java.io.*;


public class Server {
	public static void main(String[] args) throws IOException, ClassNotFoundException{
		int port = 6000;
		
		
		try{
                    ServerSocket listener = new ServerSocket(port);
			while(true){
				Socket cSocket = listener.accept();
				DataOutputStream out = new DataOutputStream(cSocket.getOutputStream());
				
				ObjectInputStream ois = new ObjectInputStream(cSocket.getInputStream());
				Details tempNote = (Details)ois.readObject();
				if(tempNote != null){
					System.out.println(tempNote.name +" \nDetails: " +tempNote.notes);
				}
				else{
					System.out.println("Object reading error");
				}
				out.writeUTF("Successfull Recieved");
				cSocket.close();
			}
		} catch(IOException e){
			e.printStackTrace();
		}
		

	}
}
