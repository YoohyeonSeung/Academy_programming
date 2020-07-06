package exam06;

class Speaker {
	private int volumeRate;  // 볼륨
	
	public void setVolumeRate(int volumeRate) {    //볼륨 조절하는 메소드
		this.volumeRate = volumeRate;
	}
	public int getVolumeRate() {  //볼륨 읽어오는 메소드
		
		return volumeRate;
	}
	public void showCurrentState() {
		System.out.println("볼륨 크기 : "+getVolumeRate() );
	}
	
	
	

}
