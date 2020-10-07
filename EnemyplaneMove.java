package com.fightinguponthesky;

import java.util.ArrayList;

public class EnemyplaneMove extends Thread{
	private Myplane mp;
	private ArrayList<Entity> listenemy;
	private ArrayList<Boss> listboss;
	
	public EnemyplaneMove (ArrayList<Entity> listenemy, ArrayList<Boss> listboss, Myplane mp){
		this.listenemy=listenemy;
		this.listboss=listboss;
		this.mp=mp;
	}
	
	public void run(){
		while(true){
			if(listboss.size()==0){
				Enemyplane ep=new Enemyplane(mp);
				listenemy.add(ep);
				ep.list=listenemy;
			}
							
			try{
				Thread.sleep(1000);
			}catch(Exception e){

			}
		}
	}
}
