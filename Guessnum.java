package com.guessnum;

//import java.util.Arrays;
import java.util.Random;
//import javax.swing.JOptionPane;

public class Guessnum {

	int rnum;
	int one, ten, hun, thou;
	int ione, iten, ihun, ithou;
	int[] N = new int[15];//�������ִ洢
	int time = 0;

	// ���������ʱ��ִ���ⲿ������
	public Guessnum() {
		// System.out.println("������һ������");
		init();
	}

	public void init() {

		Random rand = new Random();

		thou = rand.nextInt(10); // 0~9
		do {
			hun = rand.nextInt(10);
		} while (hun == thou);// ��λ��ǧλ��ͬ����һֱ�ظ�
		do {
			ten = rand.nextInt(10);
		} while (ten == hun || ten == thou);
		do {
			one = rand.nextInt(10);
		} while (one == ten || one == hun || one == thou);
		rnum = one + ten * 10 + hun * 100 + thou * 1000;
		 System.out.println(thou*1000+hun*100+ten*10+one);
	}

	public int[] guess(int inputnum) {
		// System.out.println(inputnum+" "+rnum);
		if (inputnum != rnum) {
			int A = 0, B = 0;
			// ��������Ϊ�ĸ�����
			ione = inputnum % 10;
			inputnum = inputnum / 10;
			iten = inputnum % 10;
			inputnum = inputnum / 10;
			ihun = inputnum % 10;
			inputnum = inputnum / 10;
			ithou = inputnum % 10;
			inputnum = ione + iten * 10 + ihun * 100 + ithou * 1000;

			// System.out.println("��"+ione+"ʮ"+iten+"��"+ihun+"ǧ"+ithou);
			int inp[] = { ione, iten, ihun, ithou };
			// System.out.println(inp[0]);
			int rr[] = { one, ten, hun, thou };
			// System.out.println("��"+ione+"ʮ"+iten+"��"+ihun+"ǧ"+ithou);
//			System.out.println("��" + one + "ʮ" + ten + "��" + hun + "ǧ" + thou);
			for (int i = 0; i < inp.length; i++) {
				for (int j = 0; j < rr.length; j++) {
					if (inp[i] == rr[i]) {
						A = A + 1;
						break;
					} else if (inp[i] == rr[j] && i != j) {
						B = B + 1;
					}
				}
			}
			if (ione == iten || ione == ihun || ione == ithou || iten == ihun || iten == ithou || ihun == ithou) {
				return new int[] { 5, 0 };
			} else {

				// System.out.println(time + " " + Arrays.toString(N));
				// System.out.println(inputnum);
				if (time > 0) {
					for (int i = 0; i < time; i++) {
						if (N[i] == inputnum) {
							System.out.println("����");
							return new int[] { 6, 0 };
						}
					}
				}
				N[time] = inputnum;
				time = time + 1;
			}
			return new int[] { A, B };// "��ֵ��λ�þ���ͬ" + A + " ��ֵ��ͬ��λ�ò�ͬ" + B;

			// JOptionPane.showConfirmDialog(null, "��ֵ��λ�þ���ͬ" + A + " ��ֵ��ͬ��λ�ò�ͬ"
			// + B, "��ʾ", JOptionPane.CLOSED_OPTION);
			// System.out.println("��ֵ��λ�þ���ͬ" + A + " ��ֵ��ͬ��λ�ò�ͬ" + B);
			// return false;
		}

		return new int[] { 4, 0 };// "��ϲ�㣬�¶��ˣ�";
		// JOptionPane.showConfirmDialog(null, "��ϲ�㣬�¶��ˣ�");
		// return true;

	}

}
