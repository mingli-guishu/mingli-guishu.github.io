package com.guessnum;

import java.awt.FlowLayout;
import java.awt.Dimension;
//import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
//import javax.swing.JLabel;
import javax.swing.JTextArea;
//import javax.swing.ImageIcon;

public class Game {
	public void Show() {
		// 窗体
		JFrame Frame = new JFrame();
		// Frame.setLocationRelativeTo(null);
		Frame.setSize(400, 800);
		Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// 布局
		FlowLayout layout = new FlowLayout();
		Frame.setLayout(layout);

		// 背景
		ImageIcon bgimg = new ImageIcon("guessnum.png");
		JLabel bgpic = new JLabel(bgimg);
		bgpic.setPreferredSize(new Dimension(400, 400));
		Frame.add(bgpic);

		// 文本框
		JTextField word = new JTextField(25);
		Frame.add(word);

		// 按钮
		JButton btn = new JButton("确定");
		JButton btn2 = new JButton("重新开始");
		Frame.add(btn2);
		Frame.add(btn);
		btn.setPreferredSize(new Dimension(120, 35));
		btn2.setPreferredSize(new Dimension(120, 35));

		// 记录区
		JTextArea area = new JTextArea();
		area.setPreferredSize(new Dimension(340, 270));
		area.setEnabled(false);
		Frame.add(area);

		CheckListener CL = new CheckListener();
		btn.addActionListener(CL);
		btn2.addActionListener(CL);
		CL.name = word;
		CL.A = area;

		Frame.setVisible(true);
	}

	public static void main(String[] args) {
		Game ui = new Game();
		ui.Show();
		// try{
		// String str = "12 3";
		// int i = Integer.parseInt(str);
		// }catch(NumberFormatException e){
		// System.out.println("数字有错！");
		// }
	}
}
//73+66+100=239 行代码