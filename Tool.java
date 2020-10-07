package com.chessfive;

public class Tool {
	int x,y;
	int numx,numy;
	
	//75~125£¬125~175£¬175~225
	//50~100£¬100~150£¬150~200,200,250,300,350,400,450
	public void location(){
		if(x>=50&&x<=950&&y>=50&&y<=950){
			numx=(x-50)/50;
			numy=(y-50)/50;
//			numy=(x-((x-50)%50))/50-1;
//			numx=(y-((y-50)%50))/50-1;
//			System.out.println(numx+" "+numy);
		}
	}
}
