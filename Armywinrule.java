package com.armyvsbandit;

public class Armywinrule {
	int[][] type;

	public boolean canmove(int m, int n) {
		boolean nextleft = nextmove(m, n - 1);
		boolean nextright = nextmove(m, n + 1);
		boolean nextup = nextmove(m - 1, n);
		boolean nextdown = nextmove(m + 1, n);

		if (nextleft == false && nextright == false && nextup == false && nextdown == false) {
			return false;
		}
		return true;
	}

	
	public boolean acrossmove(int acrossR, int acrossC) {
		if (acrossC > -1 && acrossC < 5 && acrossR > -1 && acrossR < 5) {
			if (type[acrossR][acrossC] == 0 || type[acrossR][acrossC] == 1) {
				return true;
			}
		}
	 return false;
	}

	public boolean nextmove(int nextR, int nextC) {
		if (nextC > -1 && nextC < 5 && nextR > -1 && nextR < 5) {
			if (type[nextR][nextC] == 0) {
				return true;
			}
		}
		return false;
	}
}
