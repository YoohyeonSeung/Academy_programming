package exam04;

class Gun {
	int bullet;  // 장전된 총의 갯수

	Gun(int bullet){
		this.bullet = bullet;
	}
	
	public void shut() {
		if(bullet<1) {
			System.out.println("총알이 없습니다.");
			return;
		}
		else {
		System.out.println("BBANG");
		bullet--;}
	
	}
	
	
	
}
