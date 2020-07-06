package exam04.calc;


class Adder{ // 덧셈,  같은 폴더안의 calculator에서 사용하므로 public class라 할 필요가 없음
	private int cndAdd;   // 호출 횟수,    private를 이용하여 cntadd변수가 Adder자료형 에서 만 볼 쓸수 있게 은닉
	
	Adder(){ cndAdd=0;	}
	
	public int addTwoNumber(int num1, int num2) {
		int result;
		
		cndAdd++;
		
		result = num1+num2;
		return result;
	}
	
	public int getCntAdd() {      
		return cndAdd;
	}
	
//	public void ShowOperationTimes() {
//		System.out.println("덧셈의 횟수 : " + cndAdd);
//	}
	
}