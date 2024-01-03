package cn_project_10;

import java.util.*;
import java.io.*;
import java.net.*;
import javax.swing.*;
import java.awt.*;

public class my_client {
	public static void main(String[] args)throws UnknownHostException,IOException{
		try {
			Socket s=new Socket("localhost",6666);
			
			File filesend=new File("C:\\Users\\kajol\\OneDrive\\Desktop\\cnl.docx");
			String fileName = filesend.getName();
	        long fileSize = filesend.length();
			
			DataOutputStream outputStream = new DataOutputStream(s.getOutputStream());
			outputStream.writeUTF(fileName);
	        outputStream.writeLong(fileSize);
	        
			FileInputStream fileInputStream= new FileInputStream(filesend);
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
			
			
		}
		 catch (Exception e) {
			e.printStackTrace();
		}
	}

}
