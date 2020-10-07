package com.zqy20200111;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;


public class Frame extends JFrame{
	Graphics g;
	private Bullet[] myplane=new Bullet[1];
	
	private ArrayList<Bullet> bulstraight=new ArrayList<Bullet>();
	private ArrayList<Bullet> bulleft=new ArrayList<Bullet>();
	private ArrayList<Bullet> bulright=new ArrayList<Bullet>();
	public void UI(){
		this.setSize(1000,1000);
//		this.setLocationRelativeTo(null);
				
		Listener l=new Listener(bulstraight,bulleft,bulright,myplane);
		
		this.addMouseListener(l);
		
		this.setLayout(new FlowLayout());
		
		JButton btn=new JButton("ÔÝÍ£");		
		this.add(btn);		
		
		Dimension d=new Dimension(80,27);
		btn.setPreferredSize(d);
		
		this.setVisible(true);
				
		Graphics g=this.getGraphics();
		l.g=this.g;
		
		BulletMove bm=new BulletMove(bulstraight,bulleft,bulright);
		bm.start();
		
		
		BulletDraw bd=new BulletDraw(bulstraight,bulleft,bulright,myplane,g);
		bd.start();
		
		l.bd=bd;
		
		ActionLis al=new ActionLis(bm);
		btn.addActionListener(al);
		
	}
	
	public static void main(String[] args){
		Frame Fra=new Frame();
		Fra.UI();
		
	}
		
}
