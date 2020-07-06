package exam06;

class Fruit{
	public void showYou() {
		System.out.println("난 과일입니다.");
	}
}
class Apple extends Fruit{

	@Override
	public void showYou() {
		//super.showYou();
		System.out.println("난 붉은 과일입니다.");
	}
}

class FruitBox<T>{            //T에 참조자료형이 다 올수 있음
	T item;
	
	public void store(T item) {
		this.item=item;
	}
	
	public T pullOut() {
		return item;
	}
}
public class IntroWildCard {
	public static void main(String[] args) {
		Fruit fruit = new Fruit();
		Apple apple =  new Apple();
		
		 FruitBox<Fruit> fruitBox = new FruitBox<Fruit>();
		 fruitBox.store(fruit);            //-><Fruit>로 했으므로 fruit만 가능!
	
		 openAndShowFruitBox(fruitBox);
		 
		 FruitBox<Apple> appleBox = new FruitBox<Apple>();
		 appleBox.store(apple);
		 openAndShowFruitBox(appleBox);
		  		 
	}
	public static void openAndShowFruitBox(FruitBox<? extends Fruit> box) {  //밑의 코드를 다 포함해주는 코드!
		 Fruit fruit = box.pullOut();	
		 fruit.showYou();
	 }
/*	public static void openAndShowFruitBox(FruitBox<Fruit> box) {    //만약 매개변수로 자료형이FruitBox<Apple>이라 하면 오류!
																								//함수의 매개변수로써 상속을 받는다고 하여도 generic을 사용할 수 없다. 		
		Fruit fruit = box.pullOut();
		fruit.showYou();
	}*/
	/*public static void openAndShowAppleBox(FruitBox<Apple> box) {   //메서드의 매개변수로 generic을 이용하려면 상속을 그대로 가져갈 수 없기에 따로 메소드를 정의 해줘야한다.
		Apple apple = box.pullOut();
		apple.showYou();
	}*/  //즉, 자료형은 서로 같은 FruitBox자료형으로 보고 있는 것이다. 	
	
	//오버로딩이 성립될 조건 : 1. 매개변수의 갯수가 다르거나 매개변수의 타입이 다르다.
	//                             2. 
}
