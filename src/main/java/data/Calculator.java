package data;

public class Calculator {
	
	public static int pow(int number, int exponent) {
		int result = 1;
		while(exponent-- > 0)
			result *= number;
		return result;
	}

}
