package exam11;

public class TwoDimeArray2 {

	public static void main(String[] args) {
		int[][] arr= { {0,1}, 
							{4,5,6}, 
							{8,9,10,11}
						};   //안에 있는 하나하나가 행(row)이다.
		/*c언어라면 3x4 행렬로 할당하여 빈공간엔 0으로 반환하나, 자바는 그렇지 않고 1행은 원소가 두개뿐인 배열을 만듬
	     *그러므로 아래 코드에서 length 를 넣어주는 이유이다.
	     */
		for(int j=0; j<arr.length; j++) {
			for(int i=0; i<arr[j].length; i++) {
				System.out.print(arr[j][i]+"  ");
			}
			System.out.println("");
		}
	}

}
