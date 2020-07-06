package exam09;

public class InstanceArray {

	public static void main(String[] args) {
		String[] strArr = new String[3];   // String strArr[];과같음, Heap영역에 자료가 저장될 메모리의 주소가 저장 될 메모리를 할당 받고 string이므로 8바이트짜리 3개 생성!
		
		
		strArr[0] = new String("홍길동");
		strArr[1] = "이순신";
		strArr[2] = "강감찬";

		for(int i=0; i<strArr.length; i++) {
			System.out.println(strArr[i]);
		}
	}

}
