package com.fightinguponthesky;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

public class Myplane implements Entity{

	int x=250;
	int y=1850;
	int code;//����KeyListener�ļ��
	int c=0;//��ʼ��ʱ�ǵ�������1��ʾ����
	int s=0;//�����ٶ��ж� 0��ԭ�٣��Ե�prop1���ɱ���s=1,�Ե�prop2������s=2
	int a=0;//���ڳԵ�prop3��ʱ���ӵ�����,��ǰ���ӵ��������2֮���ӵ��������ҵľ���
	int speed=10;//��Ӧs��ԭ����10
	int m;//���ڽ���prop������  0:�ӵ������ӱ�, 1:�������, 2:myplane����, 3:�ӵ�������ǰ��������Ų��ŵ��ӵ�
	int score=0;//����
	boolean death=false;//�ɻ�ײ��֮��ֹͣ�ӵ�
	Image image=new ImageIcon("myplane.png").getImage();
	
	public void move() {
		if(code == KeyEvent.VK_SPACE){
//			System.out.println("�û���space");		
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
//		System.out.println("ײ����");
		death=true;
	}
	
}
