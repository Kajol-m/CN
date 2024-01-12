package cn_project10;

import java.util.*;
import java.io.*;
import java.net.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class Server {
	

	public static void main(String[] args)throws UnknownHostException,IOException {
		try {
			ServerSocket ss=new ServerSocket(6667);
			while(true) {
			Socket s=ss.accept();
			System.out.println("Connected");
			
			
			File filesend=new File("C:\\Users\\kajol\\Downloads\\Hello.txt");
			String fileName = filesend.getName();
	        long fileSize = filesend.length();
			
			DataOutputStream outputStream = new DataOutputStream(s.getOutputStream());
			outputStream.writeUTF(fileName);
	        outputStream.writeLong(fileSize);
	        
	        //sends file to client
			FileInputStream fileInputStream= new FileInputStream(filesend);//reads file content
			BufferedInputStream bin = new BufferedInputStream(fileInputStream);
	        byte[] buffer = new byte[4096];
	        int bytesRead;
	        while ((bytesRead = bin.read(buffer)) != -1) {
	            outputStream.write(buffer, 0, bytesRead);
	        }
	        
	        bin.close();
	        outputStream.close();
	        s.close();
	        System.out.println("File sent successfully!");
	        
	        
	        
		}}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}


