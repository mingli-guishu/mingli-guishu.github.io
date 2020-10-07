package com.zqy20200111;

import java.util.ArrayList;

public class BulletMove extends Thread{
	
	int x;
	int y;
	public boolean move=true;
	
	private ArrayList<Bullet> bulstraight;
	private ArrayList<Bullet> bulleft;
	private ArrayList<Bullet> bulright;
	public BulletMove(ArrayList<Bullet> bulstraight,ArrayList<Bullet> bulleft,ArrayList<Bullet> bulright){
		this.bulstraight=bulstraight;
		this.bulleft=bulleft;
		this.bulright=bulright;
		
	}
	
	public void run(){
		while(true){
			if(move==true){
				
//				System.out.println("状态发生改变");
//		System.out.print("move被执行");	
//		for(int i=0;i<bul.size();i++){
//			Bullet bb=bul.get(i);
//			System.out.println();
//			System.out.println(i+" "+bb.x+" "+bb.y);
//		}
		for(int i=0;i<bulstraight.size();i++){
			Bullet bs=bulstraight.get(i);
			bs.straight();
			Bullet bl=bulleft.get(i);
			bl.left();
			Bullet br=bulright.get(i);
			br.right();			
		}
		
			try{
				Thread.sleep(15);
			}catch(Exception e){
				
			}
			
		}else{
			try{
				Thread.sleep(100);
			}catch(Exception e){
				
			}
		}
		}
	}

}
