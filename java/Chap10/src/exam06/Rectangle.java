package exam06;



class Rectangle implements Cloneable {
	Point upperLeft;
	Point lowerRight;
	
	Rectangle(int x1, int y1, int x2, int y2){
		upperLeft = new Point(x1, y1);
	    lowerRight = new Point(x2, y2);
		
	}
	public void showPosition() {
		System.out.println("직사각형의 위치 정보..............");
		System.out.println("좌상단 : " );
		upperLeft.showPosition();
		System.out.println("우하단 : ");
		lowerRight.showPosition();
		
	}
	
	public void changePos(int x1, int y1, int x2, int y2) {
		upperLeft.changePosition(x1, y1);
		lowerRight.changePosition(x2, y2);
		
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		
		return super.clone();
	}
	
	
	
}
