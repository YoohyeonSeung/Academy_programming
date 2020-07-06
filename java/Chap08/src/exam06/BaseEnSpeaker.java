package exam06;

class BaseEnSpeaker extends Speaker {
	private int baseRate;
	
	public void setBaseRate(int baseRate) {
		this.baseRate = baseRate;
	}
	
	public int getBaseRate() {
		return baseRate;
	}
	
	public void showCurrentState() {
		super.showCurrentState(); 
		//상속의 관계가 있을때, 자식과 부모에 같은 이름의 메소드가 있는 경우 부모의 메소드를 호출 하고 싶을 때 이용하면된다.
		System.out.println("베이스 크기 : "+ getBaseRate());
	}
}
