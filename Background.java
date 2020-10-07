package com.fightinguponthesky;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Background implements Entity{
	
	int x,y=-1000;
	Image image=new ImageIcon("planebg.png").getImage();
	
	public void move() {
		y+=2;
		
	}

	public void draw(Graphics g) {
		if(y-image.getHeight(null)>=0){
			y=0;
		}
		
		g.drawImage(image, x, y, null);
		g.drawImage(image, x, y+image.getHeight(null), null);
		
	}

	
	public int getX() {		
		return x;
	}

	
	public int getY() {	
		return y;
	}

	@Override
	public void hit(int i) {
		// TODO Auto-generated method stub
		
	}

}
