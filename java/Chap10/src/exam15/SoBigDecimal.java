package exam15;

import java.math.BigDecimal;

public class SoBigDecimal {

	public static void main(String[] args) {
		
		double e1 = 1.6;
		double e2 = 0.1;
		
		System.out.println(e1+e2);
		System.out.println(e1*e2);
		
		
		BigDecimal ee1 = new BigDecimal("1.6");
		BigDecimal ee2 = new BigDecimal("0.1");
		
		System.out.println(ee1.add(ee2));
		System.out.println(ee1.multiply(ee2));
		
		
	}

}
