package exam03;
class IntNumber{
	private int num;
	private String name;
	
	IntNumber(int num, String name){
		this.num=num;
		this.name = name;
	}

	@Override
	public boolean equals(Object obj) {              //->Object로 적용할 수 있는 범위가 축소됨
		IntNumber intNum = (IntNumber) obj;      //축소된 것을 강제로 형 변환해줌
		
		if (num==intNum.num && name==intNum.name) {
			return true;
		}
		else {
			return false;
		}
	}
	
}
public class ObjectEquals {

	public static void main(String[] agrs) {
		IntNumber num1 = new IntNumber(5, "홍길동");
		IntNumber num2 = new IntNumber(10,"강감찬");
		IntNumber num3 = new IntNumber(15, "강감찬");
		IntNumber num4 = new IntNumber(5, "홍길동");
		
		if (num2.equals(num3)) {
			System.out.println("같은 데이터");
		}else{
			System.out.println("다른 데이터");
		}		
	}
	
	
}
