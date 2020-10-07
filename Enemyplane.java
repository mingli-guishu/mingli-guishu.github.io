package com.fightinguponthesky;

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;

public class Enemyplane implements Entity{
	int x;
	int y=600;
	Random rand=new Random();
	ArrayList<Entity> list;
	int a=rand.nextInt(2);//敌军速度判定	
	Image image=new ImageIcon("enemyplane.png").getImage();
	Myplane mp;
	int blood=2;//表示血量，每个敌机要接受两发子弹
	
	public Enemyplane(Myplane mp){ 
		this.mp=mp;
		Random randy=new Random();
		this.x=randy.nextInt(340)+80;
	}
	
	public void move() {
		
 		if(a==0){
			y+=2;
		}else if(a==1){
			y+=4;
		}
	}
	
	public void draw(Graphics g) {
		g.drawImage(image, x, y, 90, 90, null);
		
	}
	
	public int getX() {
		return x;
	}

	
	public int getY() {
		return y;
	}

	
	public void hit(int i) {		
		if(blood==2){
			blood--;
		}else if(blood==1){
			list.remove(i);
			mp.score+=10;
		}
		
	}

}
