package com.guessnum;

//import java.util.Arrays;
import java.util.Random;
//import javax.swing.JOptionPane;

public class Guessnum {

	int rnum;
	int one, ten, hun, thou;
	int ione, iten, ihun, ithou;
	int[] N = new int[15];//用于数字存储
	int time = 0;

	// 创建对象的时候，执行这部分内容
	public Guessnum() {
		// System.out.println("创建了一个对象");
		init();
	}

	public void init() {

		Random rand = new Random();

		thou = rand.nextInt(10); // 0~9
		do {
			hun = rand.nextInt(10);
		} while (hun == thou);// 百位和千位相同，则一直重复
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
			// 将参数拆为四个数字
			ione = inputnum % 10;
			inputnum = inputnum / 10;
			iten = inputnum % 10;
			inputnum = inputnum / 10;
			ihun = inputnum % 10;
			inputnum = inputnum / 10;
			ithou = inputnum % 10;
			inputnum = ione + iten * 10 + ihun * 100 + ithou * 1000;

			// System.out.println("个"+ione+"十"+iten+"百"+ihun+"千"+ithou);
			int inp[] = { ione, iten, ihun, ithou };
			// System.out.println(inp[0]);
			int rr[] = { one, ten, hun, thou };
			// System.out.println("个"+ione+"十"+iten+"百"+ihun+"千"+ithou);
//			System.out.println("个" + one + "十" + ten + "百" + hun + "千" + thou);
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
							System.out.println("错误");
							return new int[] { 6, 0 };
						}
					}
				}
				N[time] = inputnum;
				time = time + 1;
			}
			return new int[] { A, B };// "数值与位置均相同" + A + " 数值相同但位置不同" + B;

			// JOptionPane.showConfirmDialog(null, "数值与位置均相同" + A + " 数值相同但位置不同"
			// + B, "提示", JOptionPane.CLOSED_OPTION);
			// System.out.println("数值与位置均相同" + A + " 数值相同但位置不同" + B);
			// return false;
		}

		return new int[] { 4, 0 };// "恭喜你，猜对了！";
		// JOptionPane.showConfirmDialog(null, "恭喜你，猜对了！");
		// return true;

	}

}
