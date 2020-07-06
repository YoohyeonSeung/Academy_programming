package exam07;

class Mart{ // 자료형 선언
    // 속성(field)
	String name;  //판매처
	int benefit; // 이윤 관리
	int numOfApple; //사과 재고
	final int APPLE_PRICE; //사과 가격, 가격을 한번 입력한 이후에 값을 수정불가능하게 만들어놓는 키워드=final int, 상수형 변수는 대문자로 표기하는게 약속
	/*
	 * private 은 메소드 내에서만 접근 가능
	 * 
	 */
	
	
	//반환형이 없어서 생성자라 부른다.(1.반드시 클래스 이름과 똑같아야 한다. 2. 자바에 의해서 new에 의해 메모리 할당된 이후에 반드시 한번만 호출됨)
	Mart(String appleName, int bnf, int ea, int price){  //System.out.println("Mart() 호출...")
		name = appleName;
		benefit = bnf;
		numOfApple = ea;
		APPLE_PRICE=price;
	}
	
		//행위/기능(메서드)
	public int sellApple(int money) {   //사과를 파는 행위
		int num=0;
		
		num=money/APPLE_PRICE;		
		numOfApple-=num;
		
		benefit +=money;
		
		return num;
	}
	//결산
	public void ShowMart() {
		System.out.println(name + " 마트 이윤 : "+ benefit);
		System.out.println("남은 사과 갯수(재고) : "+ numOfApple);
		
	}

}