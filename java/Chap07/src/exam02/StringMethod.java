package exam02;

public class StringMethod {

	public static void main(String[] args) {
		String str1 = "Smart";
		String str2 = " and ";
		String str3 = "Simple";
		String str4;
		
		//System.out.println(str1.concat(str2));
		str4 = str1.concat(str2);
		System.out.println(str4.concat(str3));
		
		//위의 두줄과 밑에 한줄은 똑같은 코드이다 차이점이라고 해봤자 위에서는 변수 하나에 따로 한번 저장한 것 뿐이다.
		System.out.println(str1.concat(str2).concat(str3));
		
		if(str1.compareTo(str3) > 0) {
			System.out.println(1);
			
			
		}else if(str1.compareTo(str3) < 0){
			System.out.println(-1);
			
			
		}else { System.out.println(0);
			
			
		}
		
		
		
		
		
	}

}
