package com.zqy20191123;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class DrawListener implements ActionListener,MouseListener{
	int x1,y1,x2,y2;
	int count=0;
	Graphics g;
	String btnstr;
	Shape[] Shapeamount;
	
	public void mousePressed(MouseEvent e) {
		x1 = e.getX();
    	y1 = e.getY();
	}
	 public void mouseReleased(MouseEvent e) {
		x2 = e.getX();
	    y2 = e.getY();
	    
	    if(btnstr.equals("矩形")){
	    	
	    	g.drawRect(Math.min(x2, x1), Math.min(y1, y2), Math.abs(x2-x1), Math.abs(y2-y1));
	    
	    	Shape shape = new Shape();//创建图形对象
	    	shape.x1=x1;
	    	shape.x2=x2;
	    	shape.y1=y1;
	    	shape.y2=y2;
	    	shape.Shapename=btnstr;
	    	shape.drawshape(g);
	    	Shapeamount[count]=shape;//保存
	    	count++;
	    }
	 }
	 public void actionPerformed(ActionEvent e) {
			btnstr= e.getActionCommand();
			
	 }
	 public void mouseEntered(MouseEvent e) {}
	 public void mouseExited(MouseEvent e) {}
	 @Override
	 public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}	 
}
