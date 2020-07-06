package exam07;

public class InsteadOf {
	
	public static void wrapBox(Box box) {
										// Box box ( = box1; ) =new Box()과 같은 코드 
										// Box box ( = box2; ) = new PaperBox();
										// Box box ( = box3; ) = new GoldPaperBox();
		//box instanceof GoldPaperBox -> // box는 GoldPaperBox라는거 앎?
		if(box instanceof GoldPaperBox) {
			((GoldPaperBox) box).goldWrap(); //->강제 형 변환 
			
			/*GoldPaperBox wrap = (GoldPaperBox) box; ->얘도 가능
			wrap.goldWrap();
			wrap.paperWrap();
			wrap.simpleWrap();*/	
		}
		
		else if(box instanceof PaperBox) {
			((PaperBox) box).paperWrap();
			
			/*PaperBox wrap = (PaperBox) box; -> 얘도 가능
			wrap.paperWrap();    
			wrap.simpleWrap();*/
		}
		else {
			box.simpleWrap();
		}
	}
	/*public static void wrapBox(PaperBox box) {
		
	}
	
	public static void wrapBox(GoldPaperBox box) {
		
	}*/
	// 매개변수만 다르게 해서 메소드 오버로딩!	
	// Box형으로 받으면 PaperBox도 바라볼 수 있고 또한 GoldPaperBox로 바라 볼수 있기때문에 굳이 오버로딩 해줄 필요 없다.
	
	public static void main(String[] args) {
		
		Box box1= new Box();
		PaperBox box2 = new PaperBox();
		GoldPaperBox box3 = new GoldPaperBox();
		
		wrapBox(box1);
		wrapBox(box2);
		wrapBox(box3);
	}
	

}
