package com.armyvsbandit;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

import java.awt.Graphics;

public class Listener implements MouseListener, ActionListener {
	int gridheight;// 每个格子的高
	int gridwidth;
	Graphics g;
	String name;
	int x1, y1, x2, y2;
	int row1, row2, col1, col2;// 行1，行2，列1，列2
	int[][] type;
	JFrame Fra;
	Frame Fram;
	Armywinrule a;
	int count;
	int[][] A = new int[3][2];// 判断输赢时获取的红军的位置
	int num1, num2;// 判断输赢时土匪和红军的计数
	int m, n;// 在红军是否可移动中用
	int o, p, q, r;// 在悔棋中用,用来获取悔棋位置
	int[] rowstart = new int[450];// 起始行
	int[] colstart = new int[450];// 起始列
	int[] rowend = new int[450];// 终止行
	int[] colend = new int[450];// 终止列
	int[] banditnum=new int[30];//记录土匪数量以判断和棋
	int[] countnum=new int[15];//在和棋悔棋中用，记录当土匪数量改变时count的值
	int l=0;//在和棋location中用，用于把numa装进banditnum[]
	int ll=0;//在和棋悔棋retract中用，用来确认悔棋之前banditnum[]的l
	int lll=0;//在和棋悔棋retract中用，悔完棋后遍历数组获取土匪数量
	int u=1;//在和棋draw中用，记录当土匪数量改变时count的数值，到后面用于悔棋时确认l，ll的值
	int k1=0;int k2=0;//在和棋中用,用来获取banditnum[]数组的前后数字并判断土匪数量是否改变
	int numl=0;//在和棋draw中用，记录banditnum[]中相同数字的个数，若全部相同则和棋
	int numa=0;//在和棋location中用，在判断和棋之前遍历数组获取土匪数量
	int M=0;//和棋警告

	//01/11/20 两个问题：  2、鼠标任意点击都会在和棋数组中记录
	
	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand();
		name = action;
		if ("重新开始".equals(name)) {
			Fram.init(g);
			Fra.repaint();
			count = 0;
			M=0;
			l=0;
			ll=0;
			lll=0;
			u=0;
			numl=0;
			for (int i = 0; i < 3; i++) {
				A[i][0] = 0;
				A[i][1] = 0;
			}
			for (int i = 0; i < 100; i++) {
				rowstart[i] = 0;
				colstart[i] = 0;
				rowend[i] = 0;
				colend[i] = 0;
			}
		}
		if ("悔棋".equals(name)) {
			retract();
		}
	}
	

	public void mousePressed(MouseEvent e) {
		x1 = e.getX();
		y1 = e.getY();
		// 起始点高于第一条线或低于最后一条线
		if (y1 < gridheight || y1 > 6 * gridheight) {
//			System.out.println("越界");
			row1 = 5;// 超出范围时
		} else {
			row1 = (y1 - gridheight) / gridheight;
		}
		if (x1 < gridwidth || x1 > 6 * gridwidth) {
//			System.out.println("越界");
			col1 = 5;
		} else {
			col1 = (x1 - gridwidth) / gridwidth;
		}

		// System.out.println(row1+"行"+" "+col1+"列");

	}
	

	public void mouseReleased(MouseEvent e) {
		x2 = e.getX();
		y2 = e.getY();
		if (y2 < gridheight || y2 > 6 * gridheight) {
			// System.out.println("越界");
			row2 = 5;
		} else {
			row2 = (y2 - gridheight) / gridheight;
		}
		if (x2 < gridwidth || x2 > 6 * gridwidth) {
//			System.out.println("越界");
			col2 = 5;
		} else {
			col2 = (x2 - gridwidth) / gridwidth;
		}
		// System.out.println(row2+"行"+" "+col2+"列");
		if(M==0){
			moverule();//moverule必须在第一个，确保遍历数组时的准确性
			banditwinrule();
			armywinrule();	
			location();
			draw();
		}
		warning();
	}
	

	public void armywinrule() {
		num1 = 0;
		// 判断输赢
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				// 红军的胜利条件
				if (type[i][j] == 1) {
					num1++;
				}			
			}
		}
//		System.out.println(num1);
			 
		if (num1 == 0) {
			System.out.println("红军胜！");
		}
		
	}
	
			
	public void warning(){
		if(M==1){
			if(x1>0){
				System.out.println("wrong");
			}
		}
	}
	
	
	public void location(){
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (type[i][j] == 1) {
					numa++;
				}
			}
		}
//		System.out.println(l);
		banditnum[l]=numa;
		numa=0;
//		for(int i=0;i<30;i++)
//		System.out.println(i+" "+banditnum[i]);
//		System.out.println(l);
//		System.out.println("-----");
//		System.out.println();
		l++;
//		System.out.println(l);
	}
	
	public void draw(){
		for(int i=0;i<30;i++){
//			System.out.print(banditnum[i]+" ");			
			k1=banditnum[i];
			if(i!=29){//当i=28时已完成和棋判断，直接跳出
				k2=banditnum[i+1];
			}else{
				break;
			}
			
			if(k1!=k2&&k2!=0&&k1!=0){//当k1不等于k2,且k2不等于0，重新开始判断				
				l=1;
				for(int j=0;j<30;j++){
					banditnum[j]=0;
				}
				banditnum[0]=k2;
				countnum[u]=count-1;
				u++;
//				for(int m=0;m<15;m++){
//					System.out.print(countnum[m]);
//					System.out.print("-----");
//				}
				break;
			}else if (k1==k2&&k1!=0){
				numl++;
							
				}
			}
//		System.out.println();
//		System.out.println(numl);
		if (numl==29){			
			System.out.println("和棋！");
			M++;	
		}else{
			numl=0;
		}
	}
		
	public void moverule() {		
		if (row1 == 5 || col1 == 5 || row2 == 5 || col2 == 5) {
//			System.out.println("越界");
		} else {
			if(row1==row2&&col1==col2){
				if(type[row1][col1]==2&&count % 2 == 0){//单次敲击的是红军且到了红军动了的时候
					if(a.nextmove(m, n - 1)==true){//左侧的
//						g.fillRect(gridwidth*(m+1), gridheight*n, width, height);
					}
				}
			}else{
			if (count % 2 == 0) {// 红军动
				if ((type[row1][col1] == 2) && (type[row2][col2] == 1)) {// 确保起始位和终止位
					// 红军的行动方法(每次动两格)
					if (((row2 == row1 + 2 || row2 == row1 - 2) && col2 == col1)
							|| ((col2 == col1 + 2 || col2 == col1 - 2) && row2 == row1)) {
						// 确保中间没土匪
						if ((col2 == col1 && type[(row1 + row2) / 2][col1] == 0)
								|| (row1 == row2 && type[row1][(col1 + col2) / 2] == 0)) {
							type[row1][col1] = 0;
							type[row2][col2] = 2;
							Fra.repaint();
							record();
							count++;
						}
					}

				}
				if (type[row1][col1] == 2 && type[row2][col2] == 0) {
					if (((row2 == row1 + 1 || row2 == row1 - 1) && col2 == col1)
							|| ((col2 == col1 + 1 || col2 == col1 - 1) && row2 == row1)) {
						type[row1][col1] = 0;
						type[row2][col2] = 2;
						Fra.repaint();
						record();
						count++;
					}
				}
				// 土匪移动规则
			} else if (count % 2 == 1) {// 土匪动
				if (type[row1][col1] == 1 && type[row2][col2] == 0) {// 确保起始位和终止位
					// 土匪的行动方法
					if (((row2 == row1 + 1 || row2 == row1 - 1) && col2 == col1)
							|| ((col2 == col1 + 1 || col2 == col1 - 1) && row2 == row1)) {
						type[row1][col1] = 0;
						type[row2][col2] = 1;
						Fra.repaint();
						record();
						count++;
					}
				}
			}
		}
	}
	}
	
		
	public void banditwinrule() {
		int z = 0;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				// 取出每个红军位置
				if (type[i][j] == 2) {
					A[z][0] = i;
					A[z][1] = j;
					// System.out.println(A[z][0]+" "+A[z][1]+" "+i+" "+j+"
					// "+z);
					z++;
				}
			}
		}
		// 红军位置的数组
		// for(int y=0;y<3;y++){
		// System.out.println(A[y][0]+" "+A[y][1]);
		// }
		num2 = 0;
		for (int x = 0; x < 3; x++) {
			m = A[x][0];
			n = A[x][1];
			if (a.canmove(m, n) == false) {
				num2++;
			}
		}
//		System.out.println(num2);
		if (num2 == 3) {
			System.out.println("土匪胜！");
		}
	}
	

	public void record() {
		if(M==0){
			rowstart[count] = row1;
			colstart[count] = col1;
			rowend[count] = row2;
			colend[count] = col2;
			// for(int i=0;i<20;i++){
			// System.out.println(rowstart [i]+" "+colstart [i]+" "+rowend [i]+"
			// "+colend [i]);
			// }
		}
	}
	

	public void retract() {
		if(M==0){
		if (count == 0) {
			System.out.println("不能再悔了!");
//			System.out.println(l);
		} else {
			
//			System.out.println(l);
			
			count--;

			o = rowstart[count];
			p = colstart[count];
			q = rowend[count];
			r = colend[count];
			if (count % 2 == 0) {// 上一步是红军动了
				type[o][p] = 2;
				if (((q == o + 2 || q == o - 2) && r == p) || ((r == p + 2 || r == p - 2) && q == o)) {// 红军吃了土匪
					type[q][r] = 1;
				} else {// 没吃土匪
					type[q][r] = 0;
				}
				Fra.repaint();
			} else if (count % 2 == 1) {// 上一步是土匪动了
				type[o][p] = 1;
				type[q][r] = 0;
				Fra.repaint();
			}
		}
		rowstart[count] = 0;
		colstart[count] = 0;
		rowend[count] = 0;
		colend[count] = 0; 
		
		if(l>1){
			l--;
			banditnum[l]=0;
		}else if (l==1){
			lll=0;
			for(int m=0;m<5;m++){
				for(int n=0;n<5;n++){
					if(type[m][n] == 1){
						lll++;
					}
				}
			}
			for(int i=0;i<15;i++){
				if(countnum[i]!=0&&countnum[i+1]==0){
					ll=countnum[i]-countnum[i-1];
					l=countnum[i]-countnum[i-1];
					for(int j=0;j<ll;j++){						
						banditnum[j]=lll;
					}
					countnum[i]=0;
					u--;
				}
				
			}
			
		}
	}
	}
	
	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public void mouseClicked(MouseEvent e) {
	}
}
