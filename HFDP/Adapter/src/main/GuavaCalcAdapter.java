
package src.main;

public class GuavaCalcAdapter implements ICalculator {

	private GuavaCalculator calc;

	public GuavaCalcAdapter(GuavaCalculator calc) {
		this.calc = calc;
	}

	public int add(int a, int b) {
		return calc.satAdd(a,b);
	}

	public int subtract(int a, int b) {
		return calc.satSub(a,b);
	}

	public int multiply(int a, int b) {
		return calc.satMult(a,b);
	}

	public int divide(int a, int b) {
		return calc.divideWithRounding(a,b);
	}

	public String calcName() {
		return "Guava Calculator";
	}
}

