package exam05;

public class HasAinheritance {
	public static void main(String[] args) {
		Police police1 = new Police(30, 2);
//		Police police2 = new Police(0, 3);
		
		
		// has A관계보다 is A관계에서 가장많이 씀
		police1.bbang();
		police1.putHandcuff();
	
//		police2.bbang();
//		police2.putHandcuff();
		
		
		
	}


}
