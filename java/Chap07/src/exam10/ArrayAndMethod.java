package exam10;


public class ArrayAndMethod {

	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5};
		int[] ref = null; 
		boolean bool=false;
		int num=5;
		
		/*참조변수 선언(int[] arr;  또는 boolean bool; 라는 식으로 할땐 java가 각 자료형에 알아서 
		 * 메모리 배정을 하지만 우리가 쓸때, 용량이 작은경우 쓰래기값이 저장되는경우가 있다 
		 * 그런걸 방지하기 위해 배열은null, 정수는 0, 실수는0.0, boolean은 false로 한다. 
		*/
		
		//System.out.println(bool);
		
		ref=addAllArray(arr);
		
		for(int i=0; i<arr.length; i++) {
			System.out.println(ref[i]);
		}
		
	
	}
	
	public static int[] addAllArray(int[] a) {
		;
		for(int i=0; i < a.length; i++ ) {
			a[i]+=10;
		}		
		
		return a;
	}

}
