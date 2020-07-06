package exam04;

public class ObjectClone {

	public static void main(String[] args) {
		Point org = new Point(3,4);
		Point cpy = null;

		System.out.println(org);
		try {
			cpy = ( Point ) org.clone();    //->org.clone()는 object형이므로 강제 형 변환이 필요함
			
			org.showPosition();
			cpy.showPosition();
			
		}catch(CloneNotSupportedException e){
			e.printStackTrace();
		}
	}

}
