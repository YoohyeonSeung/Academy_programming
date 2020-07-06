package exam17;

public class PrintMethod {

	public static void main(String[] args) {
		int age = 20;
		double tall=178.5;
		String name = "홍길동";
		
		System.out.printf("내 이름은 %s 입니다.\n", name);  //printf는 3버전부터 시작 적용되었다.
		System.out.printf("나이는 %d살이고, 키는 %f 입니다.\n", age, tall);
		System.out.printf("나이는 %d살이고, 키는 %.1f 입니다.\n", age, tall); //소수점 이하 1자리까지 보여달라 할때 씀.(실수형의 경우)

		System.out.printf("%d, 0x%x, 0%o \n", 77, 77, 77);
		System.out.printf("%g, %g \n", 0.00014, 0.000014);
		
	}
	
	

}
