package exam07;

public class Refarray {

	public static void main(String[] args) {
		//Buyer[] buyer =  new Buyer[4];   
		//buyer[0]=    ;
		/*만약 하나당 1000byte라고 가정하면
		 * buyer는 32byte로 저장됨 Why?
		 *  
		 * 
		 * 
		 */
		/*Buyer mother = new Buyer("어머니", 100000, 0);
		Buyer father = new Buyer("아버지", 10000, 0);
		Buyer son = new Buyer("아들", 50000, 0);
		Buyer daughter = new Buyer("딸", 100000, 0);*/
		
		Buyer[] buyer =  new Buyer[4];   
		buyer[0] = new Buyer("어머니", 100000, 0);
		buyer[1] = new Buyer("아버지", 10000, 0);
		buyer[2] = new Buyer("아들", 50000, 0);
		buyer[3] = new Buyer("딸", 100000, 0);

		//Mart e_mart = new Mart("이마트", 0, 1000, 100);
		
//		buyer[1].buyerApple(2000, e_mart);
//		buyer[1].ShowBuyer();
		
		Mart[] market = new Mart[3];
		market[0] = new Mart("이마트", 0, 1000,1000);
		market[1] = new Mart("홈플러스", 0, 11000,2000);
		market[2] = new Mart("CU", 0, 1200,500);
		
		
		buyer[1].buyerApple(9000, market[2]);
		
		market[2].ShowMart();
		
		
	}

}
