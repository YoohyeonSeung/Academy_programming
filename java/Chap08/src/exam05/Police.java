package exam05;

class Police{  //-> 경찰중에는 총을 가지지 않은 사람이 존재한다.(총을 상속받지 않을 수도 있다.)

	int handcuffs; // 소유한 수갑의 수 
	Gun gun;
	/*Police(int bullet, int handcuffs){
		if(bullet > 0) {
			new Gun(bullet);    // Gun  gun = new Gun(bullet);으로 하는 경우 if문이 끝나면 소멸되기 때문에 Gun gun을 field에서 선언해줘야함
		}
		else {
			gun = null;
		}
		this.handcuffs = handcuffs;
	}*/
	
	/*//또는 overload를 이용하여 다음과 같은 코드를 짜도된다.
	Police(int handcuffs){
		this.handcuffs=  handcuffs;
		gun = null;
	}
	police(int bullet, int handcuffs){
		new Gun(bullet);
		this.handcuffs = handcuffs;
	}*/
	
	
	public void putHandcuff() {
		System.out.println("SNAP");
		handcuffs--;
	}
	
	public void bbang() {
		if( gun == null ) {
			System.out.println(gun);
			System.out.println("Hut BBANG");
			
		}
		else {
			gun.shut();
		}
	}
	
	
}
