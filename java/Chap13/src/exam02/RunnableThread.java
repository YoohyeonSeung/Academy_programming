package exam02;    //Thread를 사용하는 또다른 방법

class Sum{
	int num;
	Sum(){num=0;}
	
	public void addNum(int num) {this.num +=num;}
	public int getNum() {return num; }
}

class AddThread extends Sum implements Runnable{  //extends Sum, Thread -> 다중상속이 지원되지 않아 사용할 수 없음.
	int start, end; 
	
	AddThread(int s, int e){this.start = s; this.end = e;}

	@Override
	public void run() {                 //Thread기능을 아직 보여준게 아님 main에서 new Thread();가 있을 때, 비로소 Thread를 하게된다.
		for(int i= start ; i<=end; i++ ) {
			addNum(i);
			
		}
		System.out.printf("%d 에서 %d 까지의 합 : %d\n", start, end, getNum());
	}
	
}

public class RunnableThread { 

	public static void main(String[] args) {
		
		AddThread at1 = new AddThread(0, 10);
		AddThread at2 = new AddThread(11, 20);
		
		Thread thread1 = new Thread(at1); //->위의 class에서 thread를 상속받은 적이 없기 때문에 이 코드가 필요함. 우회적으로 thread를 사용 할 수 있게 하는 방법.
		Thread thread2 = new Thread(at2);
		
		thread1.start();
		thread2.start();
		
		try {
			thread1.join();     //thread1의 수행이 끝날때까지 기다려라(thread1의 run이 끝날때 까지)
			thread2.join();
		} catch (InterruptedException e) {           //join()의 설명을 api에서 찾아보면 예외처리가 있기 때문에 try catch문을 필요로 한다. 
		
			e.printStackTrace();
		}    
		
		
		System.out.println("0부터 20까지의 합 : "+ (at1.getNum() + at2.getNum()) );  
		// 여기서에서의 값이 0이 뜨면 main, thread1, thread2가 스케쥴러에의해 할당될때 가장 먼저 main이 실행되도록 할당되기 때문이다. 
		
		
		
		
		
		
		
		
	}

}
