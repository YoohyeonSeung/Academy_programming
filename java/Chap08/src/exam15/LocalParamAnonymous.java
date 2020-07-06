package exam15;

public class LocalParamAnonymous {

	public static void main(String[] args) {
		OuterClass outer = new OuterClass("First");
		
		Readable localClass = outer.createLocalClassInst(5);
		localClass.read();
				
	}

}
