package HW;

public class Yoohs
{

	public static void main(String[] args)
	{  //문제1
		System.out.println("Problem1. switch문으로 변경");
		int n=24;
		int k;
		k=n/10;
		switch(k)
		{
			case 0 : 
				System.out.println("0이상 10미만의 수");
				break;
			case 1 : 
				System.out.println("10이상 20미만의 수");
				break;
			case 2 : 
				System.out.println("20이상 30미만의 수");
				break;
			default:
				System.out.println("음수 혹은 30이상의 수");
				break;
		}
		
		//// 문제2
		System.out.println();
		System.out.println("Problem2. for문을 이용한 결과 및 숫자들의 합");
		int Sum1=0;
		for(int num1=1; num1<=100; num1++) 
		{
			if((num1%2==0) && (num1%5==0)) 
			{
				Sum1+=num1;
				System.out.print(num1+"  ");
				
			}
		}
		System.out.println();
		System.out.println("합 : "+ Sum1);
			
		int Sum2=0;
		System.out.println();
		
		//문제3
		System.out.println("Problem3. do~while을 이용한 결과 및 숫자들의 합");
		int num2=1;
		do
		{
			if((num2%2==0) && (num2%5==0))
			{
				Sum2+=num2;
				System.out.print(num2+"  ");
			}
			num2++;
				
		}while(num2<=100);
		System.out.println();
		System.out.println("합 : "+ Sum2);
		
		
		//문제4
		System.out.println();
		System.out.println("Problem4. 구구단 출력"); //라인맞추는 방법은 지금까지 배운 내용으론 찾을 수 없어 이대로 제출합니다...
		for(int i=0; i<10; i++) { // 만약 i==0, 2,3,4...9단. i>=1이면 실제 구구단이 나온다. 
			for(int j=2;j<10;j++)
			{
				if(i==0) 
				{
					if(j<9)
					{
						System.out.print("     "+j+" 단"+"         ");
					}
					else {
						System.out.println("     "+j+" 단");
					}
				}				
				else 
				{
					if(j<9)
					{
						if(i*j<10) {					
							System.out.print(" "+j+" x "+i +" = "+ i*j+"   ");
						}
						else {
							System.out.print(" "+j+" x "+i +" = "+ i*j+"  ");
						}                                             
					}
					else {
						System.out.println(j+"*"+i +"="+ i*j);
					}
				}
			}			
		}

	}

}
