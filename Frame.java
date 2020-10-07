package com.armyvsbandit;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class Frame extends JPanel {
	int height;
	int width;
	int gridheight;// 每个格子的高
	int gridwidth;
	int Cheight;// 每个棋子的宽度
	int Cwidth;// 每个棋子的高度
	int[][] type = new int[5][5];// [行][列]
	Graphics g;
	int x1, y1, x2, y2;

	private void showUI() {

		JFrame Fra = new JFrame();
		Fra.setSize(1000, 1000);
		Fra.setLocationRelativeTo(null);

		Listener l = new Listener();
		Armywinrule a = new Armywinrule();

		JPanel North = new JPanel();
		Fra.add(North, BorderLayout.NORTH);
		String[] name = { "重新开始", "悔棋" };
		for (int n = 0; n < name.length; n++) {
			JButton btn = new JButton(name[n]);
			North.add(btn);
			btn.addActionListener(l);
		}
		
		Fra.add(this, BorderLayout.CENTER);
		this.setBackground(Color.white);

		this.addMouseListener(l);

		this.init(g);

		Fra.setVisible(true);

		height = this.getHeight();
		width = this.getWidth();
		gridheight = height / 7;
		gridwidth = width / 7;
		l.gridheight = gridheight;
		l.gridwidth = gridwidth;
		l.type = type;
		a.type = type;
		l.g = g;
		l.Fra = Fra;
		l.Fram=this;
		l.a = a;
		// System.out.println(gridheight+" "+gridwidth);

		// Graphics Location =this.getGraphics();
	}

	public void paint(Graphics g) {
		super.paint(g);
		height = this.getHeight();
		width = this.getWidth();
		gridheight = height / 7;
		gridwidth = width / 7;
		// System.out.println(gridheight+" "+gridwidth);

		Cheight = 9*gridheight / 20;
		Cwidth = 9*gridwidth / 20;
		// 棋盘
		for (int i = 0; i < 6; i++) {
			g.drawLine((i + 1) * gridwidth, gridheight, (i + 1) * gridwidth, 6 * gridheight);// 竖线
			g.drawLine(gridwidth, (i + 1) * gridheight, 6 * gridwidth, (i + 1) * gridheight);// 横线
		}
		for (int i = 0; i < type.length; i++) {// 行数
			for (int j = 0; j < type[i].length; j++) {// 每行的个数
				int v = type[i][j];
				if (v == 1) { // 土匪
					g.drawImage(new ImageIcon("bandit.jpg").getImage(), gridwidth * (j + 1) + gridwidth / 2 - Cwidth,
							(i + 1) * gridheight + gridheight / 2 - Cheight, Cwidth * 2, Cheight * 2, null);
//					g.drawOval(gridwidth * (j + 1) + gridwidth / 2 - Cwidth,
//							(i + 1) * gridheight + gridheight / 2 - Cheight, Cwidth * 2, Cheight * 2);
//					g.fillOval(gridwidth * (j + 1) + gridwidth / 2 - Cwidth,
//							(i + 1) * gridheight + gridheight / 2 - Cheight, Cwidth * 2, Cheight * 2);
				} else if (v == 2) { // 红军
					g.drawImage(new ImageIcon("army.jpg").getImage(), gridwidth * (j + 1) + gridwidth / 2 - Cwidth,
							(i + 1) * gridheight + gridheight / 2 - Cheight, Cwidth * 2, Cheight * 2, null);
//					g.drawOval(gridwidth * (j + 1) + gridwidth / 2 - Cwidth,
//							(i + 1) * gridheight + gridheight / 2 - Cheight, Cwidth * 2, Cheight * 2);
//					g.setColor(new Color(237, 28, 36));
//					g.fillOval((j + 1) * gridwidth + gridwidth / 2 - Cwidth,
//							(i + 1) * gridheight + gridheight / 2 - Cheight, Cwidth * 2, Cheight * 2);
//					g.setColor(new Color(0, 0, 0));
				}
			}
		}
	}

	public void init(Graphics g) {
//		Cheight = gridheight / 3;
//		Cwidth = gridwidth / 3;
		
		// 土匪
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 5; j++) {
				type[i][j] = 1;
				//空白区域
				type[3][j]=0;
			}
		}
		// 红军
		type[4][2] = 2;
		type[4][0] = 2;
		type[4][4] = 2;
		//空白区域
		type[4][1]=0;
		type[4][3]=0;
	}

	public static void main(String[] args) {
		Frame game = new Frame();
		game.showUI();
	}

}
