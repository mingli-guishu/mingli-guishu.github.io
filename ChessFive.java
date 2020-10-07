package com.chessfive;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ChessFive extends JFrame{
	int type[][]=new int[18][18];
	int height=50;
	int width=50;
	public void showUI(){		
		Listener l=new Listener();	
		JButton btn=new JButton("»ÚÆå");
		this.add(btn);
		btn.addActionListener(l);
		FlowLayout fl=new FlowLayout();
		this.setLayout(fl);
		this.setSize(1000,1000);
		this.setVisible(true);	
		this.addMouseListener(l);
		this.setLocationRelativeTo(null);
		l.type=type;
		l.JFr=this;
	}	
	
	public void paint(Graphics g) {		
		super.paint(g);
//		g.setColor(Color.ORANGE);
//		g.drawLine(50, 50, 950, 50);
//		g.drawLine(50, 100, 950, 100);
//		g.drawLine(950, 50, 950, 100);
		for (int i=0;i<18;i++){
//			g.setColor(Color.BLACK);
			g.drawLine(75+i*width, 75, 75+i*width, 925);//ÊúÏß
			g.drawLine(75, 75+i*height, 925, 75+i*height);//ºáÏß
			
//			g.setColor(Color.ORANGE);
//			g.drawLine(50+i*50, 50, 50+i*50, 100);
		}
		for(int i=0;i<18;i++){
			for(int j=0;j<18;j++){
				int t=type[i][j];
				if(t==1){//ºÚÆå
					g.setColor(Color.BLACK);
					g.fillOval(75+i*width-10, 75+j*height-10, 20, 20);
				}else if(t==2){//°×Æå
					g.setColor(Color.WHITE);
					g.fillOval(75+i*width-10, 75+j*height-10, 20, 20);
				}
			}
		}
	}
	public static void main (String[] args){
		ChessFive ui=new ChessFive();
		ui.showUI();		
	}
}
