package exam01;
/*
 * 하나의 소스파일 안에는 갯수 제한 없이 여러개의 class를 선언할수 있으나, public이 붙은 class는 없거나 많아봐야 최대1개밖에 선언 할 수 없다.
 * 그러므로 지금 보고 있는 소스 파일에는 main앞만 붙일 수 있다.
 */
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

class Buyer{
	// 속성(field)
	String name;  // 구매자
	int myMoney;  // 생활비
	int numOfApple; // 구입한 사과 갯수 //->위에서 마트에 대한 곳에서도 같은 이름으로 했지만 클래스가 다르면 같은 이름으로 해도됨
		
	// 생성자(필드 초기화, 반환형 없으므로 public 할필요 없음, 클래스 이름과 같이!)
	Buyer(String nameBuyer, int money, int apple ){
		name = nameBuyer;   
		myMoney = money;
		numOfApple = apple;
		
	}
	
	//매서드
	//사과를 구입.
	public void buyerApple(int money, Mart market) {
		numOfApple += market.sellApple(money); //e_mart.이라고 하면 오류가 뜨므로 위에 처럼 Mart형 자료를 가져 오겠다고 해야함
		market.benefit+=money;
		myMoney-=money;
		System.out.println(market.name +"의 이윤 : "+market.benefit);
		System.out.println(market.name+"의 재고 : "+market.numOfApple);
		
		
	}
	
	// 가계부
	public void ShowBuyer() {
		System.out.println(name+"이/가 구입한 사과의 갯수 : "+numOfApple);
		System.out.println(name + "잔고 : "+myMoney);
	}
}



public class OOP {
	public static void main(String[] args) {
		Mart e_mart; //참조변수 선언
		//new로 인해 메모리 할당받은 곳의 주소를 위에서 저장하고 있음
		e_mart = new Mart("이마트", 0, 1000, 1000);  // Instance 화 (메모리 할당)
		//Mart e_mart = new Mart("이마트", 0, 1000, 1000) 가능
		
		
		Mart homeplus= new Mart("홈플러스", 0, 100, 2000);		
		Mart CU= new Mart("CU", 0, 1200, 500);
		
			
		
		e_mart.sellApple(5000);
		e_mart.ShowMart();
		
		
		Buyer mother = new Buyer("어머니", 1000000, 0);
		
		mother.buyerApple(3000, e_mart);
		mother.ShowBuyer();

		mother.buyerApple(2000, e_mart);
		mother.ShowBuyer();
		
		mother.buyerApple(2000, homeplus);
		mother.ShowBuyer();
		
		Buyer father = new Buyer("아버지", 1000000, 0);
		father.buyerApple(4000, CU);
		father.ShowBuyer();

		//System.out.println(e_mart.benefit);
	}

}