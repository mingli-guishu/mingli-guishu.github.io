package com.zqy20191009;

import java.awt.Graphics;

public class CantorSquareset {
	
	public void csset(Graphics g,int n,int x1,int y1,int x2,int y2){		
		g.drawRect(100, 100, 800, 800);
	
		if(n==1){	
			g.drawRect(x1+(x2-x1)/3, y1+(y2-y1)/3, (x2-x1)/3, (y2-y1)/3);
			return;
		}
		csset(g,n-1,x1,y1,x2,y2);
		csset(g,n-1,x1,y1,x1+(x2-x1)/3,y1+(y2-y1)/3);
		csset(g,n-1,x1+(x2-x1)/3,y1,x2-(x2-x1)/3,y1+(y2-y1)/3);
		csset(g,n-1,x2-(x2-x1)/3,y1,x2,y1+(y2-y1)/3);
		csset(g,n-1,x1,y1+(y2-y1)/3,x1+(x2-x1)/3,y2-(y2-y1)/3);
		csset(g,n-1,x2-(x2-x1)/3,y1+(y2-y1)/3,x2,y2-(y2-y1)/3);
		csset(g,n-1,x1,y2-(y2-y1)/3,x1+(x2-x1)/3,y2);
		csset(g,n-1,x1+(x2-x1)/3,y2-(y2-y1)/3,x2-(x2-x1)/3,y2);
		csset(g,n-1,x2-(x2-x1)/3,y2-(y2-y1)/3,x2,y2);		
}
}