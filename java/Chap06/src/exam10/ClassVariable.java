package exam10;

class InstCnt{
	static int instNum=0;
	
	InstCnt(){
		instNum++;
		System.out.println("인스턴트 생성 : "+instNum);
		
	}
	
}

public class ClassVariable {

	public static void main(String[] args) {
		InstCnt.instNum=5;
				
		InstCnt instCnt1;
		instCnt1 = new InstCnt();
		InstCnt instCnt2 = new InstCnt();
		InstCnt instCnt3 = new InstCnt();
		InstCnt instCnt4 = new InstCnt();
		/*
		 * static이 붙었을땐
		 * 인스턴트 생성 : 1
		 *	인스턴트 생성 : 2
		 * 인스턴트 생성 : 3
		 *	인스턴트 생성 : 4
		 *아니면 다 1값이 나옴
		 */
		
		/*static이 붙게되면 없을때와는 달리 메모리에 따로 미리 할당을 해준다. 
		 * 또한 생성자를 각각 만났을때, instNum은 각각의 생성자에 할당되지 않는다.
		 * 반면에, static이 없으면 instNum에 대한 메모리가 독립적으로 할당되지않고
		 * 생성자를 만났을 때 instcnt1, instCnt2에 각각(종속적으로) 할당된다.
		 */
		System.out.println(instCnt1.instNum);
		//그러다보니 instCnt1으로 접근하던 instCnt2로 접근하던 instNum값은 4로 출력된다.
		
		System.out.println(InstCnt.instNum);
	}

}
