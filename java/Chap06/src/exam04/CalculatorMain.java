package exam04;

import exam04.calc.Calculator;

public class CalculatorMain {
	
	
	public static void main(String[] args) {
		//exam04.calc.Calculator calculator = new exam04.calc.Calculator();  이렇게 안쓰려면 위에 import를 해줘야됨
		
		Calculator calculator = new Calculator();
		System.out.println(calculator.calAddTwoNum(1,2));
		System.out.println(calculator.calAddTwoNum(10000,2));
		System.out.println(calculator.calAddTwoNum(12161,2233));
		System.out.println(calculator.calAddTwoNum(17777,1212122));
		
		System.out.println(calculator.calSubTwoNum(19,2));
		System.out.println(calculator.calSubTwoNum(11111,22));
		System.out.println(calculator.calSubTwoNum(174734,212));
		System.out.println(calculator.calSubTwoNum(234231,23423));
		

	}

}
