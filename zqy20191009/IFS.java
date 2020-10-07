package com.zqy20191009;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class IFS {

	public void ifs(Graphics g){
		double a=1.7,b=1.7,c=0.6,d=1.2;
		double x=0,y=0;
		//创建了缓存
		BufferedImage buffer = new BufferedImage(1000,1000,BufferedImage.TYPE_INT_ARGB);
		//获取缓存的画布
		Graphics bufferG = buffer.getGraphics();
		for(int n=0;n<100;n++){
			bufferG.setColor(Color.WHITE);
			bufferG.fillRect(0, 80, 1000, 920);
			
		for(int m=0;m<40000;m++){
			double Mx=Math.sin(a*y)+Math.cos(a*x)*c;
			double My=Math.sin(b*x)+Math.cos(b*y)*d;
			
			int x1=(int)(Mx*130+500);
			int y1=(int)(My*130+500);
			
			bufferG.setColor(Color.BLACK);
			bufferG.drawLine(x1,y1,x1,y1);
			
			x=Mx;
			y=My;
				
		}
		//绘制缓存
		g.drawImage(buffer, 0, 0, null);
		a=a+0.01;
		b=b+0.01;
		c=c+0.01;
		d=d+0.01;
		}
	}
}
