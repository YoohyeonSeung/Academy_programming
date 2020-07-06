package exam01;

import java.util.Scanner;
// import java.lang.*;    compile과정에서 자동 생성
 
public class ExceptionIF {
	public static void main(String[] agrs) {
		Scanner keyboard = new Scanner(System.in);
		String name = "홍길동";
		
		System.out.println("피제수 입력 : ");
		int num1 = keyboard.nextInt();
		
		System.out.println("제수 입력 : ");
		int num2 = keyboard.nextInt();
		
		if (num2==0) {
			System.out.println("0으로 나눌 수 없습니다.");
		}
		else {
					
			System.out.println("결과값 : " + (num1/num2));
		}
	}
}