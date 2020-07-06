package exam09;
import java.util.Scanner;
class Menu {
	private FriendInfoController controller ;
	
	Menu(){
		controller = new FriendInfoController();
	}
	
	public void displayMenu() {
				
		while(true) {
			System.out.println("******* 메뉴 선택 *******");
			System.out.println("0. 프로그램 종료");
			System.out.println("1. 중학교 친구 정보 저장");
			System.out.println("2. 고교 친구 정보 저장");
			System.out.println("3. 대학 친구 정보 저장");
			System.out.println("4. 친구 정보 출력");
			System.out.println("5. 친구의 기본 정보 출력");
			
//			System.out.println("4. 대학 친구 정보 출력");
			
			System.out.println("원하시는 항목 번호를 선택하세요.");
			Scanner input = new Scanner(System.in);
			int choice = input.nextInt();
			
			switch(choice) {
				case 0:
					System.out.println("프로그램을 종료합니다.");
					return;           //->메서드 안에서 return을 만나면 메서드를 벗어남.
					
				case 1: case 2 : case 3:
					controller.addFriend(choice);
					break;
				case 4 : case 5:
					controller.displayFriendInfo(choice);
					break;
				
			/*	case 3: case 4:
					controller.displayFriendInfo(choice);
					break;*/
				
					
				default:
					System.out.println("잘못된 입력을 하셨습니다.");
					System.out.println("메뉴 번호를 확인하세요.\n");
					break;    //->스위치문을 벗어나서 while문 처음으로 가는 방법
					
			}
			
		}
		
		
		
		
		
	}
	
	
	
	
	
	
}
