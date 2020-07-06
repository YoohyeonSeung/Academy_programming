package exam04.calc;

class Subtractor{ // 뺄셈,  같은 폴더안의 calculator에서 사용하므로 public class라 할 필요가 없음
	private int cndSub;
		
	Subtractor(){ cndSub = 0; 	}
	
	public int subTwoNumber(int num1, int num2) {
		int result;
		
		cndSub++;
		
		result = num1-num2;
		return result;		
	}
	
	public int getCntSub() {
		return cndSub;
	}
}