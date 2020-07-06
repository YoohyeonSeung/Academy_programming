package exam02;

class Apple {

	private int weight; //사과의 무게
		
	Apple(int weight){
		this.weight = weight;
	}	
	public void showAppleWeight() {
		System.out.println("사과의 무게 : " + weight);		
	}	
}

/*class AppleBox{
	Apple item;
	
	AppleBox(){}
	
	public void store(Apple item) {
		this.item = item;
	}
	
	public Apple pullOut() {
		return this.item;	
	}
	
	
	
	
	
	
	
	
}*/