package Tick2;

import java.lang.Math;

public class LCSBottomUp extends LCSFinder {

	public LCSBottomUp(String s1, String s2) {
		super(s1, s2);
		generateTable();
	}

	public void generateTable() {
		mTable = new int[mString1.length()+1][mString2.length()+1];
		for (int i = 0; i <= mString1.length(); i++) {
			for (int j = 0; j <= mString2.length(); j++) {
				if (i == 0 || j == 0)
					mTable[i][j] = 0;
				else if (mString1.charAt(i - 1) == mString2.charAt(j - 1))
					mTable[i][j] = 1 + mTable[i-1][j-1];
				else
					mTable[i][j] = Math.max(mTable[i-1][j], mTable[i][j-1]);
			}
		}
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

	public static void main(String[] args) {
		LCSBottomUp lcs = new LCSBottomUp("xaxbxcxd", "aabbccdd");
		System.out.println(lcs.getLCSLength());
		System.out.println(lcs.getLCSString());
	}
}
