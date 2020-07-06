package exam21;

import java.util.StringTokenizer;

public class TokenizerString {

	public static void main(String[] args) {
		String data = "11:22:33:44:55:홍길동";
		String phoneNum = "TEL 82-02-1234-5678";

		System.out.println("====== 1 Result ======");
		
		StringTokenizer st1 = new StringTokenizer(data);
	
		while(st1.hasMoreTokens()) {
			System.out.println(st1.nextToken());
			
			
			
		}
		
		System.out.println("====== 2 Result ======");
		
		st1 = new StringTokenizer(data, ":");
	
		while(st1.hasMoreTokens()) {
			System.out.println(st1.nextToken());
				
			
		}
		
		System.out.println("====== 3 Result ======");
		
		StringTokenizer st2 = new StringTokenizer(phoneNum," -");
	
		while(st2.hasMoreTokens()) {
			System.out.println(st2.nextToken());
		}
		
		System.out.println("====== 4 Result ======");
		
		st2 = new StringTokenizer(phoneNum);
	
		while(st1.hasMoreTokens()) {
			System.out.println(st2.nextToken());
		}
		
		System.out.println("====== 5 Result ======");
		st2 = new StringTokenizer(phoneNum," -");
		
		while(st1.hasMoreTokens()) {
			System.out.println(st2.nextToken());
		}

	}
}












