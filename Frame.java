package com.fightinguponthesky;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;

public class Frame implements KeyListener {
	
	ArrayList<Prop> listprop=new ArrayList<Prop>();
	ArrayList<Entity> listmybullet =new ArrayList<Entity>();
	ArrayList<Entity> listenemy =new ArrayList<Entity>();
	ArrayList<Boss> listboss=new ArrayList<Boss>();
	ArrayList<Entity> listbossbullet=new ArrayList<Entity>();
	
	Myplane mp=new Myplane();
	Background bg=new Background();
	Label ll=new Label(mp);
	public void UI(){
		
		JFrame frame=new JFrame();
		frame.setSize(500, 1000);
		frame.setDefaultCloseOperation(3);
		
		frame.setVisible(true);
		
		frame.addKeyListener(this);
		
		Graphics g=frame.getGraphics();
		
		EnemyplaneMove em=new EnemyplaneMove(listenemy, listboss, mp);
		em.start();
		
		MyBulletMove bm=new MyBulletMove(listmybullet, mp);
		bm.start();
		
		Checkforcrash cc=new Checkforcrash(listenemy,listmybullet,listprop,listboss,mp);
		cc.start();
		
		
		//为Boss设置run方法
		Timer timerboss=new Timer();
		TimerTask ttboss=new TimerTask(){
			public void run(){
				Boss b=new Boss(listboss, mp);
				listboss.add(b);
				b.list=listboss;
			}
		};
		timerboss.schedule(ttboss, 100000, 110000);//100000,110000
		
		//为道具设置run方法
		Timer timerprop =new Timer();
		TimerTask ttprop=new TimerTask(){
			public void run(){
				Prop pp=new Prop();
				pp.mp=mp;
				listprop.add(pp);
				pp.list=listprop;
			}
		};
		timerprop.schedule(ttprop, 20000, 30000);//20000,30000
		
		while(true){
			//创建缓存图片对象
			BufferedImage bufferImage=new BufferedImage(frame.getWidth(),2*frame.getHeight(),BufferedImage.TYPE_INT_RGB);
			
			//从缓存图片获取画布对象
			Graphics bufferedG=bufferImage.getGraphics();
			
			//在所有元素没有画完前,不显示
			bg.draw(bufferedG);
			bg.move();
			for(int i=0;i<listmybullet.size();i++){
				Entity entity=listmybullet.get(i);
				
				entity.draw(bufferedG);
				entity.move();
			}
			for(int i=0;i<listenemy.size();i++){
				Entity entity=listenemy.get(i);
				
				entity.draw(bufferedG);
				entity.move();
			}
			for(int i=0;i<listprop.size();i++){
				Entity entity=listprop.get(i);
				
				entity.draw(bufferedG);
				entity.move();
			}
			for(int i=0;i<listboss.size();i++){
				Entity entity=listboss.get(i);
				
				entity.draw(bufferedG);
				entity.move();
			}
			
			mp.draw(bufferedG);
			
			ll.draw(bufferedG);
			ll.move();
			
			
			//把缓存图片显示出来
			g.drawImage(bufferImage, 0, -1000, null);
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
			}
		}
	}
	public static void main(String[] args) {
		new Frame().UI();
	}
	
	public void keyTyped(KeyEvent e) {		
	}
	
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		mp.code=code;
		mp.move();
	}
	
	public void keyReleased(KeyEvent e) {
		
	}
	

}
