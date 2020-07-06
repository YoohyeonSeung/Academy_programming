package exam01;

class Orange {
	private int sugarContent;  //당도
	
	Orange(int sugarContent){
		this.sugarContent = sugarContent;
	}
	
	public void showSugarContent() {
		System.out.println("당도 함량 : " + sugarContent);
	}
}

class OrangeBox{
	Orange item;
	
	OrangeBox(){}
	
	public void store(Orange item) {
		this.item = item;
	}
	
	public Orange pullOut() {
		return item;
	}
	
	
	
	
	
	
}
