package ab.practice.tick1star;

public class InspectDouble {

        public static void main(String[] args) throws Exception {

                double d = Double.parseDouble(args[0]);

                long bits = Double.doubleToLongBits(d);

                boolean negative = (0x8000000000000000L & bits) != 0;

                long exponent = ((0x7ff0000000000000L & bits) >> 52) - 1023;

                long mantissabits = (0xfffffffffffffL & bits);

                double mantissa = mantissaToDecimal(mantissabits);

                System.out.println((negative ? "-" : "") + mantissa + " x 2^" + exponent);
        }

	 private static double mantissaToDecimal(long mantissabits) {

                long one = 0x0010000000000000L;
                return (double)(mantissabits + one) / (double)one;
        }

}
