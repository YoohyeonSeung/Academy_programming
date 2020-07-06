package OOP;

class Mart{
	//이익, 재고, 물건 가격
	int benefit;
	int ea;
	int price;
	
	Mart(int bnt, int num, int money){
		benefit=bnt;
		ea=num;
		price=money;
		
	}
	
	public void Selling(int NumOfProduct) {
		benefit = price*NumOfProduct;
		ea-=NumOfProduct;
				
	}
	
	public void ShowMart() {
		System.out.println("남은 재고(물량) : "+ ea);
		System.out.println("현재 이익 :"+ benefit);
			
	}
	
	
}

public class OOP {
	public static void main(String[] args) {
		Mart Apple;
		Apple = new Mart(0, 100, 1000);
		
		Apple.Selling(5);
		Apple.ShowMart();
		
		
		
	}

	

}
