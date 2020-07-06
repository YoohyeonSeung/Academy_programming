package exam01;

public class FruitBaseFruitBox {

	public static void main(String[] args) {
		Apple apple = new Apple(500);
		AppleBox appleBox = new AppleBox();
	
		appleBox.store(apple);
		appleBox.pullOut();
		
		Apple tmpApple = appleBox.pullOut();
		
		tmpApple.showAppleWeight();

		Orange orange = new Orange(50);
		OrangeBox orangeBox = new OrangeBox();
		
		orangeBox.store(orange);
		orangeBox.pullOut();
		
		Orange tmpOrange = orangeBox.pullOut();
		
		tmpOrange.showSugarContent();
		
		
		
	}

}
