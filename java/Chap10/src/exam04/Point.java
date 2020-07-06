package exam04;

class Point /*extends Object*/implements Cloneable {
	//cloneable을 안써줄경우 CloneNotSupportedException 예외가 발생한다.
	// 복사를 허용해주겠다는 마크!
	
	private int xPos;
	private int yPos;
	
	Point(int x, int y){
		this.xPos = x;
		this.yPos = y;
	}
	
	public void showPosition() {
		System.out.printf("[%d, %d]\n", xPos, yPos);
					
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
				
		return super.clone();
	}
	
	
	

}
