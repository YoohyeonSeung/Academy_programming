package exam03;

class MessageSendingThread extends Thread{
	String message;
	
	MessageSendingThread(String message, int priNum){
		this.message = message;
		setPriority(priNum);    //default는 5이고 우선순위는 1부터 10까지이다. 우선순위가 10에 가까울수록 먼저 실행된다.
	}
	@Override
	public void run() {
		for(int i = 0; i< 5; i++) {
			System.out.println(message +"("+getPriority()+")");  
			
			try {
				sleep(10);                                       // 넣어준 숫자만큼의 밀리초만큼 쉬게 해주어 thread가 점유하는걸 방지
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}	
}
public class PriorityTest {

	public static void main(String[] args) {
		MessageSendingThread thread1 
					= new MessageSendingThread("First", Thread.MAX_PRIORITY);    // 10과 같음
		MessageSendingThread thread2 
					= new MessageSendingThread("Second", Thread.NORM_PRIORITY);    // 5와 같음
		MessageSendingThread thread3 
					= new MessageSendingThread("Third", Thread.MIN_PRIORITY);     // 1과 같음
		MessageSendingThread thread4 
					= new MessageSendingThread("Fourth", 6);
				
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		//우선순위가 높은것은 먼저수행하는 가중치적인 의미이다. 동시에 수행되는 개념이 있기 때문에 상대적이게 된다. 
		
		
		//우선 순위가 같더라도 반복문 같은게 있다면 순서가 반복문이 먼저되는 경향이 잇음
		}
}
