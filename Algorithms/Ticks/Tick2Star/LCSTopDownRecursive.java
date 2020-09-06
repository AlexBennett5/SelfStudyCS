package Tick2Star;

import java.lang.Math;

public class LCSTopDownRecursive extends LCSFinder {

	public LCSTopDownRecursive(String s1, String s2) {
		super(s1, s2);
		generateTable();
	}

	public void generateTable() {
		mTable = new int[mString1.length() + 1][mString2.length() + 1];
		for (int i = 0; i < mString1.length() + 1; i++) {
			for (int j = 0; j < mString2.length() + 1; j++) {
				mTable[i][j] = -1;
			}
		}
		generateTableRecursive(mString1, mString2, mTable);
	}

	private int generateTableRecursive(String s1, String s2, int[][] table) {
		int n = s1.length();
		int m = s2.length();
		String a, b;
		if (table[n][m] == -1) {
			if (n == 0 || m == 0) {
				table[n][m] = 0;
			} else if (s1.charAt(n-1) == s2.charAt(m-1)) {
				a = s1.substring(0, s1.length() - 1);
				b = s2.substring(0, s2.length() - 1);
				table[n][m] = 1 + generateTableRecursive(a, b, table);
			} else {
				a = s1.substring(0, s1.length() - 1);
                                b = s2.substring(0, s2.length() - 1);
				table[n][m] = Math.max(generateTableRecursive(a, s2, table), generateTableRecursive(s1, b, table));
			}
		}
		return table[n][m];	
	}

	public int getLCSLength() {
		return mTable[mTable.length - 1][mTable[0].length - 1];
	}

	public String getLCSString() {
		int i = mString1.length();
		int j = mString2.length();
		String res = "";
		while (i > 0 && j > 0) {
			if (mString1.charAt(i-1) == mString2.charAt(j-1)) {
				res = mString1.charAt(i-1) + res;
				--i;
				--j;
			} else if (mTable[i-1][j] > mTable[i][j-1]) {
				--i;
			} else {
				--j;
			}
		}
		return res;
	}
}
