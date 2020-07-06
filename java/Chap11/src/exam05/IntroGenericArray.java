package exam05;

public class IntroGenericArray {
	public static void main(String[] args) {
		String[] strArr = {"Hi", "I'm so happy", "Java Generic Programming"};
		
		
		showArrayData(strArr);
	}

	
	public static <T> void showArrayData(T[] arr) {
		for(int i=0; i<arr.length; i++) {
			System.out.println(arr[i]);
		}
		
		
		
		
	}
	
	
	
}
