package exam08;

public class JavaArrayLength {

	public static void main(String[] args) {
		//int[] age = new int[] {20, 25, 28};  아래의 코드도 같은 코드이다. 배열형의 데이터를 넣을땐 아래 형태로 많이 이용함.
		//int age[] = {22,24,24};
		int[] age = {23, 25, 28};
		
		for(int i=0; i<age.length; i++) {
			System.out.println("나이 : "+ age[i]);
		}
	}

}
