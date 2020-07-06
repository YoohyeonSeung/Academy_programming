package YooHS181127;
import java.util.Scanner;
class Menu {
	private FriendInfoController controller ;
	
	Menu(){
		controller = new FriendInfoController();
	}
	
	public void displayMenu() {
		
		controller.CheckStorageFile();
					
		while(true) {
			System.out.println("******* 메뉴 선택 *******");
			System.out.println("0. 프로그램 종료");
			System.out.println("1. 중학교 친구 정보 저장");
			System.out.println("2. 고교 친구 정보 저장");
			System.out.println("3. 대학 친구 정보 저장");
			System.out.println("4. 친구 정보 출력");
			System.out.println("5. 친구의 기본 정보 출력");
			System.out.println("6. 친구 검색");
			System.out.println("7. 친구 삭제");
			
			System.out.println("원하시는 항목 번호를 선택하세요.");
					
			Scanner input = new Scanner(System.in);
			int choice = input.nextInt();
			
			switch(choice) {
				case 0:
					controller.SaveAddress();
					System.out.println("프로그램을 종료합니다.");
					return;        
					
				case 1: case 2 : case 3:
					controller.addFriend(choice);
					break;
				case 4 : case 5:
					controller.displayFriendInfo(choice);
					break;
				case 6 :
					controller.FindFriend();
					break;
				case 7 : 
					controller.DeleteFriend();
					break;
					
				default:
					System.out.println("잘못된 입력을 하셨습니다.");
					System.out.println("메뉴 번호를 확인하세요.\n");
					break;  
					
			}
			
		}
		
		
		
		
		
	}
	
	
	
	
	
	
}
