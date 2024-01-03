package cn_project_10;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.File;

public class serverGUI extends JFrame implements ActionListener{
	private JTextField folderName;
	private JTextArea messageText;
	private my_server server;
	public serverGUI(my_server my_server) {
		//JFrame frame=new JFrame();
		
		super("my_server");
		this.server=my_server;
		JButton button1=new JButton("Create Folder");
		button1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				createFolder();
			}
		});
		
		JButton button2=new JButton("Rename Folder");
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				renameFolder();
			}
		});
		
		JPanel panel=new JPanel();
		JPanel buttonpanel=new JPanel();
		
		panel.setBorder(BorderFactory.createEmptyBorder(50,50,10,50));
		panel.setLayout(new GridLayout(0,1));
		panel.add(new JLabel("FolderName: "));
		folderName=new JTextField(20);
		panel.add(folderName);
		
		buttonpanel.add(button1);
		buttonpanel.add(button2);
		
		
		
		messageText = new JTextArea(3, 10);
        messageText.setEditable(false);
        add(new JScrollPane(messageText), BorderLayout.SOUTH);
		
		add(panel,BorderLayout.NORTH);
		add(buttonpanel,BorderLayout.CENTER);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Operation on Folder");
		pack();
		setVisible(true);
		
		
	}
	
	
	public void createFolder() {
		String fName=folderName.getText();
		File folder=new File(fName);
		try {
			if(folder.mkdir()) {
				messageText.setText("Folder was created successfully");
				
			}
			else {
				messageText.setText("Failed");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	private void renameFolder() {
		JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int result = chooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFolder = chooser.getSelectedFile();
            String newFolderName = folderName.getText();
            File newFolder = new File(selectedFolder.getParentFile(), newFolderName);
            try {
                if (selectedFolder.renameTo(newFolder)) {
                    messageText.setText("Folder renamed successfully.");
                } else {
                    messageText.setText("Failed to rename folder.");
                }
            } catch (Exception ex) {
                messageText.setText("Error: " + ex.getMessage());
            }
        }
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			my_server server=new my_server();
			serverGUI a=new serverGUI(server);
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
