package exam11;

public class InterfaceMark {

	public static void main(String[] args) {
		
		PointOne pos1 = new PointOne(3,4);
		PointOne pos2 = new PointOne(10,35);
		
		
		ClassPrinter.print(pos1);
		ClassPrinter.print(pos2);
		//메소드를 static으로 했기 때문에 참조변수 선언없이 쓸 수 있음
	}

}
