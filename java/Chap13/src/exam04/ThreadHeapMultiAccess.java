package exam04;

class Sum{
	int num;
	Sum(){
		num=0;	}
	
	public synchronized void addNum(int num) {this.num+=num;}
	public int getNum() {return num;}

}

class AdderThread extends Thread{
	int start, end;	
	Sum sumInst;
	
	AdderThread(Sum sum, int s, int e){
		this.sumInst = sum;
		this.start = s;
		this.end = e;
	}

	@Override
	public void run() {
		for(int i=start;i<=end;i++) {
			sumInst.addNum(i);
		}
		
	}

}


public class ThreadHeapMultiAccess {
	public static void main(String[] args) {
		Sum sum = new Sum();
		
		AdderThread at1 = new AdderThread(sum, 1, 5000);
		AdderThread at2 = new AdderThread(sum, 5001, 10000);
		
		
		at1.start();
		at2.start();
		
		try {
			at1.join();
			at2.join();
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		System.out.println("1~10000까지의 합 : " + sum.getNum());  
		/* 정확하게 값이 안나오는 이유는 동기화의 문제가 발생하기 때문이다
		 * at1 할때 갑자기 at2도 들어가고 하기때문에 num에 5001이 담겻다가 갑자기 1로 바뀌는 상황이 발생 고로 마지막값이 원하는 값을 받을 수 없다. 
		 * 동기화라는 작업이 필요! 이 작업은 Sum Class의 메소드에 synchronize를 void 앞에 넣어준다.
		 */
		
		
		 /* exam02와 차이점: 
		  * exam02의 경우 메모리를 공유해서 사용하지 않지만 exam04의 경우 공유해서 사용하고있다.
		  * 그렇다면 서로의 thread가 겹치지 않게 동기화(Synchronize 필요!)
		  * exam02는 동기화가 필요 하지 않다. 
		  */
	}

}
