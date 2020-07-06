package exam04;

class Police extends Gun {    //-> 모든 경찰은 총을 가지고 있는 구조(총을 상속 받는....)

	int handcuffs; // 소유한 수갑의 수 
	
	Police(int bullet, int handcuffs){
		super(bullet);
		this.handcuffs = handcuffs;
	}
	
	public void putHandcuff() {
		System.out.println("SNAP");
		handcuffs--;
	}
	
	
}
