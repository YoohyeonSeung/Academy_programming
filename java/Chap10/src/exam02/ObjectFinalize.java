package exam02;

class MyName extends Object{
	
	String name;
	
	MyName(String name){
		this.name = name;
	}

	@Override
	protected void finalize() throws Throwable {
		
		super.finalize();  //오브젝트가 자바에 의해 heap의 메모리가 소멸될 때 호출
		System.out.println(name+"이/가 소멸되었습니다.");
		
	}
	
}
public class ObjectFinalize {
	

	public static void main(String[] args) {
		System.out.println("프로그램 시작.");
		
		MyName obj1 = new MyName("인스턴트1");
		MyName obj2 = new MyName("인스턴트2");
		MyName obj3 = obj2;
		
		
		obj1 = null;   
		obj2 = null;
		obj3 = null;
		
		System.gc();         
		//소멸시킬 메모리가 있는지 검색하는 시간을 할당해주는 메소드.
		System.runFinalization();
		//더이상 참조하는 놈이 없을때 소멸 다 하고 나와
		System.out.println("프로그램 종료.");
		
	}

}
