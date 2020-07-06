package exam12;

class OuterClassTwo {

	OuterClassTwo(){
		NestedClass nst = new NestedClass();
		nst.simpleMethod();
		
	}
	
	private static class NestedClass{  //OuterClassTwo내에서만 사용하겠다는 의도
		public void simpleMethod() {
			System.out.println("NestedClass => simpleMethod()호출....");
		}
		
		
	}
	
	
	
	
}
