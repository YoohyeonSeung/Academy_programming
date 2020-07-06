package exam14;

import java.math.BigInteger;

public class SoBigInteger {

	public static void main(String[] args) {
		System.out.println("최대정수"+ Long.MAX_VALUE);
		System.out.println("최대정수"+ Long.MIN_VALUE);
		
		BigInteger bigValue1 = new BigInteger("10000000000000000000");
		BigInteger bigValue2 = new BigInteger("-9999999999999999999");
		
		
		BigInteger addResult = bigValue1.add(bigValue2);
		BigInteger mulResult = bigValue1.multiply(bigValue2);
		
		System.out.println(addResult);
		System.out.println(mulResult);
		
		
	}

}
