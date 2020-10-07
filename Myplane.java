package com.fightinguponthesky;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

public class Myplane implements Entity{

	int x=250;
	int y=1850;
	int code;//用于KeyListener的检测
	int c=0;//初始化时是单发弹，1表示三向弹
	int s=0;//用于速度判断 0是原速，吃到prop1后变成倍速s=1,吃到prop2后变减速s=2
	int a=0;//用于吃到prop3的时候子弹翻倍,当前端子弹数量变成2之后，子弹向左向右的距离
	int speed=10;//照应s，原速是10
	int m;//用于接受prop的类型  0:子弹数量加倍, 1:变成三向弹, 2:myplane减速, 3:子弹翻倍，前面射出两颗并排的子弹
	int score=0;//分数
	boolean death=false;//飞机撞到之后，停止子弹
	Image image=new ImageIcon("myplane.png").getImage();
	
	public void move() {
		if(code == KeyEvent.VK_SPACE){
//			System.out.println("敲击了space");		
		}
		
		if(code==KeyEvent.VK_UP){
			if(s==0){
				y-=speed;
			}else if(s==1){
				y-=speed*2;
			}else if(s==2){
				y-=speed/2;
			}
		}
		
		if(code==KeyEvent.VK_DOWN){
			if(s==0){
				y+=speed;
			}else if(s==1){
				y+=speed*2;
			}else if(s==2){
				y+=speed/2;
			}
		}
		
		if(code==KeyEvent.VK_LEFT){
			if(s==0){
				x-=speed;
			}else if(s==1){
				x-=speed*2;
			}else if(s==2){
				x-=speed/2;
			}
		}
		
		if(code==KeyEvent.VK_RIGHT){
			if(s==0){
				x+=speed;
			}else if(s==1){
				x+=speed*2;
			}else if(s==2){
				x+=speed/2;
			}
		}
		
	}
	
	public void draw(Graphics g) {
		g.drawImage(image, x-44, y, null);
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void hit(int i){
//		image=new ImageIcon("boom1.png").getImage();
//		System.out.println("撞上了");
		death=true;
	}
	
}
