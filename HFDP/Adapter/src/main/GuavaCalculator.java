
package src.main;

import com.google.common.math.IntMath;
import java.math.RoundingMode;

public class GuavaCalculator {

	private RoundingMode rm;

	public GuavaCalculator(RoundingMode rm) {
		this.rm = rm;
	}	

	public int satAdd(int a, int b) {
		return IntMath.saturatedAdd(a,b);
	}

	public int satSub(int a, int b) {
		return IntMath.saturatedSubtract(a,b);
	}

	public int satMult(int a, int b) {
		return IntMath.saturatedMultiply(a,b);
	}
	
	public int divideWithRounding(int a, int b) {
		return IntMath.divide(a,b,rm);
	}

}

