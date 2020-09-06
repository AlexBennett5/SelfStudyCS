package Tick2Star;

import java.lang.Math;
import java.util.Stack;

public class LCSTopDownNonRecursive extends LCSFinder {

	public enum Action {
		CALL, MAX, RETURN, RETURN_PLUS_ONE
	}

	class StackInfo {
		Action action;
		int n;
		int m;
		int retn;
		int retm;

		StackInfo(Action action, int n, int m, int retn, int retm) {
			this.action = action;
			this.n = n;
			this.m = m;
			this.retn = retn;
			this.retm = retm;
		}
	}

	public LCSTopDownNonRecursive(String s1, String s2) {
		super(s1, s2);
		generateTable();
	}

	public void generateTable() {
		mTable = new int[mString1.length() + 1][mString2.length() + 1];
		mTable[0][0] = 0;
		Stack<StackInfo> stk = new Stack<StackInfo>();
		stk.push(new StackInfo(Action.CALL, mString1.length(), mString2.length(), 0, 0));
		
		Action action;
		int n, m, retn, retm;

		while(!stk.empty()) {
			StackInfo curr = stk.pop();
			action = curr.action;
			n = curr.n;
			m = curr.m;
			retn = curr.retn;
			retm = curr.retm;

			switch(action) {
				case CALL:
					if (n == 0 || m == 0) {
						stk.push(new StackInfo(Action.RETURN, n, m, 0, 0));
					} else if (mString1.charAt(n-1) == mString2.charAt(m-1)) {
						stk.push(new StackInfo(Action.RETURN_PLUS_ONE, n, m, n-1, m-1));
						stk.push(new StackInfo(Action.CALL, n-1, m-1, 0, 0));
					} else {
						stk.push(new StackInfo(Action.MAX, n, m, 0, 0));
						stk.push(new StackInfo(Action.CALL, n-1, m, 0, 0));
						stk.push(new StackInfo(Action.CALL, n, m-1, 0, 0));
					}
					break;
				case MAX:
					if (mTable[n-1][m] > mTable[n][m-1])
						stk.push(new StackInfo(Action.RETURN, n, m, n-1, m));
					else
						stk.push(new StackInfo(Action.RETURN, n, m, n, m-1));
					break;
				case RETURN_PLUS_ONE:
					mTable[n][m] = 1 + mTable[retn][retm];
					break;
				case RETURN:
					mTable[n][m] = mTable[retn][retm];
					break;
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
}
