package com.zqy20191009;

import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.Graphics;
import java.awt.Color;

public class drawListener implements MouseListener,MouseMotionListener,ActionListener{
	int startx,starty,endx,endy;
	
	Graphics n;
	
	String name="";
	
	public void actionPerformed(ActionEvent a) {
		name = a.getActionCommand();
//		name=action;
	}	
	public void mousePressed(MouseEvent e) {
    	startx = e.getX();
    	starty = e.getY()+80;
    	if("分形".equals(name)){
    		IFS ifs = new IFS();
    		ifs.ifs(n);   		
    	}
    	if("分形2".equals(name)){
    		IFS2 ifs2=new IFS2();
    		ifs2.ifs2(n);
    	}
    	if("清空".equals(name)){   		
    		n.setColor(Color.WHITE);
    		n.fillRect(0, 80, 1000, 920);
    		n.setColor(Color.BLACK);
    	}
    	if("谢尔宾斯基三角形".equals(name)){
    		Sierpinskitriangle triangle=new Sierpinskitriangle();
    		triangle.triangle(n,5,500,100,900,100,900,900);
    	}
    	if("康托尔线集".equals(name)){
    		CantorLineset clset=new CantorLineset();
    		clset.clset(n,6,100,900,100);
    	}
    	if("康托尔方形集".equals(name)){
    		CantorSquareset csset=new CantorSquareset();
    		csset.csset(n, 3, 100, 100, 900, 900);
    	}
    	if("门格海绵".equals(name)){
    		Mengersponge sponge=new Mengersponge();
    		sponge.smallsquare(n, 4, 50, 950, 630, 220, 220);
    	}
	}
    public void mouseReleased(MouseEvent e) {
        endx = e.getX();
        endy = e.getY()+80;
//      n.drawLine(startx, starty, endx, endy);
        
        if("矩形".equals(name)){
        	n.drawRect(Math.min(endx, startx), Math.min(starty, endy), Math.abs(endx-startx), Math.abs(endy-starty));
    	} 
    	if("圆形".equals(name)){
    		n.drawOval(Math.min(endx, startx), Math.min(starty, endy), Math.abs(endx-startx), Math.abs(endy-starty));
    	}
    }
    public void mouseDragged(MouseEvent e){
    	if("直线".equals(name)){  		
    	Color black=new Color(0,0,0);//黑
    	Color white=new Color(255,255,255);//白
    	//擦除上一条直线
    	n.setColor(white);
    	n.drawLine(startx, starty, endx, endy);
    	    	
    	//获取坐标
    	endx = e.getX();
    	endy = e.getY()+80;
    	
    	n.setColor(black);
    	//画线
    	n.drawLine(startx, starty, endx, endy);
    	}    	
    }
    public void mouseMoved(MouseEvent e){}
    public void mouseClicked(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
		
}

