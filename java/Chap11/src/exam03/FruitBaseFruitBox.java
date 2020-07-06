package exam03;

public class FruitBaseFruitBox {

	public static void main(String[] args) {
		Apple apple = new Apple(500);
		FruitBox<Apple> appleBox = new FruitBox<Apple>();
	
		appleBox.store(apple);
		
		Apple tmpApple = (Apple) appleBox.pullOut();   //appleBox.pullOut()은 Object형이기 때문에 강제형변환 필요
		
		tmpApple.showAppleWeight();
		
		System.out.println("=======================");

		Orange orange = new Orange(50);
		FruitBox<Orange> orangeBox = new FruitBox<Orange>();
		
		orangeBox.store(orange);
		//orangeBox.store("오렌지");  -> 제너릭 선언에 의하여 이코드는 오류가 뜸 만약 제너릭을 안하면 오류가 뜨지 않음 범용성에 의하여

		
		Orange tmpOrange = (Orange) orangeBox.pullOut();  //위와 같은 이유
		tmpOrange.showSugarContent();	
	}

}
