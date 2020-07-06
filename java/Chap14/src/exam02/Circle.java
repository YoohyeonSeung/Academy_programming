package exam02;

import java.io.Serializable;

class Circle implements Serializable {
	int xPos;
	int yPos;
	double rad;
	
	Circle(int xPos, int yPos, double rad){
		this.xPos = xPos;
		this.yPos = yPos;
		this.rad = rad;
		
	}
	
	public void ShowInfo() {
		
		System.out.printf("좌표 =(%d, %d)\n", xPos, yPos);
		System.out.println("반지름 = "+ rad);
		
		
		
		
	}
	
	

}
