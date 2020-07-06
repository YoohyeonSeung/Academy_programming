package exam13;

public class EnhancedFor {
//java 5버전 이상부터 가능한 기능
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5};
		int sum=0;
		
		for(int e : arr ) {
			System.out.println("e = "+ e);  //for이 돌아다닐때마다 stack영역에 메모리가 할당되나, 사용이 끝나면 소멸됨
			sum+=e;
		}
		
		System.out.println("배열 요소의 합 : " + sum);
		
		
		
	}
	

}
