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
			Socket s=new Socket("localhost",6667);
			
			DataInputStream inputStream = new DataInputStream(s.getInputStream());
			 String fileName = inputStream.readUTF();
	         long fileSize = inputStream.readLong();
	         
	         //receive file from server
			 FileOutputStream fileOutputStream = new FileOutputStream(fileName);//writes file content
	         BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);

	            // Receive file contents in chunks
	            byte[] buffer = new byte[4096];
	            int bytesRead;
	            while ((bytesRead = inputStream.read(buffer)) != -1) {
	                bufferedOutputStream.write(buffer, 0, bytesRead);
	          
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
