package exam05;

public class FinallyTest {
	
	public static boolean divider(int n1, int n2) {
		
		boolean returnValue = false;
		
		try {
			int result = n1/n2;
			returnValue = true;
			System.out.println("결과 값 : "+result);
		} catch(ArithmeticException e){
			System.out.println("나눗셈 불가능");
			returnValue = false;
		} finally {
			System.out.println("finally 실행");
		}
		
		return returnValue;
	}
	
	public static void main(String[] args) {

		boolean divOK = divider(4,0);
		
		if(divOK) {
			System.out.println("연산 성공");
		} 
		else {
			System.out.println("연산 실패");
		}

	}

}
