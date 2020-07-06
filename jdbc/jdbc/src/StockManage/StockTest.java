package StockManage;

import java.util.List;
import java.util.Scanner;


public class StockTest {
	
	
	public static void update(StockDAO dao) {
		Scanner input = new Scanner(System.in);
		StockDTO dto = new StockDTO();
				
		System.out.println("추가할 재고를 입력해주세요(원두는 g단위, 시럽, 우유는 ml단위)");
		System.out.print("원두 : ");
		int Bean = input.nextInt();
		System.out.print("우유 : ");
		int Milk = input.nextInt();
		System.out.print("초코 시럽 : ");
		int Choco = input.nextInt();
		System.out.print("바닐라 시럽 : ");
		int Vanilla = input.nextInt();
		
		dto.setBeanQ(Bean);
		dto.setMilkQ(Milk);
		dto.setChocoQ(Choco);
		dto.setVanillaQ(Vanilla);
		
		dao.update(dto);
			
	}		
	public static void select(StockDAO dao) {
		StockDTO dto =null;
		dto=dao.select();
		
		System.out.println("원두 \t 우유 \t 초코 시럽 \t 바닐라 시럽");
		
		int bean = dto.getBeanQ();
		int milk = dto.getMilkQ();
		int choco = dto.getChocoQ();
		int vanilla = dto.getVanillaQ();
		
		System.out.printf("%d \t %d \t %d \t%d \t",bean, milk, choco, vanilla);
	
	}
	

	public static void main(String[] args) {
		
		StockDAO dao = new StockDAO();
		Scanner input = new Scanner(System.in);
			
		
		while(true) {
			System.out.println("\n\n****** 메뉴 구성 ******");
			System.out.println("1. 프로그램 종료. ");
			System.out.println("2. 추가 재고 입력");
			System.out.println("3. 재고 확인");
			System.out.println(">>메뉴 선택 : ");
			
			int choice = input.nextInt();
			
			switch(choice) {
			
				case 1:
					System.out.println("이제 프로그램을 종료합니다.");
					return;
				case 2:
					update(dao);
					break;
				case 3:
					select(dao);
					break;
				default:
					break;			
			}
			
			
			
		}
		
		
		
		

	}

}
