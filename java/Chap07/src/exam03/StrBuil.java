package exam03;

public class StrBuil {
	
	public StrBuil() {}  //...(1)
	
	public static void main(String[] agrs) {
		
		//StringBuilder stringBuilder = new StringBuilder("StringBuilder 클래스"); 
		//코드 내에 가장 가까이에 있는 놈을 보니 위에 class StringBuilder를 참조하는데 아무것도 정의 되어있지 않다. 심지어 메모리도 할당되있지 않다.
		
		StrBuil stringBuilder = new StrBuil();  //얘는 (1)을 호출
		stringBuilder.abc();
		// 밑의 메서드도 static으로 선언하지 않는 순간 위의 코드는 오류가 나온다.
		// static이 없는데 오류가 뜨지 않으려면 위의 코드로 하면됨
	}
	
	public void abc() {
		
	}
}
