package exam12;

class OuterClassOne {

	NestedClass nst;
	
	OuterClassOne(){
		nst = new NestedClass();
		nst.simpleMethod();
				
	}
	
	
	public void WhoAreYou() {
		System.out.println("WhoAreYou() 호출");
		//simpleMethod();// error
		nst.simpleMethod();
		}
	
	static class NestedClass{   // nested class
		
		NestedClass(){
			simpleMethod();
			//WhoAreYou(); 위에 있는건 메모리상에 먼저 올라가지 않기때문에 오류
		}
		public void simpleMethod() {
			System.out.println("NestedClass => simpleMethod()");
		}
		
	}
	
}
