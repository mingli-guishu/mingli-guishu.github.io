package com.zqy20191009;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

public class Mengersponge {
	public void smallsquare(Graphics g,int n,int x0,int y0,int a,int dx,int dy){
		if (n==1){		
			g.drawRect(x0, y0-a, a, a);
			g.drawLine(x0+dx, y0-a-dy, x0+dx+a, y0-a-dy);
			g.drawLine(x0+dx+a, y0-a-dy, x0+dx+a, y0-dy);
			g.drawLine(x0, y0-a, x0+dx, y0-a-dy);
			g.drawLine(x0+a, y0-a, x0+dx+a, y0-a-dy);
			g.drawLine(x0+a, y0, x0+a+dx, y0-dy);
			
			Polygon Polg2=new Polygon();
			Polg2.addPoint(x0, y0-a);
			Polg2.addPoint(x0+a, y0-a);
			Polg2.addPoint(x0+dx+a, y0-dy-a);
			Polg2.addPoint(x0+dx, y0-dy-a);				
			g.setColor(new Color(255,145,0));
			g.fillPolygon(Polg2);
			
			Polygon Polg1=new Polygon();
			Polg1.addPoint(x0, y0);
			Polg1.addPoint(x0+a, y0);
			Polg1.addPoint(x0+a, y0-a);
			Polg1.addPoint(x0, y0-a);				
			g.setColor(new Color(121,45,0));
			g.fillPolygon(Polg1);
			
			Polygon Polg3=new Polygon();
			Polg3.addPoint(x0+a, y0);
			Polg3.addPoint(x0+a, y0-a);
			Polg3.addPoint(x0+a+dx, y0-a-dy);
			Polg3.addPoint(x0+a+dx, y0-dy);				
			g.setColor(new Color(137,111,0));
			g.fillPolygon(Polg3);
			return;
		}
		smallsquare(g,n-1,x0+2*dx/3,y0-2*dy/3,a/3,dx/3,dy/3);
		smallsquare(g,n-1,x0+2*dx/3+a/3,y0-2*dy/3,a/3,dx/3,dy/3);
		smallsquare(g,n-1,x0+2*dx/3+2*a/3,y0-2*dy/3,a/3,dx/3,dy/3);		
		smallsquare(g,n-1,x0+dx/3,y0-dy/3,a/3,dx/3,dy/3);
		smallsquare(g,n-1,x0+dx/3+2*a/3,y0-dy/3,a/3,dx/3,dy/3);		
		smallsquare(g,n-1,x0,y0,a/3,dx/3,dy/3);
		smallsquare(g,n-1,x0+a/3,y0,a/3,dx/3,dy/3);
		smallsquare(g,n-1,x0+2*a/3,y0,a/3,dx/3,dy/3);
		
		smallsquare(g,n-1,x0+2*dx/3,y0-2*dy/3-a/3,a/3,dx/3,dy/3);
		smallsquare(g,n-1,x0+2*dx/3+2*a/3,y0-2*dy/3-a/3,a/3,dx/3,dy/3);
		smallsquare(g,n-1,x0,y0-a/3,a/3,dx/3,dy/3);
		smallsquare(g,n-1,x0+2*a/3,y0-a/3,a/3,dx/3,dy/3);
		
		smallsquare(g,n-1,x0+2*dx/3,y0-2*dy/3-2*a/3,a/3,dx/3,dy/3);
		smallsquare(g,n-1,x0+2*dx/3+a/3,y0-2*dy/3-2*a/3,a/3,dx/3,dy/3);
		smallsquare(g,n-1,x0+2*dx/3+2*a/3,y0-2*dy/3-2*a/3,a/3,dx/3,dy/3);		
		smallsquare(g,n-1,x0+dx/3,y0-dy/3-2*a/3,a/3,dx/3,dy/3);
		smallsquare(g,n-1,x0+dx/3+2*a/3,y0-dy/3-2*a/3,a/3,dx/3,dy/3);		
		smallsquare(g,n-1,x0,y0-2*a/3,a/3,dx/3,dy/3);
		smallsquare(g,n-1,x0+a/3,y0-2*a/3,a/3,dx/3,dy/3);
		smallsquare(g,n-1,x0+2*a/3,y0-2*a/3,a/3,dx/3,dy/3);
	}
}
