package com.zqy20200111;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionLis implements ActionListener{
	
	private BulletMove bm;
	
	public ActionLis(BulletMove bm){
		this.bm=bm;
	}
	
	public void actionPerformed(ActionEvent e) {		
			bm.move=!bm.move;		
		}
}
	
