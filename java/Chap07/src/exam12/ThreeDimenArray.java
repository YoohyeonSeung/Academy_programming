package exam12;

public class ThreeDimenArray {

	public static void main(String[] args) {
	
		int[][][] threeDimenArray = new int[2][3][4];// ->3행4열짜리 2개
		int num=0;
		for(int k=0; k<2;k++) {
			for(int j=0; j<3; j++) {
				for(int i=0; i<4; i++) {
					threeDimenArray[k][j][i] = num++;
				}	
			}
		}
		
		for(int k=0;k<threeDimenArray.length;k++) {
			for(int j=0;j<threeDimenArray[k].length;j++) {
				for(int i=0; i<threeDimenArray[k][j].length; i++) {
					System.out.print("["+ (k+1)+"]"+"["+(j+1)+"]"+"["+(i+1)+"]"+"="+ threeDimenArray[k][j][i]+"  ");
				}
				System.out.println();
			}
		System.out.println();
		}
		

		

		
	}
}
		


