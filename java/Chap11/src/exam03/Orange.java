package exam03;

class Orange {
	private int sugarContent;  //당도
	
	Orange(int sugarContent){
		this.sugarContent = sugarContent;
	}
	
	public void showSugarContent() {
		System.out.println("당도 함량 : " + sugarContent);
	}
}