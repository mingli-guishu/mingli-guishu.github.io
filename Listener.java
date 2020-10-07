package com.chessfive;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Listener implements ActionListener,MouseListener{
	int x,y;
	int count=0;//控制黑白棋落子,偶数为黑棋
	int type[][]=new int[18][18];
	int row[]=new int[350];//在悔棋中记录行位置
	int col[]=new int[350];//在悔棋中记录列位置
	int numx,numy;
	JFrame JFr;
	int win;
 	public void actionPerformed(ActionEvent e){
 		String action = e.getActionCommand();
 		if ("悔棋".equals(action)) {
 			retract();
 		}
	}

	public void mousePressed(MouseEvent arg0) {
		x=arg0.getX();
		y=arg0.getY();
		Tool to=new Tool();
		to.x=x;
		to.y=y;	
		Towin t=new Towin();
		to.location();
		numx=to.numx;
		numy=to.numy;
		row[count]=numx;
		col[count]=numy;
		if(win==0){
			if(type[numx][numy]==0){
				if(count%2==0){//黑子
					type[numx][numy]=1;
				}else{
					type[numx][numy]=2;
				}
				JFr.repaint();
				t.type=type;
				if(count>=8){
					t.judge();
					win=t.win;
				}		
//				System.out.println(count);
				count++;					
			}
		}
	}		
	
	
	public void retract(){
		if(count>0){
			count--;
			type[row[count]][col[count]]=0;
			row[count]=0;
			col[count]=0;
		}else{
			JOptionPane.showConfirmDialog(null, "不能再悔了", "提示", JOptionPane.CLOSED_OPTION);
		}
		JFr.repaint();
		
	}
	public void mouseReleased(MouseEvent arg0) {
		
	}	
	public void mouseClicked(MouseEvent arg0) {
		
	}
	public void mouseEntered(MouseEvent arg0) {
		
	}
	public void mouseExited(MouseEvent arg0) {
	}
}
	


