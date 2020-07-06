package exam13;

import java.util.Random;

public class RandomNumberGenerator {

	public static void main(String[] args) {
		
		Random random = new Random();
		
		int num = random.nextInt(91) +10; 
		
		System.out.println("10부터 100사이의 정수값 : "+num);
		
		float f = random.nextFloat();
		
		System.out.println("0.0부터 1.0사이의 임의의 실수값 : "+f);
		
		boolean b = random.nextBoolean();
		System.out.println("임의의 논리 값 : " +b);
	}

}
