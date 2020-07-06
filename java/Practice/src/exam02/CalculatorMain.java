package exam02;
/*문제) 전자 계산기 기능(+, -, *, /, %)을 구현하되,
정수, 실수 연산이 모두 가능한 기능을 메서드 오버로딩을 
이용하여 구현하고, 다음 연산 결과를 출력하세요.

1) 345 + 417.14 
2) 25859.7142 - 345
3) 487 * 25
4) 345.25 / 12
5) 412 % 4
*/

import exam02.calc.Calculator;

public class CalculatorMain {
	
	public static void main(String[] args) {
		
		Calculator calcu = new Calculator();
		
		calcu.calAdd(345, 417.14);
		calcu.calSub(25859.7142, 345);
		calcu.calMul(487 , 25);
		calcu.calDivi(345.25,  12);
		calcu.calRema(412, 4);
		
		
	}

}
