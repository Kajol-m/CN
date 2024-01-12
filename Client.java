package cn_project10;
import java.util.*;
import java.io.*;
import java.net.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Client {
	public static void main(String[] args)throws UnknownHostException,IOException{
		try {
			Socket s=new Socket("localhost",6667);//creates socket object ie. Client to connect to server
			
			DataInputStream inputStream = new DataInputStream(s.getInputStream());//create input stream to receive data from server
			 String fileName = inputStream.readUTF();//receive file name
	         long fileSize = inputStream.readLong();//receive file size
	         
	         //receive file from server
			 FileOutputStream fileOutputStream = new FileOutputStream(fileName);//writes received content to file
	         BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);//wraps in buffer

	            // Receive file contents in chunks
	            byte[] buffer = new byte[4096];//creates buffer
	            int bytesRead;
	            while ((bytesRead = inputStream.read(buffer)) != -1) {//read file chunks
	                bufferedOutputStream.write(buffer, 0, bytesRead);//writes file content to client
	          
	            }

	            // Close streams and socket
	            System.out.println(fileName+" File received successfully!");
	            bufferedOutputStream.close();
	            inputStream.close();
	            s.close();
	            
	            
	            
	       
	            
					
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}

}
