package com.fightinguponthesky;

public class Tools {
	
	/**
	 * ������"�һ�"��"�л�"����ײ
	 * @param ea
	 * @param eb
	 * @return  true  
	 */
	
	//�л��һ���ײ
	public static  boolean enemymycrash(Entity e,Myplane mp){
				
			if(Math.abs((e.getX()+45)-(mp.getX()-1))<40&&Math.abs((e.getY()+45)-(mp.getY()+55))<40){
				return true;
			}else{
				return false;
			}
	}
	
	//�л��ӵ���ײ
	public static boolean bulletenemycrash(Entity ea,Entity eb){
		
		if((ea instanceof Enemyplane)&&(eb instanceof Bullet)){
			
			if(Math.abs((ea.getX()+45)-(eb.getX()+10))<20&&Math.abs((ea.getY()+45)-eb.getY())<20){
				return true;				
			}
		}
		
		else if ((ea instanceof Bullet)&&(eb instanceof Enemyplane)){
			
			if(Math.abs((ea.getX()+10)-(eb.getX()+45))<20&&Math.abs(ea.getY()-(eb.getY()+45))<20){
				return true;
			}
		}
		return false;
	}
	//�һ�������ײ
	public static boolean propmycrash(Entity e, Myplane mp){
		
		if(Math.abs((e.getX()+21)-(mp.getX()-1))<40&&Math.abs((e.getY()+20)-(mp.getY()+55))<40){
			return true;
		}else{
			return false;
		}
	}

	//�ӵ�Boss��ײ
	public static boolean bulletbosscrash(Entity e,Boss b){
		if(Math.abs((e.getX()+10)-(b.getX()+196))<150&&Math.abs(e.getY()-(b.getY()+149))<80){
			return true;
		}
		return false;
	}
}
