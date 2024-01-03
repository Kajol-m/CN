package cn_project_10;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class clientGUI extends JFrame implements ActionListener {
	private my_client client;

	public clientGUI(my_client my_client) {
		super("my_client");
		this.client=my_client;
		
		JPanel panel=new JPanel();
		
		panel.setBorder(BorderFactory.createEmptyBorder(50,50,10,50));
		panel.setLayout(new GridLayout(0,1));
		
		JTextField reqHelp=new JTextField();
		reqHelp.setBounds(100,100,100,100);
		reqHelp.setEditable(false);
        
		
		JButton button=new JButton("Request for Help");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				reqHelp.setText("Server:A computer program or dedicated hardware that provides resources and services to other computers (clients) over a network.                                 Client:A computer program or device that requests and utilizes resources and services provided by a server over a network.");
				
			}
		});
		panel.add(button);
		//panel.add(reqHelp);
		panel.add(new JScrollPane(reqHelp), BorderLayout.SOUTH);
		
		add(panel,BorderLayout.CENTER);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("HELP!!");
		pack();
		setVisible(true);
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			my_client client=new my_client();
			clientGUI a=new clientGUI(client);
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	
}
