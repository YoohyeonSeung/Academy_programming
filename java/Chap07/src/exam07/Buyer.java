package exam07;

class Buyer{
	// 속성(field)
	private String name;  // 구매자
	private int myMoney;  // 생활비
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