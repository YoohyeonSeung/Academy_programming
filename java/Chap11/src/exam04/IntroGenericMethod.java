package exam04;

class FatherClass extends Object {
	@Override
	public String toString() {  
		return "class FatherClass";
	}
}

class ChildClass{
	@Override
	public String toString() {  
		return "class ChildClass";
	}
}

class InstanceTypeShower{
	private int showCnt;
	InstanceTypeShower(){ showCnt=0; }
	
	public <T> void showInstType( T inst ) {
		showCnt++;
		System.out.println(inst);
	}
	
	public <T, U> void showInstType2(T inst1, U inst2) {
		showCnt++;
		System.out.println(inst1);
		System.out.println(inst2);
	}
	
	
	public void showPrintCnt() {
		System.out.println("showCnt = "+ showCnt);
	}
	
}


public class IntroGenericMethod {

	public static void main(String[] args) {
		FatherClass father = new FatherClass();
		ChildClass child =  new ChildClass();
		
		InstanceTypeShower shower = new InstanceTypeShower();
		
		shower.<FatherClass>showInstType(father);
		//shower.showInstType(father);    이코드도 사용가능
		//shower.<FatherClass>showInstType(child);    FatherClass만 취급하기로 generic을 사용했기 때문에  child는 오류!
		
		shower.<FatherClass, ChildClass>showInstType2(father, child);
		// shower.showInstType2(father, child);
		
		
		shower.showPrintCnt();
		
		
	}

}
