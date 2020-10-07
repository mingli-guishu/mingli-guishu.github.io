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
    	if("����".equals(name)){
    		IFS ifs = new IFS();
    		ifs.ifs(n);   		
    	}
    	if("����2".equals(name)){
    		IFS2 ifs2=new IFS2();
    		ifs2.ifs2(n);
    	}
    	if("���".equals(name)){   		
    		n.setColor(Color.WHITE);
    		n.fillRect(0, 80, 1000, 920);
    		n.setColor(Color.BLACK);
    	}
    	if("л����˹��������".equals(name)){
    		Sierpinskitriangle triangle=new Sierpinskitriangle();
    		triangle.triangle(n,5,500,100,900,100,900,900);
    	}
    	if("���ж��߼�".equals(name)){
    		CantorLineset clset=new CantorLineset();
    		clset.clset(n,6,100,900,100);
    	}
    	if("���ж����μ�".equals(name)){
    		CantorSquareset csset=new CantorSquareset();
    		csset.csset(n, 3, 100, 100, 900, 900);
    	}
    	if("�Ÿ���".equals(name)){
    		Mengersponge sponge=new Mengersponge();
    		sponge.smallsquare(n, 4, 50, 950, 630, 220, 220);
    	}
	}
    public void mouseReleased(MouseEvent e) {
        endx = e.getX();
        endy = e.getY()+80;
//      n.drawLine(startx, starty, endx, endy);
        
        if("����".equals(name)){
        	n.drawRect(Math.min(endx, startx), Math.min(starty, endy), Math.abs(endx-startx), Math.abs(endy-starty));
    	} 
    	if("Բ��".equals(name)){
    		n.drawOval(Math.min(endx, startx), Math.min(starty, endy), Math.abs(endx-startx), Math.abs(endy-starty));
    	}
    }
    public void mouseDragged(MouseEvent e){
    	if("ֱ��".equals(name)){  		
    	Color black=new Color(0,0,0);//��
    	Color white=new Color(255,255,255);//��
    	//������һ��ֱ��
    	n.setColor(white);
    	n.drawLine(startx, starty, endx, endy);
    	    	
    	//��ȡ����
    	endx = e.getX();
    	endy = e.getY()+80;
    	
    	n.setColor(black);
    	//����
    	n.drawLine(startx, starty, endx, endy);
    	}    	
    }
    public void mouseMoved(MouseEvent e){}
    public void mouseClicked(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
		
}

