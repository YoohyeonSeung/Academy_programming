package exam02.calc;
/*문제) 전자 계산기 기능(+, -, *, /, %)을 구현하되,
정수, 실수 연산이 모두 가능한 기능을 메서드 오버로딩을 
이용하여 구현하고, 다음 연산 결과를 출력하세요.

1) 345 + 417.14 
2) 25859.7142 - 345
3) 487 * 25
4) 345.25 / 12
5) 412 % 4*/

public class Calculator {
	Adder plus;
	Subtractor minus;
	Multiplier multi;
	Divider div;
	Reminder rema;
	
	public Calculator() {
		plus = new Adder();
		minus = new Subtractor();
		multi = new Multiplier();
		div = new Divider();
	    rema = new Reminder();
		
	}
	//덧셈
	public int calAdd(int n1, int n2) {
		int result = plus.addTwoNum(n1, n2);
		System.out.println(n1+"+"+n2+"="+result);
		return result;		
	}public double calAdd(double n1, int n2) {
		double result = plus.addTwoNum(n1, n2);
		System.out.println(n1+"+"+n2+"="+result);
		return result;		
	}public double calAdd(int n1, double n2) {
		double result = plus.addTwoNum(n1, n2);
		System.out.println(n1+"+"+n2+"="+result);
		return result;		
	}public double calAdd(double n1, double n2) {
		double result = plus.addTwoNum(n1, n2);
		System.out.println(n1+"+"+n2+"="+result);
		return result;		
	}
	//뺄셈
	public int calSub(int n1, int n2) {
		int result = minus.subTwoNum(n1, n2);
		System.out.println(n1+"-"+n2+"="+result);
		return result;		
	}public double calSub(double n1, int n2) {
		double result = minus.subTwoNum(n1, n2);
		System.out.println(n1+"-"+n2+"="+result);
		return result;		
	}public double calSub(int n1, double n2) {
		double result = minus.subTwoNum(n1, n2);
		System.out.println(n1+"-"+n2+"="+result);
		return result;		
	}public double calSub(double n1, double n2) {
		double result = minus.subTwoNum(n1, n2);
		System.out.println(n1+"-"+n2+"="+result);
		return result;		
	}
	
	//곱하기
		public int calMul(int n1, int n2) {
			int result = multi.mulTwoNum(n1, n2);
			System.out.println(n1+"*"+n2+"="+result);
			return result;		
		}public double calMul(double n1, int n2) {
			double result = multi.mulTwoNum(n1, n2);
			System.out.println(n1+"*"+n2+"="+result);
			return result;		
		}public double calMul(int n1, double n2) {
			double result = multi.mulTwoNum(n1, n2);
			System.out.println(n1+"*"+n2+"="+result);
			return result;		
		}public double calMul(double n1, double n2) {
			double result = multi.mulTwoNum(n1, n2);
			System.out.println(n1+"*"+n2+"="+result);
			return result;		
		}
		
		//나누기
		public int calDivi(int n1, int n2) {
			int result = div.divTwoNum(n1, n2);
			System.out.println(n1+"/"+n2+"="+result);
			return result;		
		}public double calDivi(double n1, int n2) {
			double result = div.divTwoNum(n1, n2);
			System.out.println(n1+"/"+n2+"="+result);
			return result;		
		}public double calDivi(int n1, double n2) {
			double result = div.divTwoNum(n1, n2);
			System.out.println(n1+"/"+n2+"="+result);
			return result;		
		}public double calDivi(double n1, double n2) {
			double result = div.divTwoNum(n1, n2);
			System.out.println(n1+"/"+n2+"="+result);
			return result;		
		}
		
		//나머지
		public int calRema(int n1, int n2) {
			int result = rema.remTwoNum(n1, n2);
			System.out.println(n1+"%"+n2+"="+result);
			return result;		
		}public double calRema(double n1, int n2) {
			double result = rema.remTwoNum(n1, n2);
			System.out.println(n1+"%"+n2+"="+result);
			return result;		
		}public double calRema(int n1, double n2) {
			double result = rema.remTwoNum(n1, n2);
			System.out.println(n1+"%"+n2+"="+result);
			return result;		
		}public double calRema(double n1, double n2) {
			double result = rema.remTwoNum(n1, n2);
			System.out.println(n1+"%"+n2+"="+result);
			return result;		
		}
		


}
