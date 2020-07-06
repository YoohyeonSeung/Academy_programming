package exam03;

public class RuntimeExceptionCase {

	public static void main(String[] args) {
		
		/*int index = -1;
		
		
		
		try {
			int[] arr = new int[3];
			arr[index] = 20;
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println(e.getMessage());
		}
		*/
		/*try {
			Object obj = new int[10];
			String str = (String) obj;
		}catch(ClassCastException e) {
			System.out.println(e.getMessage());
		}*/
		
		
		
		/*try {
			int[] arr = new int[-10];
		}catch(NegativeArraySizeException e) {
			System.out.println(e.getMessage());
		}*/
		
		
		try {
			String name = null; //엄밀히 말하면 주소값에 아무것도 저장되있지 않음.
		
			int length = name.length();
		}catch(NullPointerException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("프로그램 종료....");
	}

}
