package com.fightinguponthesky;

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;

public class Prop implements Entity{	
	ArrayList<Prop> list;
	Myplane mp;
	Random rand=new Random();
	int m=rand.nextInt(4);//判定道具的用处  0:移动速度加倍, 1:变成三向弹, 2:myplane减速, 3:子弹翻倍，前面射出两颗并排的子弹
						  //4:(如果是三向弹)变成单向
	Image image0=new ImageIcon("prop0.png").getImage();
	Image image1=new ImageIcon("prop1.png").getImage();
	Image image2=new ImageIcon("prop2.png").getImage();
	Image image3=new ImageIcon("prop3.png").getImage();
	int x=rand.nextInt(340)+80;
	int y=600;
	
	public void move() {
		y+=6;
	}

	public void draw(Graphics g) {		
		if(m==1){
			g.drawImage(image1, x, y, 42, 30, null);
		}else if(m==0){
			g.drawImage(image0, x, y, 42, 30, null);
		}else if(m==2){
			g.drawImage(image2, x, y, 42, 30, null);
		}else if(m==3){
			g.drawImage(image3, x, y, 42, 30, null);
		}
		
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void hit(int i) {
		list.remove(i);
	
	}
	

}
