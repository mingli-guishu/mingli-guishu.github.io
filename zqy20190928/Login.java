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
		JLabel Findpassword=new JLabel("找回密码");
	    JLabel Register=new JLabel("注册账号");
	    JButton Button=new JButton("登录");
	    JCheckBox aut=new JCheckBox("自动登录");
	    JCheckBox remember=new JCheckBox("记住密码");
	    
	    //对按钮进行设置
	    //大小
	    Dimension btnSize = new Dimension(450, 35);
	    Button.setPreferredSize(btnSize);
	    //设置字体
	    //Font font = new Font("宋体", Font.PLAIN, 25);
	    //Button.setFont(font);
	    //设置背景色
	    //Color btnBackColor = new Color(100, 100, 255);
	    //Button.setBackground(btnBackColor);
	    //设置前景色
	    //Color frontColor = new Color(255, 255, 100);
	    //Button.setForeground(frontColor);
	    
	    //对JLabel的文字大小
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
		

	    //监听器的对象
	    LoginListener loginL=new LoginListener ();
	    //给按钮添加监听器
	    Button.addActionListener(loginL);
	    //获取文本框的内容
	    loginL.name=name;
	    loginL.key=Password;
	    //关闭窗体
	    loginL.close=Frame;
	    
		Frame.setVisible(true);
	}
	public static void main(String[] args){
		Login ui=new Login();
		ui.Show();
				
	}
}
