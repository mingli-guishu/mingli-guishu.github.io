package com.zqy20190928;

import java.awt.FlowLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
//import java.awt.Font;
//import java.awt.Color;

public class Login {
	public void Show(){
		ImageIcon picture=new ImageIcon("login.jpg");
	    JLabel picturelabel=new JLabel(picture);
		JFrame Frame=new JFrame();
		FlowLayout Layout=new FlowLayout();
		JTextField name=new JTextField(40);
		JPasswordField Password=new JPasswordField(40);
		JLabel Findpassword=new JLabel("�һ�����");
	    JLabel Register=new JLabel("ע���˺�");
	    JButton Button=new JButton("��¼");
	    JCheckBox aut=new JCheckBox("�Զ���¼");
	    JCheckBox remember=new JCheckBox("��ס����");
	    
	    //�԰�ť��������
	    //��С
	    Dimension btnSize = new Dimension(450, 35);
	    Button.setPreferredSize(btnSize);
	    //��������
	    //Font font = new Font("����", Font.PLAIN, 25);
	    //Button.setFont(font);
	    //���ñ���ɫ
	    //Color btnBackColor = new Color(100, 100, 255);
	    //Button.setBackground(btnBackColor);
	    //����ǰ��ɫ
	    //Color frontColor = new Color(255, 255, 100);
	    //Button.setForeground(frontColor);
	    
	    //��JLabel�����ִ�С
	    Dimension word=new Dimension(100,25);
	    Register.setPreferredSize(word);
	    Findpassword.setPreferredSize(word);
	    
	    Frame.add(picturelabel);
		Frame.setSize(600,600);
		Frame.setLocationRelativeTo(null);
		Frame.setLayout(Layout);
		
		Frame.add(name);
		Frame.add(Register);
		
		Frame.add(Password);
		Frame.add(Findpassword);
		
		Frame.add(aut);
		Frame.add(remember);
		
		Frame.add(Button);
		

	    //�������Ķ���
	    LoginListener loginL=new LoginListener ();
	    //����ť��Ӽ�����
	    Button.addActionListener(loginL);
	    //��ȡ�ı��������
	    loginL.name=name;
	    loginL.key=Password;
	    //�رմ���
	    loginL.close=Frame;
	    
		Frame.setVisible(true);
	}
	public static void main(String[] args){
		Login ui=new Login();
		ui.Show();
				
	}
}
