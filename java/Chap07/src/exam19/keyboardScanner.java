package exam19;

import java.util.Scanner;

public class keyboardScanner {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("덧셈 연산 수행 프로그램.");
		System.out.print("첫번째 정수값 입력 : ");
		int num1 = keyboard.nextInt();
		
		System.out.print("두번째 정수값 입력 : ");
		int num2 = keyboard.nextInt();
		
		System.out.printf("%d + %d = %d\n", num1, num2, num1+num2);
		
		keyboard.nextLine();  // dummy code
		
		System.out.print("당신의 이름은?"); //(숫자를 입력받다가 다음에 문자를 입력받는경우)
		//-> num2를 입력을 받은 후에 엔터 쳤던 것이 기억이 남아 다음 문자열에 엔터를 받아버린것
		// 그러므로 위에 dummy code를 넣어줌으로써 엔터(\n)를 해결하게된다.
		
		String name = keyboard.nextLine();
		
		System.out.printf("당신의 이름은 %s 이군요.\n", name);
		
	}

}
