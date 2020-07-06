package exam05;

public class DeepCopy {

	public static void main(String[] args) {
		Rectangle org = new Rectangle(1,6,5,3);
		Rectangle cpy = null;
		
		try {
			cpy = (Rectangle) org.clone();
			System.out.println("=====원본=====");
			cpy.showPosition();
			org.showPosition();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		System.out.println("=====원본 위치변경 후 =====");
		org.changePos(2, 7, 4, 4);

		org.showPosition();
		
		cpy.showPosition();
		
	}
	
	
	
	

}
