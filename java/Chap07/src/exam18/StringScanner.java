package exam18;

import java.util.Scanner; //<- Scanner를 이용하려면 먼저 선언해줘야함

public class StringScanner {

	public static void main(String[] args) {
		String source = "1 5 7";
		Scanner scanner = new Scanner(source);

		int num1=scanner.nextInt();
		int num2=scanner.nextInt();
		int num3=scanner.nextInt();
	
		int sum=num1+num2+num3;
		
		System.out.printf("문자열에 저장된 num1 = %d, num2= %d, num3 = %d, sum = %d" , num1, num2, num3, sum );
		
	}

}
