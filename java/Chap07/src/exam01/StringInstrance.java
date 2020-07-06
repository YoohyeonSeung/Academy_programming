package exam01;

public class StringInstrance {

	public static void main(String[] args) {
		String hello =  new String("여러분, 안녕하세요!!!");
		String name1 = new String("홍길동");
		String name2 = new String("홍길동"); 
		//new 할 때 마다 각각이 메모리가 다르게 할당되므로 name1의 주소와 name2의 주소가 다르다.
		String name3 = "홍길동";
		String name4 = "홍길동";
		
		// new를 사용하여 저장한 것과 안써서 저장한 것의 차이점
		// new를 만나면 무조건 메모리 할당
		// new를 쓰지 않으면 같은 값이 저장되어있는지 여부를 판독 한 이후에 같은 값을 가진 것이 있다면, 그 주소로 반환한다.
		// new를 사용하지 않아서 같은 값이 저장된 곳을 찾는 것이 cpu입장에서 가장 빠름 고로 new를 사용하는거보다 훨씬 빠르기 때문에
		// new를 사용하지 않는 것이 좋다. 
		
		
		System.out.println(hello); //주소값이 출력 될 줄 알았으나, 문자열이 출력함.
		System.out.println(hello.length());
		

		if(name1 == name2) {
			System.out.println("동일 인스턴스 참조");
		}else {
			System.out.println("다른 인스턴스 참조");
			
		}
		if(name3 == name4) {
			System.out.println("동일 인스턴스 참조");
		}else {
			System.out.println("다른 인스턴스 참조");
			
		}
		
		int length = "Hello, Java World".length();    //전혀 예외적인 상황이 아니다. new 등의 절차가 이미 숨어있음 
		
		System.out.println(length);
		
	}
	

}
