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
		// ����
		JFrame Frame = new JFrame();
		// Frame.setLocationRelativeTo(null);
		Frame.setSize(400, 800);
		Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// ����
		FlowLayout layout = new FlowLayout();
		Frame.setLayout(layout);

		// ����
		ImageIcon bgimg = new ImageIcon("guessnum.png");
		JLabel bgpic = new JLabel(bgimg);
		bgpic.setPreferredSize(new Dimension(400, 400));
		Frame.add(bgpic);

		// �ı���
		JTextField word = new JTextField(25);
		Frame.add(word);

		// ��ť
		JButton btn = new JButton("ȷ��");
		JButton btn2 = new JButton("���¿�ʼ");
		Frame.add(btn2);
		Frame.add(btn);
		btn.setPreferredSize(new Dimension(120, 35));
		btn2.setPreferredSize(new Dimension(120, 35));

		// ��¼��
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
		// System.out.println("�����д�");
		// }
	}
}
//73+66+100=239 �д���