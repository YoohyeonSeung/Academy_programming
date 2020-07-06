package exam03;

public class StringEquals {

	public static void main(String[] args) {
		String str1 = new String("Hi, my string");
		String str2 = new String("Hi, my string");
		
		if (str1==str2) {
		
			System.out.println("인스턴스 값 일치");
		}
		else {
			System.out.println("인스턴스 값 불일치");
		}
		
		if (str1.equals(str2)) {
			System.out.println("문자열 내용 일치");
		}else{
			System.out.println("문자열 내용 불일치");
		}
		
		

	}

}
