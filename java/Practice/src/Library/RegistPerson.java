package Library;

import java.util.Scanner;
class RegistPerson {
	Person[] member;
	private int RegistNum=0;
	
	RegistPerson(){
		member = new Person[200];		
	}
	
	public void RegistMem(int k) {
		Scanner input =  new Scanner(System.in);
		System.out.printf("이름 : ");
		String name = input.nextLine();
		System.out.printf("나이 : ");
		String age = input.nextLine();
		System.out.printf("연락처 : ");
		String phoneNumber = input.nextLine();
		System.out.printf("주소 : ");
		String Address = input.nextLine();
		System.out.printf("좌석 : ");
		String Seat = input.nextLine();
		
		if(k==0) {     //학생
			System.out.printf("학교명 : ");
			String School = input.nextLine();
			System.out.printf("전공 : ");
			String Major = input.nextLine();
			
			member[RegistNum++] = new Student(name, age, phoneNumber, Address, School, Major, Seat);
		}
		else if(k==1) {
			System.out.printf("직업 : ");
			String Job = input.nextLine();
			member[RegistNum++] = new Adult(name, age, phoneNumber, Address, Job,  Seat);
		}
	}
	
	public void ShowInfo(int k) {
		if(k==2) {
			for(int i = 0; i<RegistNum;i++) {
				member[i].ShowInfo();
			}
		}
		else {
			for(int i = 0; i<RegistNum;i++) {
				member[i].ShowBasicInfo();
			}
		}
	}

	
	
	
	
	
	
	
	

}
