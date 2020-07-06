package exam11;

public class TwoDimenArray1 {

	public static void main(String[] args) {
		int[][] arr = new int[3][4];
		//int[] arr[] 이런식으로 해도 상관 없으나, 위에 있는 방법으로 하는게 좋음.
		
		arr[0][0]=0;
		arr[0][1]=1;
		arr[0][2]=2;
		arr[0][3]=3;
		
		arr[1][0]=4;
		arr[1][1]=5;
		arr[1][2]=6;
		arr[1][3]=7;
		
		arr[2][0]=8;
		arr[2][1]=9;
		arr[2][2]=10;
		arr[2][3]=11;		
		
	
		/*int j=0;
		while(j<3) {
			for(int i=0;i<4; i++) {
				System.out.print(arr[j][i]+"  ");
			}
			j++;
			System.out.println();
		}*/
		for(int j=0; j<arr.length; j++) {
			for(int i=0; i<arr[j].length; i++) {
				System.out.print(arr[j][i]+"  ");
			}
			System.out.println("");
		}
		System.out.println(arr.length);// 이것으로보아 2차원 배열은 행3개의 묶음으로 바라본다는것이다. 
		System.out.println(arr[0].length); //한 행의 길이(length) or 행의 원소 갯수를 확인하는 방법.
			
		
	

	}
}
