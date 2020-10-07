package com.zqy20191009;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

public class IFS2 {
	int N,M;
	double a, b, c, d, e, f;
	double[] G1 = new double[6];
	double set1[] = { 0.195, -0.488, 0.344, 0.443, 0.4431, 0.2452 };
	double set2[] = { 0.462, 0.414, -0.252, 0.361, 0.2511, 0.5692 };
	double set3[] = { -0.637, 0, 0, 0.501, 0.8562, 0.2512 };
	double set4[] = { -0.035, 0.07, -0.4690, 0.022, 0.4884, 0.5069 };
	double set5[] = { -0.058, -0.07, 0.453, -0.111, 0.5976, 0.0969 };

	public void ifs2(Graphics g) {

		double mx = 0, my = 0;

		BufferedImage buffer = new BufferedImage(1000, 1000, BufferedImage.TYPE_INT_ARGB);
		Graphics bufferG = buffer.getGraphics();

		for (int q = 1; set1[q] < 0; set1[q] += 0.001) {
			bufferG.setColor(Color.WHITE);
			bufferG.fillRect(0, 80, 1000, 920);
//
			for (int m = 0; m < 500000; m++) {
				Random rand = new Random();
				M = rand.nextInt(5);// 0~4
				// System.out.println(M);
				if (M == 0) {
					G1 = set1;
				} else if (M == 1) {
					G1 = set2;
				} else if (M == 2) {
					G1 = set3;
				} else if (M == 3) {
					G1 = set4;
				} else if (M == 4) {
					G1 = set5;
				}
			
				a = G1[0];
				b = G1[1];
				c = G1[2];
				d = G1[3];
				e = G1[4];
				f = G1[5];
				double Mx = a * mx + b * my + e;
				double My = c * mx + d * my + f;

				int x1 = (int) (Mx * (-950) + 950);
				int y1 = (int) (My * (-950) + 950);

				bufferG.setColor(Color.BLACK);
				bufferG.drawLine(x1, y1, x1, y1);

				mx = Mx;
				my = My;
			}
		
//		for (int q = 1; set1[q] < 0; set1[q] += 0.001) {
//			bufferG.setColor(Color.WHITE);
//			bufferG.fillRect(0, 80, 1000, 920);

			for (int m = 0; m < 500000; m++) {
				Random rand = new Random();
				M = rand.nextInt(5);// 0~4
				// System.out.println(M);
				if (M == 0) {
					G1 = set1;
				} else if (M == 1) {
					G1 = set2;
				} else if (M == 2) {
					G1 = set3;
				} else if (M == 3) {
					G1 = set4;
				} else if (M == 4) {
					G1 = set5;
				}
			
				a = G1[0];
				b = G1[1];
				c = G1[2];
				d = G1[3];
				e = G1[4];
				f = G1[5];
				double Mx = a * mx + b * my + e;
				double My = c * mx + d * my + f;

				int x1 = (int) (Mx * (-450) + 750);
				int y1 = (int) (My * (-450) + 750);

				bufferG.setColor(Color.BLACK);
				bufferG.drawLine(x1, y1, x1, y1);

				mx = Mx;
				my = My;
			}
			g.drawImage(buffer, 0, 0, null);
			
		}


		

	}
}
