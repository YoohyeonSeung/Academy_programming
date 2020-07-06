package exam16;

public class EscapeSequence {

	public static void main(String[] args) {
		System.out.print("프로그램 ");
		System.out.println("시작.");
		
		System.out.println("친구가 어제\"잘 다녀왔어?\"라고 물어서....   ");    //문장내에 ""를 쓰고 싶을때 이런식으로 하면된다.
		System.out.println("친구가 어제 '잘 다녀왔어?' 라고 물어서....   ");
		System.out.println("친구가 어제 '잘 다녀왔어?'\t 라고 물어서....   ");
		System.out.println("친구가 어제 '잘 다녀왔어?'\n 라고 물어서....   ");
		
		// System.out.println("C:\workspaces\java");   \를 만나면 java는 escape를 한다고 인식. 꼭 써야된다면 \\를 두번써주면된다.
		System.out.println("C:\\workspaces\\java");
		
	
	}

}
