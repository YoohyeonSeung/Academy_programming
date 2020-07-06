package exam07;

public class MethodOverloading {
	
	public static void main(String[] args) {
		Adder adder = new Adder();   //인스턴스! 메모리 할당 adder라는 참조변수
		
		System.out.println(adder.add(2,3));
		System.out.println(adder.add(2,3,4));
		
		System.out.println(adder.add(2,'헐')); 
		//문자가 자동형 변환에 의하여 int또는 double형으로 하는데 Add클래스에서 가장 가까운 것으로 호출

	}

}
