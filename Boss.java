package com.fightinguponthesky;

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Boss implements Entity{
	int x=53;
	int y=700;
	int y1=1050;
	ArrayList<Boss> list;
	Image image=new ImageIcon("boss.png").getImage();
	Myplane mp;
	int blood=100;
	
	public Boss(ArrayList<Boss> listboss,Myplane mp){
		this.list=listboss;
		this.mp=mp;
	}

	public void move() {
		if(y!=y1){
			y+=2;
		}else{
			y+=0;
		}
	}

	public void draw(Graphics g) {
		g.drawImage(image, x, y, 394, 268, null);
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public void hit(int i) {
		blood--;
		if(blood==0){
			mp.score+=1000;
			list.remove(i);
		}
			
		
	}
}
