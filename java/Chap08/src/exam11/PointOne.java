package exam11;

class PointOne extends Object implements UpperCasePrintable{

	private int xPos;
	private int yPos;
	
	PointOne(int xPos, int yPos){
		this.xPos=xPos;
		this.yPos=yPos;
	}

	@Override
	public String toString() {
		String posInfo = "(x pos : " + xPos + ", y pos : "+ yPos +")";
		return posInfo;
	}
	
	
	
	
	
}
