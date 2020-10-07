package com.guessnum;

import java.awt.event.ActionListener;
//import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class CheckListener implements ActionListener {
	JTextField name;
	JTextArea A;
	int time = 1;

	Guessnum g = new Guessnum();

	public void actionPerformed(ActionEvent e) {

		String bname = name.getText();
		String cmd = e.getActionCommand();
		if ("���¿�ʼ".equals(cmd)) {
			g.init();
			time = 1;
			A.setText("");
			g = new Guessnum();
		} else {
		}
		if ("ȷ��".equals(cmd)) {
			if (bname.length() != 4) {
				JOptionPane.showConfirmDialog(null, "������һ����λ��!", "��ʾ", JOptionPane.CLOSED_OPTION);
				return;
			}
			try {
				int inputnum = Integer.parseInt(bname);
				// if (time > 11) {
				// JOptionPane.showConfirmDialog(null, "��ô��ζ��²����������¿�ʼ��!", "��ʾ",
				// JOptionPane.CLOSED_OPTION);
				// }
				int[] re = g.guess(inputnum);
				// System.out.println(re[0]+" "+re[1]);
				if (re[0] == 4) {
					// g.init();
					JOptionPane.showConfirmDialog(null, "you win", "��ʾ", JOptionPane.CLOSED_OPTION);
					A.append(time + "." + bname + "   " + re[0] + "A" + re[1] + "B\r\n");
					time = time + 1;
				} else {
					if (re[0] == 5) {
						JOptionPane.showConfirmDialog(null, "ÿ�����ֲ�����ͬ��", "��ʾ", JOptionPane.CLOSED_OPTION);
					} else {
						if (re[0] == 6) {
							JOptionPane.showConfirmDialog(null, "�������ظ�!", "��ʾ", JOptionPane.CLOSED_OPTION);
						} else {
							A.append(time + "." + bname + "   " + re[0] + "A" + re[1] + "B\r\n");
							time = time + 1;
						}

					}

				}
			} catch (NumberFormatException a) {
				JOptionPane.showConfirmDialog(null, "������һ����λ��!", "��ʾ", JOptionPane.CLOSED_OPTION);
				// System.out.println("wrong");
			}
		}
	}
}
