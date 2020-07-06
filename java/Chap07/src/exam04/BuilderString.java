package exam04;

public class BuilderString {

	public static void main(String[] args) {
		StringBuffer stringBuilder = new StringBuffer("StringBuilder 클래스"); 
		//StringBuilder stringBuilder = new StringBuilder("StringBuilder 클래스");  stringbuffer나 stringbuiler나 같은 동작은 한다.
		//여기서 오류가 더 뜨면 폴더내에 StringBuilder.java를 찾아가게됨(만약 있다면..)
		
		String str = 1+"+" +3;
		
		System.out.println(str);
		
		/*stringBuilder.append(true);
		stringBuilder.append('ㅇ');
		stringBuilder.append(222234);
		stringBuilder.append(3.14);*/
		
		stringBuilder.append(true).append('A').append(25).append(3.14);

		System.out.println(stringBuilder); // 결과값을 보면 알겠지만 문자열 처럼  true가 추가됨
		
		stringBuilder.insert(2, false);
		System.out.println(stringBuilder);
	}

}
