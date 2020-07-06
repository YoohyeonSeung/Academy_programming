package YooHS181127;
import java.util.Scanner;
import java.util.HashSet;
import java.util.Iterator;
import java.io.*;

class FriendInfoController {   
	HashSet<Friend> friend;
			
	FriendInfoController(){
		friend =  new HashSet<Friend>();		
	}
	
	public void CheckStorageFile() {
		File inFile = new File("Address_Storage.bin");   
		if(inFile.exists()==false) { 
			return;
		}
		else {
			ObjectInputStream in;
			try {			 
				in = new ObjectInputStream(new FileInputStream("Address_Storage.bin"));
			
				while(true) {
					try {								
						Friend fri = (Friend) in.readObject();
						friend.add(fri);
					}catch(Exception e) {
						in.close();
						break;
					}
				}
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
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
		
		if(choice == 1) {
			System.out.print("반을 입력하세요. : ");
			Class = input.nextLine();
					
			friend.add(new MiddleFriend(name, phone, address, Class));
			
		}
			
		else if(choice ==2) {
			System.out.print("직업을 입력하세요. : ");
			work = input.nextLine();
			
			friend.add(new HighFriend(name, phone, address, work));
			
			
			
		}
		else if(choice==3) {
			System.out.print("학교명을 입력하세요. : ");
			SchName = input.nextLine();
			
			friend.add(new UnivFriend(name, phone, address, SchName));
			
			
		}
	}
	
	public void displayFriendInfo(int k) {
		if(k==4) {
			
			Iterator<Friend> itr = friend.iterator();
			while(itr.hasNext()) {
				itr.next().ShowInfo();
			}			
			
		}
		else if(k==5) {
			
			Iterator<Friend> itr = friend.iterator();
			while(itr.hasNext()) {
				itr.next().ShowBasicInfo();
			}
			
		}
	}
	
	public void FindFriend() {
		Scanner input =  new Scanner(System.in);
	
		String name=null;
		System.out.println("찾으려는 친구의 이름을 입력해주세요.");
		name =  input.nextLine();
		
		for(Friend e : friend) {
			if(e.getName().equals(name))
			{
				e.ShowInfo();
				return;
			}
		}
		System.out.println("등록되지 않은 이름입니다.");
	}
	
	public void DeleteFriend() {
		Scanner input =  new Scanner(System.in);
		
		String name=null;
		System.out.println("삭제하려는 친구의 이름을 입력하세요.");
		name =  input.nextLine();
		
		//동명이인 확인
		int cnt=0;
		boolean exist=false;
		for(Friend e : friend) {
			if(e.getName().equals(name))
			{
				cnt++;
				exist = true;
				
			}
		}
		if(exist = false) {
			System.out.println("등록되지 않은 이름입니다.");
			return;
		}
		
		if(cnt == 1) {
			Iterator<Friend> itr = friend.iterator();
			while(itr.hasNext()) {
				if(itr.next().getName().equals(name)) {
					itr.remove();
					System.out.println("삭제 되었습니다.\n");
					return;
				}
			}
		}
		else {
			
			for(Friend e : friend) {
				if(e.getName().equals(name))
				{
					e.ShowInfo();
									
				}
			}
			System.out.printf("몇 번째 친구를 지울 것인지 입력해주세요.\n지우려는 친구의 전화 번호를 입력해주세요.");
			
			String phoneNum = input.nextLine();
			
			Iterator<Friend> itr = friend.iterator();
			while(itr.hasNext()) {
				if(itr.next().getPhoneNum().equals(phoneNum)) {
					itr.remove();
					System.out.println("삭제 되었습니다.\n");
					return;
				}
			}
			
		}
		
		
		
			
	}
	public void SaveAddress() {
		try {
			ObjectOutputStream out = 
					new ObjectOutputStream(new FileOutputStream("Address_Storage.bin"));
			
			Iterator<Friend> itr = friend.iterator();
			
			while(itr.hasNext()) {
				out.writeObject(itr.next());
				
			}	
			
			out.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	
}
