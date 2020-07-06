package exam02;

import java.util.Scanner;

public class ExceptionDividedbyZero {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("두 개의 정수 입력 : ");
		
		
		int num1 = input.nextInt();
		int num2 = input.nextInt();
		
		try {
			System.out.println(num1/num2);
			System.out.println("정상 수행");   //위의 코드를 만난 후에 예외가 발생하면 catch로 가지 예외가 발생한 이후 코드는 실행되지 않음.
		} catch(ArithmeticException e) {
			System.out.println("0으로 나눗셈 불가능");
		}
						
				
				
	}



}
