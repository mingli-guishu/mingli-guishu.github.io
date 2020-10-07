package com.fightinguponthesky;

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Bullet implements Entity{
	
	int m;//0��ʾ�ӵ����Ϸɣ�1��ʾ�ӵ������Ϸɣ�2��ʾ�ӵ������Ϸ�
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
		//�Ƴ�����
		list.remove(i);
	}

	
	public int getX() {		
		return x;
	}

	
	public int getY() {		
		return y;
	}

	

}
