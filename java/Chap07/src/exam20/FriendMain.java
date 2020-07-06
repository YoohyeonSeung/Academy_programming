package exam20;

/*
문제1)
     키보드로 5명의 
		
          - 친구 이름(String),
          - 핸드폰번호(String),
          - 주소(String),
          - 나이(int),
		
          를 입력 받아 저장하고, 입력 받은 데이터를 출력하는 
          주소록 관리 프로그램을 객체 지향적 관점으로 작성해 보세요.
 */

import java.util.Scanner;

public class FriendMain {
	
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		Friendsave[] friend = new Friendsave[5];
 		
		for(int i =0; i<2; i++) {
			
			System.out.printf("Insert his name.");
			String name = keyboard.nextLine();
			
			System.out.printf("Insert his phone number.");
			String phone = keyboard.nextLine();
			
			System.out.printf("Insert his address.");
			String Address = keyboard.nextLine();
			
			
			System.out.printf("Insert his age.");
			int age = keyboard.nextInt();
			
			keyboard.nextLine();
	
			friend[i] = new Friendsave(name, phone, Address, age);
			friend[i].Output();
		}	
		
		
	}	
		
		
		
		
		

	

}
