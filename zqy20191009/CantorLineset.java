package com.zqy20191009;

import java.awt.Graphics;

public class CantorLineset {
	
	public void clset(Graphics g,int n,int x1,int x2,int y){
		g.drawLine(x1, y, x2, y);
		
		if (n==1){
			g.drawLine(x1, y+100, x1+(x2-x1)/3, y+100);
			g.drawLine(x1+2*((x2-x1)/3), y+100, x2, y+100);
			return;
		}
		clset(g,n-1,x1,x1+(x2-x1)/3,y+100);
		clset(g,n-1,x1+2*((x2-x1)/3),x2,y+100);
		
	}

}
