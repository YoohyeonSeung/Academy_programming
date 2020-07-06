package exam09;

class Person {
	private String name; //이름
	private int milID;  //군번
	
	Person(String name, int mID){  
		this.name = name; //this.을 이용하면 밖에서의 name을 쓸 수 있음
		/*new Person()
		 * 1. 메모리 할당
		 * 2. this.생성 ->field에 접근할 주소값
		 * 3. 생성자 호출
		 * 4. 주소값 반환
		 */
		this.milID = mID;
		/*만약 private String name;
		 * Person(String name, int mID){  
		 *    name = name;
		 * 이렇게 하면 생성자 내에서 name 왼쪽은 private에서 name을 쓰는게 아니라 
		 * person(String name,...)에서의 name을 가져다씀 
		 */
	}
	Person(String name){  
		this.name = name;
		this.milID=0;
	}
	/*동일한 이름으로 생성자는 정의 되나, 자료형의 갯수가 다르면 가능
	 */
	
	public void ShowInfo() {
		if (milID==0) {
			System.out.println("이름 : " + name);
		}
		else {
			System.out.println("이름 : " + name);
			System.out.println("군번 : " + milID);
		}
		
		
	}
	
}
