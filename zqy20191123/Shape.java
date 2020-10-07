package com.zqy20191123;

import java.awt.Graphics;

public class Shape {
	String Shapename;
	int x1,x2,y1,y2;
	Graphics g;
	public void drawshape(Graphics g){
		if(Shapename.equals("¾ØÐÎ")){
			g.drawRect(Math.min(x2, x1), Math.min(y1, y2), Math.abs(x2-x1), Math.abs(y2-y1));
		}
	}
}
