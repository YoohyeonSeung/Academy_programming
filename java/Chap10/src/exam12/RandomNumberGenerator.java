package exam12;

import java.util.Random;


public class RandomNumberGenerator {

	public static void main(String[] args) {
		Random random = new Random(12);
		
		random.setSeed(System.currentTimeMillis());
		
		
		for(int i=0; i<10; i++) {
			System.out.println(random.nextInt(100)); //0~99사이의 값중 하나를 랜덤하게 뽑아줌
			
			
			
		}
		
		
		

	}

}
