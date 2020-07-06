package exam09;

public class AutoBoxingAutoUnBoxing {

	public static void main(String[] args) {
		Integer iValue  = 100;    // new Integer(100); //AutoBoxing
		
		
		//AutoUnBoxing
		System.out.println(iValue);    //  		System.out.println(iValue.intValue);
		
		
		
		int num = iValue; // AutoUnboxing
		System.out.println(num);
		
		
		
		

	}

}
