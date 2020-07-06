package Library;

import java.util.Scanner;

class Menu {
	RegistPerson controller;
	
	Menu(){
		controller = new RegistPerson();
		
	}
	public void ShowMenu(){
		while(true) {
			System.out.println("*****프로그램이 시작되었습니다. ***** ");
			System.out.println("메뉴를 선택해주세요. ");
			System.out.println("0. 회원등록(학생)");
			System.out.println("1. 회원등록(성인) ");
			System.out.println("2. 전체 회원 정보 출력 ");
			System.out.println("3. 전체 회원 기본 정보 출력 ");
			System.out.println("4. 프로그램 종료 ");
			
			Scanner input = new Scanner(System.in);
			int j = input.nextInt();
			input.nextLine(); // dummy code
			
			switch(j) {
			case 0 : case 1 :
				controller.RegistMem(j);
				break;
			case 2 : case 3:
				controller.ShowInfo(j);
				break;
		
			case 4 : 
				return;			
				
			default :
				System.out.println("잘못된 입력을 하셨습니다.");
				System.out.println("메뉴 번호를 확인하세요.\n");
				break;
			}
		}	
	}

}
