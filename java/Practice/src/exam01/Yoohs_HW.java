package exam01;

class Mart{
	String Mart_name;
	int benefit;
	int numOfApple;
	int APPLE_PRICE;
	
	Mart(String name, int bnt, int ea, int price) {  //마트명, 영업시작금액, 재고,가격 초기화
		Mart_name = name;
		benefit=bnt;
		numOfApple=ea;
		APPLE_PRICE=price;
	}
	
	public void SellApple(int price) {  // 영업이익과 재고 체크
		numOfApple-= (price/APPLE_PRICE);
		benefit+=price;
	}
	public void ShowMart() { //영업 이익, 현재 재고 출력
		System.out.println(Mart_name +"의 영업 이익 : "+ benefit);
		System.out.println(Mart_name +"의 사과 재고 : "+ numOfApple);
		System.out.println();
	}
	
}

class Buyer{
	String buyerName;
	int myMoney;
	int eaOfApple;
	
	Buyer(String name, int money){ //이름 및 소지금 입력
		buyerName = name;
		myMoney = money;
		
	}	
	public void BuyingApple(int money, Mart market) { // 구매한 마트의 재고, 이익 체크 그리고 구매자의 소지금 체크
		myMoney-=money;
		eaOfApple+=(money/market.APPLE_PRICE);
		market.numOfApple-=(eaOfApple);
		market.benefit+=money;
		System.out.println(buyerName+"가 "+market.Mart_name+"에서 "+"사과를 "+eaOfApple+"개 구입하였습니다.");
				
	}
	public void ShowAccounts() { //구매자의 소지금 확인
		System.out.println(buyerName+"의 소지금 : "+myMoney);
		System.out.println();
	}
}

public class Yoohs_HW{
	public static void main(String[] args) {
		Mart e_mart = new Mart("이마트", 0, 100, 1000);
		Mart homeplus = new Mart("홈플러스", 0, 50, 2000);
		
		Buyer chul_soo = new Buyer("철수", 100000 );
		Buyer young_hee = new Buyer("영희", 100000 );
		Buyer Mi_ae = new Buyer("미애", 100000 );

		chul_soo.BuyingApple(5000, e_mart);
		chul_soo.BuyingApple(2000, homeplus);
		chul_soo.ShowAccounts();
		
		young_hee.BuyingApple(8000, e_mart);
		young_hee.BuyingApple(12000, homeplus);
		young_hee.ShowAccounts();
		
		Mi_ae.BuyingApple(20000, e_mart);
		Mi_ae.BuyingApple(10000, homeplus);
		Mi_ae.ShowAccounts();
		
		e_mart.ShowMart();
		homeplus.ShowMart();
		
	}
}


	
	
	
	
