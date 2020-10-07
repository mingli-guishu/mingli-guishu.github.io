package com.armyvsbandit;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

import java.awt.Graphics;

public class Listener implements MouseListener, ActionListener {
	int gridheight;// ÿ�����ӵĸ�
	int gridwidth;
	Graphics g;
	String name;
	int x1, y1, x2, y2;
	int row1, row2, col1, col2;// ��1����2����1����2
	int[][] type;
	JFrame Fra;
	Frame Fram;
	Armywinrule a;
	int count;
	int[][] A = new int[3][2];// �ж���Ӯʱ��ȡ�ĺ����λ��
	int num1, num2;// �ж���Ӯʱ���˺ͺ���ļ���
	int m, n;// �ں���Ƿ���ƶ�����
	int o, p, q, r;// �ڻ�������,������ȡ����λ��
	int[] rowstart = new int[450];// ��ʼ��
	int[] colstart = new int[450];// ��ʼ��
	int[] rowend = new int[450];// ��ֹ��
	int[] colend = new int[450];// ��ֹ��
	int[] banditnum=new int[30];//��¼�����������жϺ���
	int[] countnum=new int[15];//�ں���������ã���¼�����������ı�ʱcount��ֵ
	int l=0;//�ں���location���ã����ڰ�numaװ��banditnum[]
	int ll=0;//�ں������retract���ã�����ȷ�ϻ���֮ǰbanditnum[]��l
	int lll=0;//�ں������retract���ã����������������ȡ��������
	int u=1;//�ں���draw���ã���¼�����������ı�ʱcount����ֵ�����������ڻ���ʱȷ��l��ll��ֵ
	int k1=0;int k2=0;//�ں�������,������ȡbanditnum[]�����ǰ�����ֲ��ж����������Ƿ�ı�
	int numl=0;//�ں���draw���ã���¼banditnum[]����ͬ���ֵĸ�������ȫ����ͬ�����
	int numa=0;//�ں���location���ã����жϺ���֮ǰ���������ȡ��������
	int M=0;//���徯��

	//01/11/20 �������⣺  2����������������ں��������м�¼
	
	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand();
		name = action;
		if ("���¿�ʼ".equals(name)) {
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
		if ("����".equals(name)) {
			retract();
		}
	}
	

	public void mousePressed(MouseEvent e) {
		x1 = e.getX();
		y1 = e.getY();
		// ��ʼ����ڵ�һ���߻�������һ����
		if (y1 < gridheight || y1 > 6 * gridheight) {
//			System.out.println("Խ��");
			row1 = 5;// ������Χʱ
		} else {
			row1 = (y1 - gridheight) / gridheight;
		}
		if (x1 < gridwidth || x1 > 6 * gridwidth) {
//			System.out.println("Խ��");
			col1 = 5;
		} else {
			col1 = (x1 - gridwidth) / gridwidth;
		}

		// System.out.println(row1+"��"+" "+col1+"��");

	}
	

	public void mouseReleased(MouseEvent e) {
		x2 = e.getX();
		y2 = e.getY();
		if (y2 < gridheight || y2 > 6 * gridheight) {
			// System.out.println("Խ��");
			row2 = 5;
		} else {
			row2 = (y2 - gridheight) / gridheight;
		}
		if (x2 < gridwidth || x2 > 6 * gridwidth) {
//			System.out.println("Խ��");
			col2 = 5;
		} else {
			col2 = (x2 - gridwidth) / gridwidth;
		}
		// System.out.println(row2+"��"+" "+col2+"��");
		if(M==0){
			moverule();//moverule�����ڵ�һ����ȷ����������ʱ��׼ȷ��
			banditwinrule();
			armywinrule();	
			location();
			draw();
		}
		warning();
	}
	

	public void armywinrule() {
		num1 = 0;
		// �ж���Ӯ
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				// �����ʤ������
				if (type[i][j] == 1) {
					num1++;
				}			
			}
		}
//		System.out.println(num1);
			 
		if (num1 == 0) {
			System.out.println("���ʤ��");
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
			if(i!=29){//��i=28ʱ����ɺ����жϣ�ֱ������
				k2=banditnum[i+1];
			}else{
				break;
			}
			
			if(k1!=k2&&k2!=0&&k1!=0){//��k1������k2,��k2������0�����¿�ʼ�ж�				
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
			System.out.println("���壡");
			M++;	
		}else{
			numl=0;
		}
	}
		
	public void moverule() {		
		if (row1 == 5 || col1 == 5 || row2 == 5 || col2 == 5) {
//			System.out.println("Խ��");
		} else {
			if(row1==row2&&col1==col2){
				if(type[row1][col1]==2&&count % 2 == 0){//�����û����Ǻ���ҵ��˺�����˵�ʱ��
					if(a.nextmove(m, n - 1)==true){//����
//						g.fillRect(gridwidth*(m+1), gridheight*n, width, height);
					}
				}
			}else{
			if (count % 2 == 0) {// �����
				if ((type[row1][col1] == 2) && (type[row2][col2] == 1)) {// ȷ����ʼλ����ֹλ
					// ������ж�����(ÿ�ζ�����)
					if (((row2 == row1 + 2 || row2 == row1 - 2) && col2 == col1)
							|| ((col2 == col1 + 2 || col2 == col1 - 2) && row2 == row1)) {
						// ȷ���м�û����
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
				// �����ƶ�����
			} else if (count % 2 == 1) {// ���˶�
				if (type[row1][col1] == 1 && type[row2][col2] == 0) {// ȷ����ʼλ����ֹλ
					// ���˵��ж�����
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
				// ȡ��ÿ�����λ��
				if (type[i][j] == 2) {
					A[z][0] = i;
					A[z][1] = j;
					// System.out.println(A[z][0]+" "+A[z][1]+" "+i+" "+j+"
					// "+z);
					z++;
				}
			}
		}
		// ���λ�õ�����
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
			System.out.println("����ʤ��");
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
			System.out.println("�����ٻ���!");
//			System.out.println(l);
		} else {
			
//			System.out.println(l);
			
			count--;

			o = rowstart[count];
			p = colstart[count];
			q = rowend[count];
			r = colend[count];
			if (count % 2 == 0) {// ��һ���Ǻ������
				type[o][p] = 2;
				if (((q == o + 2 || q == o - 2) && r == p) || ((r == p + 2 || r == p - 2) && q == o)) {// �����������
					type[q][r] = 1;
				} else {// û������
					type[q][r] = 0;
				}
				Fra.repaint();
			} else if (count % 2 == 1) {// ��һ�������˶���
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
