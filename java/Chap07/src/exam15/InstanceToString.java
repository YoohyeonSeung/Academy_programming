package exam15;

class Friend{
	private String name;
	
	Friend(String name){
		this.name = name;
				
	}
	
	public String toString() {
		return "제 이름은 "+ name + "입니다.";
	}
	

}

public class InstanceToString {

	public static void main(String[] args) {

		Friend friend1 = new Friend("기절거");
		Friend friend2 = new Friend("직수빈");
		Friend friend3 = new Friend("그뤁");
		Friend friend4 = new Friend("개샛기");
		Friend friend5 = new Friend("식초빌런");
		Friend friend6 = new Friend("짐쿠");
		
		System.out.println(friend1.toString());
		System.out.println(friend2.toString());
		System.out.println(friend3.toString());
		System.out.println(friend4.toString());
		System.out.println(friend5.toString());
		System.out.println(friend6.toString());
		
		

	}

}
