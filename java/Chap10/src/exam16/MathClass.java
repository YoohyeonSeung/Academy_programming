package exam16;

public class MathClass {

	public static void main(String[] args) {
		System.out.println("원주율 : "+ Math.PI);
		System.out.println("2의 제곱근 : "+ Math.sqrt(2));
		
		System.out.println("파이에 대한 Degree : " + Math.toDegrees(Math.PI));
		System.out.println("파이에 대한 Degree : " + Math.toDegrees(2*Math.PI));
		
		double radian45 = Math.toRadians(45);
		
		System.out.println("sin 45 = "+ Math.sin(radian45));
		System.out.println("sin 45 = "+ Math.cos(radian45));
		System.out.println("sin 45 = "+ Math.tan(radian45));
		
		System.out.println("로그25 : "+ Math.log(25));
		System.out.println("2의 4제곱 : " + Math.pow(2, 4));
		
		
		
	}

}
