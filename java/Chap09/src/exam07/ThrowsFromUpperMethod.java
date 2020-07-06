package exam07;

import java.util.Scanner;

class AgeInputException extends Exception{
	
	AgeInputException(){
		super("유효하지 않은 나이를 입력하셨습니다."); //부모 클래스의 생성자 호출		
		
	}
}

public class ThrowsFromUpperMethod {

	public static int readAge() throws AgeInputException {
		Scanner input = new Scanner(System.in);
		int age = input.nextInt();
		
		if(age<0) {
			AgeInputException excpt = new AgeInputException();
			
			throw excpt; //->예외를 발생시켜 catch문을 찾으러감
		}		
		return age;
	}
	
	public static int callAge() throws AgeInputException {
		int age = readAge();
		return age;
	}
	
	public static void main(String[] args) {
		
		System.out.println("나이를 입력하세요 : ");
		
		try {
			int age = callAge();
			
			System.out.println("당신의 나이는"+ age +"이군요");
		} catch (AgeInputException e) {
			
			e.printStackTrace();
		}
		
	}
	
	
	
	
}
