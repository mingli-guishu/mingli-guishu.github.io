package com.fightinguponthesky;

import java.util.ArrayList;

public class Checkforcrash extends Thread{
	private ArrayList<Entity> listmybullet;
	private ArrayList<Entity> listenemy;
	private ArrayList<Prop> listprop;
	private ArrayList<Boss> listboss;
	Myplane mp;
	
	public Checkforcrash(ArrayList<Entity> listenemy,ArrayList<Entity> listmybullet,
			ArrayList<Prop> listprop, ArrayList<Boss> listboss, Myplane mp){
		this.listenemy=listenemy;
		this.listmybullet=listmybullet;
		this.listprop=listprop;
		this.listboss=listboss;
		this.mp=mp;
	}
	
	public void run(){
		while(true){
			for(int i=listmybullet.size()-1;i>0;i--){
				Entity temA=listmybullet.get(i);
				for(int j=0;j<listenemy.size();j++){
					Entity temB=listenemy.get(j); 
					if(Tools.enemymycrash( temB, mp)){
						temA.hit(j);
						mp.hit(j);						
					}
					if(Tools.bulletenemycrash( temA, temB)){
						temA.hit(i);
						temB.hit(j);													
					}
					
				}			
			}
			
			for(int i=0;i<listprop.size();i++){
				Prop pp=listprop.get(i);
				if(Tools.propmycrash(pp, mp)){
					pp.hit(i);
					mp.m=pp.m;
					if(mp.m==1){//prop������1���������
						mp.c=1;
					}else if(mp.m==0){//prop������0���ƶ��ٶȼӱ�
						mp.s=1;
					}else if(mp.m==2){//prop������2���ƶ��ٶȼ���
						mp.s=2;
					}else if(mp.m==3){//prop������3���ӵ���������
						mp.a=7;
					}
				}
				
			}
			for(int i=listmybullet.size()-1;i>0;i--){
				Entity e=listmybullet.get(i);
				for(int j=0;j<listboss.size();j++){
					Boss b=listboss.get(j);
					if(Tools.bulletbosscrash(e, b)){
						e.hit(i);
						b.hit(j);
					}
				}				
			}
			try{
				Thread.sleep(10);
			}catch(Exception ef){
		
			}
		}
	}
}
