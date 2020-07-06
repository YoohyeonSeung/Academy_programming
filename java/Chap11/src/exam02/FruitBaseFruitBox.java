package exam02;

public class FruitBaseFruitBox {

	public static void main(String[] args) {
		Apple apple = new Apple(500);
		FruitBox appleBox = new FruitBox();
	
		appleBox.store(apple);
		
		Apple tmpApple = (Apple) appleBox.pullOut();   //appleBox.pullOut()은 Object형이기 때문에 강제형변환 필요
		
		tmpApple.showAppleWeight();
		
		System.out.println("=======================");

		Orange orange = new Orange(50);
		FruitBox orangeBox = new FruitBox();
		
		//orangeBox.store(orange);
		orangeBox.store("오렌지");

		
		Orange tmpOrange = (Orange) orangeBox.pullOut();  //위와 같은 이유
		tmpOrange.showSugarContent();	
	}

}
