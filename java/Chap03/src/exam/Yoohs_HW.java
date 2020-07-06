package exam;

public class Yoohs_HW
{
	public static void main(String[] args)
	{
		//1. Short Circuit Evaluation으로 인해 발생되는 문제점을 수정하시오.
		int num1 = 0, num2 = 0;
		boolean result =false;
		
		num1 += 10;
		num2 += 10;
		result = (num1 < 0 ) && (num2  > 0) ;
		System.out.println("결과 : "+result );
		System.out.println("num1 :" +num1);
		System.out.println("num1 :" +num2);
		
		num1 += 10;
		num2 += 10;
		result = (num1  > 0) || (num2 <0);
		System.out.println("결과 : "+result );
		System.out.println("num1 :" +num1);
		System.out.println("num1 :" +num2);
		
		
		//2. 출력될 num3, num4의 값을 예상해보고, 실행하여 결과를 확인해 보세요.
		int num3=7, num4;
		num4=(num3--)+ 5;
		
		System.out.println("num3:"+ num3);
		System.out.println("num4:"+ num4);
		/*
		 * 예상되는 num3의 값은 6, num4의 값은 12입니다. 
		 * 그 이유는 num3에서 -1만큼 연산해주는 것이 먼저 저장된 num3=7을 이용하여
		 * num4가 12가 되게 연산을 해준 이후에 하기 때문에 num4가 11이 될 수가 없습니다.
		 */
		
		//3. System.out.println(-8>>>1); 연산 결과를 메모리를 이용하여 설명해보세요.
		System.out.println(-8>>>1);
		/*
		 * -8이 실제 메모리에 2진수로 저장된 값을 먼저 구해야 하는데 그 방법은
		 * 교재의 54쪽에 있고 그 방법을 이용하여 2진수로 변환하면
		 * 음수값이기 때문에 왼쪽 끝 값은 1이고 나머지 오른쪽의 값은
		 * 오른쪽 끝에 1000을 제외 하고 모두다 1로 체워져있게 됩니다. 
		 * 이제 비트 연산자에 의해 오른쪽으로 1번 밀리게되고 
		 * 결과 왼쪽끝은 0으로 체워지고 오른쪽끝은 100이 됩니다. 
		 * 즉 011111...11100이 되고 이를 10진수로 표현하면 2147483644가 됩니다. 
		 */
		
		
		
		
		
		
		
		
	}

}
