package com.zqy20191009;

import java.awt.Graphics;

public class Sierpinskitriangle {
	
	public void triangle(Graphics g,int n,int x1,int x2,int x3,int y1,int y2,int y3){
//		x1=500;y1=100;ио
//		x2=100;y2=900;вСоб
//		x3=900;y3=900;сроб
		int[] x={(x1+x2)/2,(x1+x3)/2,(x2+x3)/2};
		int[] y={(y1+y2)/2,(y1+y3)/2,(y3+y2)/2};
		g.drawLine(x1, y1, x2, y2);
		g.drawLine(x1, y1, x3, y3);
		g.drawLine(x2, y2, x3, y3);
		g.fillPolygon(x, y, 3);
//		g.fillPolygon(new int[]{ }, new int[]{ }, n);
		
		if (n==1){
//			g.drawLine((x1+x2)/2, (y1+y2)/2, (x2+x3)/2, (y2+y3)/2);
//			g.drawLine((x1+x3)/2, (y1+y3)/2, (x2+x3)/2, (y2+y3)/2);
//			g.drawLine((x1+x2)/2, (y1+y2)/2, (x1+x3)/2, (y1+y3)/2);
			return;
		}
		triangle(g,n-1,x1,(x1+x2)/2,(x1+x3)/2,y1,(y1+y2)/2,(y1+y3)/2);
		triangle(g,n-1,x2,(x1+x2)/2,(x2+x3)/2,y2,(y1+y2)/2,(y2+y3)/2);
		triangle(g,n-1,x3,(x1+x3)/2,(x2+x3)/2,y3,(y1+y3)/2,(y2+y3)/2);
	}

}
