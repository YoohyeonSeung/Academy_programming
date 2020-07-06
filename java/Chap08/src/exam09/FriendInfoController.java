package exam09;
import java.util.Scanner;
class FriendInfoController {    //입력 받는 데이터를 저장하는 실질적인 메뉴와 데이터의 연동을 수행하는 역할
//	private HighSch[] highfriend ; // 메서드 내에 있으면 메서드가 끝나면 소멸되기때문에 field에 선언
//	private UnivFriend[] univfriend ; 
	private Friend[] friend;
//	private int indexOfHigh;
//	private int indexOfUniv;
	private int indexOfFriend;
		
	FriendInfoController(){
//		highfriend = new HighSch[100]	;
//		univfriend = new UnivFriend[100];
		friend = new Friend[200];
//		indexOfHigh=0;
//		indexOfUniv=0;
	
	}
	
	public void addFriend(int choice) {
		Scanner input =  new Scanner(System.in);
		String name = null, phone = null, address = null, work = null , SchName = null, Class = null;
		
		System.out.print("이름을 입력하세요 . : ");
		name = input.nextLine();
		System.out.print("전화번호를 입력하세요. : ");
		phone = input.nextLine();
		System.out.print("주소 입력하세요. : ");
		address = input.nextLine();
		
		if(choice ==1) {
			System.out.print("반을 입력하세요. : ");
			Class = input.nextLine();
			
			friend[indexOfFriend++] =  new MiddleFriend(name, phone, address, Class);
		}
			
		else if(choice ==2) {
			System.out.print("직업을 입력하세요. : ");
			work = input.nextLine();
			
			friend[indexOfFriend++] =  new HighSch(name, phone, address, work);
			//indexOfHigh++;
		}
		else if(choice==3) {
			System.out.print("학교명을 입력하세요. : ");
			SchName = input.nextLine();
			
			friend[indexOfFriend++] =  new UnivFriend(name, phone, address, SchName);
		}
	}
	
	public void displayFriendInfo(int k) {
		if(k==4) {
			for (int i=0; i<indexOfFriend; i++) {
				friend[i].ShowInfo();  
				// 의도치 않았지만 class별로 메소드를 ShowInfo()로 해놨기에 
				// 메소드 오버라이딩이 되어있다. 이제 java가 알아서 맞는 클래스에 있는 ShowInfo를 찾아간다.
				/*if (friend[i] instanceof MiddleFriend) {
					MiddleFriend middle = (MiddleFriend) friend[i];
					middle.ShowInfo();
					System.out.println("===================");
				}
				else if (friend[i] instanceof HighSch) {
					HighSch high = (HighSch) friend[i];
					high.ShowInfo();
					System.out.println("===================");
				}
				else if(friend[i] instanceof UnivFriend) {
					UnivFriend univ = (UnivFriend) friend[i];
					univ.ShowInfo();
					System.out.println("===================");
				}
	*/		}
		}
		else if(k==5) {
			for (int i=0; i<indexOfFriend; i++) {
				friend[i].ShowBasicInfo(); 
				
				}
			
		}
	}
	
	
	
	/*public void displayFriendInfo(int j) {
		if (j==3) {
			for(int i=0; i<indexOfHigh;i++) {
				System.out.println((i+1) + "번째 저장된 고교 친구" );
				highfriend[i].ShowInfo();
			}
		}
		else if(j==4) {
			for(int i=0; i<indexOfUniv;i++) {
				System.out.println((i+1) + "번째 저장된 대학 친구" );
				univfriend[i].ShowInfo();
			}
		}
	
	
	}
	*/
	
}
