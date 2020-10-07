package com.fightinguponthesky;

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Bullet implements Entity{
	
	int m;//0表示子弹向上飞，1表示子弹向左上飞，2表示子弹向右上飞
	int x;
	int y;
	Image image=new ImageIcon("bullet1.png").getImage();
	
	ArrayList<Entity> list;
	
	public void move() {
		if(m==0){
			y-=9;
		}else if(m==1){
			y-=7;
			x-=2;
		}else if(m==2){
			y-=7;
			x+=2;
		}
		
		
	}
	
	public void draw(Graphics g) {
		g.drawImage(image, x, y, null);
		
	}
	
	public void hit(int i){
		//移除队列
		list.remove(i);
	}

	
	public int getX() {		
		return x;
	}

	
	public int getY() {		
		return y;
	}

	

}
