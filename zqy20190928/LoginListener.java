package com.zqy20190928;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JFrame;
import java.awt.FlowLayout;

public class LoginListener implements ActionListener{
	JFrame close;
	JTextField name;
	JPasswordField key;
	JFrame newFrame=new JFrame();
	
	public void newShow(){
		JFrame newFrame=new JFrame();
		FlowLayout newLayout=new FlowLayout();
		
		newFrame.setSize(700,700);
		newFrame.setLocationRelativeTo(null);
		newFrame.setLayout(newLayout);
		
		newFrame.setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent e){
		//ÊäÈë¿ò
		String Bname=name.getText();
		String Bkey=key.getText();
		
		if(Bname.equals("111")&&Bkey.equals("222")){
			//System.out.println(name+"µÇÂ¼³É¹¦");
			JOptionPane.showMessageDialog(null,Bname+"µÇÂ¼³É¹¦");
			close.dispose();
			LoginListener ui=new LoginListener();
			ui.newShow();
			
		}else{
			JOptionPane.showMessageDialog(null, "µÇÂ¼Ê§°Ü");

			//System.out.println("wrong");
		}
	}
	 
	 

}
