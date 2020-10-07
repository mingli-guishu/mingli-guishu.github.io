package com.fightinguponthesky;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Label implements Entity{
	int x=400;
	int y=1800;	
	Myplane mp;
	Image image0=new ImageIcon("prop0.png").getImage();
	Image image1=new ImageIcon("prop1.png").getImage();
	Image image2=new ImageIcon("prop2.png").getImage();
	Image image3=new ImageIcon("prop3.png").getImage();
	
	public Label(Myplane mp){
		this.mp=mp;
	}
	
	public void move() {
		y+=2;
		
	}

	public void draw(Graphics g) {
		String score=new String("分数:"+mp.score);//分数
		g.drawString(score, 420, 1950);
		if(mp.c==1){
			g.drawImage(image1, 10, 1900, 42, 30, null);
		}
		if(mp.s==1){
			g.drawImage(image0, 52, 1900, 42, 30, null);
		}else if(mp.s==2){
			g.drawImage(image2, 52, 1900, 42, 30, null);
		}
		if(mp.a!=0){
			g.drawImage(image3, 94, 1900, 42, 30, null);
		}
		}
		

	public int getX() {
	
		return 0;
	}
	public int getY() {
		
		return 0;
	}

	public void hit(int i) {		
	}
	
}
