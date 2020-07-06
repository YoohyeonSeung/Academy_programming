package exam11;

class ClassPrinter {

	public static void print(Object obj) {  
		//이렇게 하면 어떤 자료형이던 입력가능
		
		String org = obj.toString();
		
		if( obj instanceof UpperCasePrintable ) {
			org = org.toUpperCase();  //전부다 대문자로 바꾸는 메소드
		}
		
		System.out.println(org);
		
		
	}
}
