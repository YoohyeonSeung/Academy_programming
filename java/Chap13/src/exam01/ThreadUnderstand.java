package exam01;

class ShowThread extends Thread{

	String threadName;
	int start, end;
	
	ShowThread(String threadName,int start, int end){
		this.threadName = threadName;
		this.start = start;
		this.end = end;
		
	}
	
	@Override
	public void run() {   //main은 하나 밖에 선언 못하기 때문에, 메인을 못쓰니 main대신 run으로 호출해서 씀.
		int sum =0;
		
		for(int i=start; i<=end; i++) {
			sum+=i;
			System.out.println(threadName);
		}
		
		System.out.printf("%s =>%d 에서 %d 까지의 합 : %d\n", threadName, start, end, sum);
		
	}   
}
public class ThreadUnderstand {

	public static void main(String[] args) {
		
		ShowThread thread1 = new ShowThread("쓰레드1", 100, 110);
		//thread1.run(); run을 호출 하고 싶은게 아니라 thread를 동작 시키고 싶은것이므로 이코드를 쓰면안된다. 
		
		thread1.start();  // start()는 부모클래서 thread에서 선언된 메소드.
		//메인은 메인대로 thread는 thread대로 동시에 진행된다. 
		
		ShowThread thread2 = new ShowThread("쓰레드2", 2000,2010);		
		thread2.start(); 
		
		int sum=0;
		
		for(int i=1000;i<=1010;i++) {
			sum+=i;
			System.out.println("main");
		}
		System.out.println("main() 메서드 실행 =>1000부터 10000까지의 합 "+ sum);
		
		/*운영체제에서 스케쥴러가 여러 thread의 요청이 들어왔을 때, 동시에 실행되는 것과 같은 효과를 주기위해 각 방(해야 할 일을 넣어놓은)에 
		 * 골고루 배분하여 처리를 한다. 
		 * 이경우는 10개밖에 안되니 결과를 순식간에 끝내니 배분할 틈이 없이 배분된게 끝날뿐이지 적당히 큰 수정도 반복을 하게되면 알아서 적당히 
		 * 골고루 배분하게됨.
		*/
		

	}

}
