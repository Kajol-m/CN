package cn_project_10;

import java.util.*;
import java.io.*;
import java.net.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class my_server{
	
	
	public static void main(String[] args)throws UnknownHostException,IOException {
		try {
			ServerSocket ss=new ServerSocket(6666);
			Socket s=ss.accept();
			System.out.println("Connected");
			
			 DataInputStream inputStream = new DataInputStream(s.getInputStream());
			 String fileName = inputStream.readUTF();
	         long fileSize = inputStream.readLong();
			 FileOutputStream fileOutputStream = new FileOutputStream("received_" + fileName);
	         BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);

	            // Receive file contents in chunks
	            byte[] buffer = new byte[4096];
	            int bytesRead;
	            long totalBytesRead = 0;
	            while ((bytesRead = inputStream.read(buffer)) != -1) {
	                bufferedOutputStream.write(buffer, 0, bytesRead);
	                totalBytesRead += bytesRead;
	                System.out.println("Received " + totalBytesRead + " bytes...");
	            }

	            // Close streams and socket
	            bufferedOutputStream.close();
	            inputStream.close();
	            s.close();
	            System.out.println("File received successfully!");
					}
		catch (IOException e) {
			e.printStackTrace();
		}
		
	}


}
