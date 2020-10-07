package com.fightinguponthesky;

import java.awt.Graphics;

public interface Entity {
	
	public void move();
	
	public void draw(Graphics g);
	
	public int getX();
	
	public int getY();
	
	public void hit(int i);
	
	
	
}
