
package Decorator;

import java.util.Arrays;
import java.util.Random;

public class Test {

	public static void main(String[] args) {

		Random rand = new Random();
		int n = Integer.parseInt(args[0]);
		char[] arr = new char[n];

		for (int i = 0; i < n; i++) {
			arr[i] = (char) (rand.nextInt(76) + 49);
		}

		BaseComponent base = new BaseComponent(arr);
		ShiftLeftEncrypt left = new ShiftLeftEncrypt(base);
		AdderEncrypt leftAdd = new AdderEncrypt(left);

		SubtractEncrypt sub = new SubtractEncrypt(base);
		ShiftRightEncrypt subRight = new ShiftRightEncrypt(sub);

		ShiftRightEncrypt leftAddRight = new ShiftRightEncrypt(leftAdd);

		ShiftRightEncrypt subRightRight = new ShiftRightEncrypt(subRight);

		SubtractEncrypt subRightRightSub = new SubtractEncrypt(subRightRight);

		printEncrypt(base);
		printEncrypt(leftAdd);
		printEncrypt(subRight);
		printEncrypt(leftAddRight);
		printEncrypt(subRightRight);
		printEncrypt(subRightRightSub);


	}

	public static void printEncrypt(IComponent comp) {

		char[] arr = comp.encrypt();

		System.out.println(comp.getName());
		System.out.println(Arrays.toString(arr));

	}

}

