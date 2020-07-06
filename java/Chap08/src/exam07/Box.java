package exam07;

class Box {
	public void simpleWrap() {
		System.out.println("simpleWrap()호출");
	}
}


class PaperBox extends Box{
	
	public void paperWrap() {
		System.out.println("paperWrap() 호출");
	}  //-> 상속의 관계이므로 PaperBox는 두개의 메소드로 구성되어있음.
}

class GoldPaperBox extends PaperBox{
	
	public void goldWrap() {
		System.out.println("GoldPaperBox() 호출");
	}
	
	
	
	
}
