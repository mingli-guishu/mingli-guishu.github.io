package com.fightinguponthesky;

import java.util.ArrayList;

public class MyBulletMove extends Thread{
	private Myplane mp;
	private ArrayList<Entity> listmybullet;
	
	public MyBulletMove (ArrayList<Entity> listmybullet, Myplane mp){
		this.listmybullet=listmybullet;
		this.mp=mp;
	}
	
	public void run(){
		while(true){
			if(mp.death==false){
				Bullet upbullet1=new Bullet();
				upbullet1.m=0;//œÚ…œ∑…
				upbullet1.x=mp.x-11-mp.a;
				upbullet1.y=mp.y;
				
				upbullet1.list=listmybullet;
				listmybullet.add(upbullet1);
				
				if(mp.a!=0){
					Bullet upbullet2=new Bullet();
					upbullet2.m=0;
					upbullet2.x=mp.x-11+mp.a;
					upbullet2.y=mp.y;
					
					upbullet2.list=listmybullet;
					listmybullet.add(upbullet2);
				}
				if(mp.c==1){
					Bullet leftbullet=new Bullet();
					leftbullet.m=1;
					leftbullet.x=mp.x-11;
					leftbullet.y=mp.y;
					
					leftbullet.list=listmybullet;
					listmybullet.add(leftbullet);
					
					Bullet rightbullet=new Bullet();
					rightbullet.m=2;
					rightbullet.x=mp.x-11;
					rightbullet.y=mp.y;
					
					rightbullet.list=listmybullet;
					listmybullet.add(rightbullet);
				}
				try{
					Thread.sleep(400);
				}catch(Exception ef){
			
				}
			}
		}
		
	}
}
