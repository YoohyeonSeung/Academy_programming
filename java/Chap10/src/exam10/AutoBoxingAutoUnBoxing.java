package exam10;

public class AutoBoxingAutoUnBoxing {

	public static void main(String[] args) {

		Integer num1 = 10;
		Integer num2 = 20;
		
		
		num1++; //  num1 = new Integer(num1.intValue() +1 ); 과 같은 코드
		System.out.println(num1);
		

		num2 +=3 ; 
		
		System.out.println(num2);
		
		
		int addResult = num1+num2;
		System.out.println(addResult);
		
	}

}
