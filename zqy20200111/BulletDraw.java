package com.zqy20200111;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
//import javax.swing.ImageIcon;

public class BulletDraw extends Thread{
	private ArrayList<Bullet> bulstraight;
	private ArrayList<Bullet> bulleft;
	private ArrayList<Bullet> bulright;
	
	private Bullet[] myplane;
	private Graphics g;

	int x;
	int y;
	
	
	public BulletDraw(ArrayList<Bullet> bulstraight,ArrayList<Bullet> bulleft,ArrayList<Bullet> bulright,Bullet[] myplane,Graphics g){
		this.bulstraight=bulstraight;
		this.bulleft=bulleft;
		this.bulright=bulright;
		this.g=g;
		this.myplane=myplane;
		
	}
	
	public void run(){
		while(true){
			
//		System.out.print("draw±»Ö´ÐÐ");
//		for(int i=0;i<bulstraight.size();i++){
//			Bullet bb=bul.get(i);
//			System.out.println();
//			System.out.println(i+" "+bb.x+" "+bb.y);
//		}
		for(int i=0;i<bulstraight.size();i++){
			
			Bullet bs=bulstraight.get(i);
			Bullet bl=bulleft.get(i);
			Bullet br=bulright.get(i);
			Bullet mp=myplane[0];
			
			
			mp.drawmyplane(g);	
			
			g.setColor(new Color(0,0,0));
			bs.drawbul(g);
			bl.drawbul(g);
			br.drawbul(g);	
			
		}
		
			try{
				Thread.sleep(15);
			}catch(Exception e){
				
			}
			
			g.setColor(new Color(238,238,238));
			g.fillRect(0, 70, 1000, 930);
			g.fillRect(0, 0, 460, 70);
			g.fillRect(540, 0, 460, 70);
			
		}
		
	}
}
