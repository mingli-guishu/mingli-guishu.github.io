package com.zqy20191123;

import java.awt.FlowLayout;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JButton;

public class Redraw extends JFrame{
	Shape[] Shapeamount=new Shape[100];
	
	private void showUI(){
		this.setSize(1000,1000);
		this.setLocationRelativeTo(null);
		this.setLayout(new FlowLayout());
		
		JButton btnRect=new JButton("矩形");
		this.add(btnRect);	
		
		this.setVisible(true);
		
		DrawListener dl=new DrawListener();
		btnRect.addActionListener(dl);
		this.addMouseListener(dl);
		
		Graphics g = getGraphics();
		dl.g=g;  
		dl.Shapeamount=Shapeamount;
	}
	
	
	public void paint(Graphics g) {
		super.paint(g);// 保持父类的方法内容不变 
		for(int i=0;i<Shapeamount.length;i++) {
			// 遍历数组 取出图形对象
			Shape shape= Shapeamount[i];
			// 使用图形对象来绘制 
			shape.drawshape(g);
		}
	}
	
	public static void main (String[] args){
		Redraw draw=new Redraw();
		draw.showUI();
	}
}
