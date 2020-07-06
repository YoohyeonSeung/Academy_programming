package exam05;



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
		
		Rectangle copy =  (Rectangle) super.clone();          //stack영역에 임시로 copy를 생성하여 복본의 주소값 저장
		
		copy.upperLeft = (Point) upperLeft.clone();            //Shallow copy와는 다르게 heap영역에 새로 메모리 할당을 받게된다.
		copy.lowerRight = (Point) lowerRight.clone();
		
		return copy;                   //main메소드에서 할당을 해준 후에 stack영역에 copy는 소멸!
	}
	
	
	
}
