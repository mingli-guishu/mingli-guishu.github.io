package com.chessfive;

import javax.swing.JOptionPane;

public class Towin {
	int type[][]=new int[18][18];
	int win;
	public void judge(){
		for(int i=0;i<18;i++){
			for(int j=0;j<18;j++){
				if(j<=13){
					if(type[i][j]==1&&type[i][j+1]==1&&type[i][j+2]==1&&type[i][j+3]==1&&type[i][j+4]==1){
//						System.out.println("黑子横着胜利");
						win=1;
					}else if(j<=13&&type[i][j]==2&&type[i][j+1]==2&&type[i][j+2]==2&&type[i][j+3]==2&&type[i][j+4]==2){
//						System.out.println("白子横着胜利");
						win=2;
					}
				}
				if(i<=13){
					if(type[i][j]==1&&type[i+1][j]==1&&type[i+2][j]==1&&type[i+3][j]==1&&type[i+4][j]==1){
//						System.out.println("黑子竖着胜利");
						win=1;
					}else if(i<=13&&type[i][j]==2&&type[i+1][j]==2&&type[i+2][j]==2&&type[i+3][j]==2&&type[i+4][j]==2){
//						System.out.println("白子竖着胜利");
						win=2;
					}
				}
				if(i<=13&&j<=13){
					if(type[i][j]==1&&type[i+1][j+1]==1&&type[i+2][j+2]==1&&type[i+3][j+3]==1&&type[i+4][j+4]==1){
//						System.out.println("黑子左斜胜利");
						win=1;
					}else if(i<=13&&j<=13&&type[i][j]==2&&type[i+1][j+1]==2&&type[i+2][j+2]==2&&type[i+3][j+3]==2&&type[i+4][j+4]==2){
//						System.out.println("白子左斜胜利");
						win=2;
					}
				}
				if(i<=13&&j>=4){
					if(type[i][j]==1&&type[i+1][j-1]==1&&type[i+2][j-2]==1&&type[i+3][j-3]==1&&type[i+4][j-4]==1){
//						System.out.println("黑子右斜胜利");
						win=1;
					}else if(i<=13&&j>=4&&type[i][j]==2&&type[i+1][j-1]==2&&type[i+2][j-2]==2&&type[i+3][j-3]==2&&type[i+4][j-4]==2){
//						System.out.println("白子右斜胜利");
						win=2;
					}
				}
			}
		}
	
		if(win==1){
			JOptionPane.showConfirmDialog(null, "黑子胜", "结束", JOptionPane.CLOSED_OPTION);
		}else if(win==2){
			JOptionPane.showConfirmDialog(null, "白子胜", "结束", JOptionPane.CLOSED_OPTION);
		}
	}
}
