package com.zqy20191009;

import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class draw {
	public void show(){
		JFrame Frame=new JFrame();
		
		Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Frame.setSize(1000,1000);
		Frame.setLocationRelativeTo(null);
		
		drawListener m=new drawListener();
//		Frame.addMouseListener(m);
//		Frame.addMouseMotionListener(m);
				
		JPanel North=new JPanel();
		Frame.add(North,BorderLayout.NORTH);
		
		JPanel Center=new JPanel();
		Center.setBackground(Color.white);
		Center.addMouseListener(m);
		Center.addMouseMotionListener(m);
		Frame.add(Center,BorderLayout.CENTER);
		
		String[] name={"ֱ��","����","Բ��","����","����2","���","л����˹��������","���ж��߼�","���ж����μ�","�Ÿ���"};
		for(int a=0;a<name.length;a++){
			JButton btn=new JButton(name[a]);
			North.add(btn);
			btn.addActionListener(m);
		}
		Frame.setVisible(true);
		Graphics Location = Frame.getGraphics();
		m.n=Location;
	}
	public static void main(String[] args){
		draw ui=new draw();
		ui.show();
	}	
}
