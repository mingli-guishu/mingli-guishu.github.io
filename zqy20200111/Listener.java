package com.zqy20200111;


import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.awt.Graphics;

public class Listener implements MouseListener{
	int x;
	int y;
	Graphics g;
	BulletDraw bd;
	private Bullet[] myplane;
	
	private ArrayList<Bullet> bulstraight;
	private ArrayList<Bullet> bulleft;
	private ArrayList<Bullet> bulright;
	public Listener(ArrayList<Bullet> bulstraight,ArrayList<Bullet> bulleft,ArrayList<Bullet> bulright,Bullet[] myplane){
		this.bulstraight=bulstraight;
		this.bulleft=bulleft;
		this.bulright=bulright;
		this.myplane=myplane;
		
		
	}
	
	public void mouseClicked(MouseEvent e) {		
	}

	public void mousePressed(MouseEvent e) {
		
	}

	public void mouseReleased(MouseEvent e) {
		//���¾��ڶ������һ���ӵ�
				x=e.getX();
				y=e.getY();
				bd.x=x;
				bd.y=y;
//				System.out.println(x+" "+y);
//				System.out.println("�Ž�ȥ��");
				Bullet b1=new Bullet(x,y);
				Bullet b2=new Bullet(x,y);
				Bullet b3=new Bullet(x,y);
				Bullet mp=new Bullet(x,y);
				this.bulstraight.add(b1);
				this.bulleft.add(b2);
				this.bulright.add(b3);
				this.myplane[0]=mp;
				
//				for(int i=0;i<bul.size();i++){
//					Bullet bb=bul.get(i);
//					System.out.println(i+" "+bb.x+" "+bb.y);
//				}
				
	}

	
	public void mouseEntered(MouseEvent e) {	
	}

	public void mouseExited(MouseEvent e) {
	}

	
	
		
	

}
