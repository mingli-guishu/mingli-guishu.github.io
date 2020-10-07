package com.zqy20200111;

import java.awt.Graphics;
import java.util.Random;

import javax.swing.ImageIcon;

public class Bullet {
	public int x;
	public int y;
	public int r=20;
	int a;int b;
	Graphics g;
	public Bullet(int x,int y){
		this.x=x;
		this.y=y;
		
		if(x>1400){
			x=1400;
		}
		/*
		 * this.参数 即当前类的属性，即方法里的x值赋给当前类的x
		 */
	}
	
	public void straight(){
		y-=10;
	}
	
	public void left(){
		x-=3;
		y-=8;
	}
	
	public void right(){
		x+=3;
		y-=8;
	}
	
	public void drawbul(Graphics g){
		g.fillOval( x, y, r, r);
//		g.drawImage(new ImageIcon("myplane.png").getImage(), x-40, y-40, 80, 80, null);
	}
	
	public void drawmyplane(Graphics g){
		g.drawImage(new ImageIcon("myplane.png").getImage(), x-40, y-40, 80, 80, null);
	}
	
	public void enemyplanelocation(){
		Random r=new Random();
		a=r.nextInt(800)+100;
		Random ra=new Random();
		b=ra.nextInt(100)+70;
	}
	
	public void drawenemyplane(Graphics g){
		g.drawImage(new ImageIcon("enemyplane.png").getImage(), a, b, 100, 100, null);
	}
}
