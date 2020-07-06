package exam08;

public class ExceptionHandlerUseTryCatch {

	public static void main(String[] args) {
		int index=-1;
		try {
			int[] arr = new int[3];
			arr[index]=20;
			
			System.out.println(arr[index]);
			
			Object obj = new int[10];
			String str = (String) obj;
			
			int[] Arr = new int[-10];
			
			
		}catch(Exception e){
			System.out.println("ArrayIndex"+e.getMessage());
		}
		
		
		
		
		
		
		

	}

}
