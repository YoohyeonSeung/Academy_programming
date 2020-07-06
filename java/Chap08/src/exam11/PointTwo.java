package exam11;

class PointTwo {
	private int xPos, yPos;
	
	PointTwo(int xPos, int yPos){
		this.xPos = xPos;
		this.yPos = yPos;		
	}
	
	@Override
	public String toString() {
		String posInfo = "(x pos : " + xPos + ", y pos : "+ yPos +")";
		return posInfo;
	}
	
	
	
}
