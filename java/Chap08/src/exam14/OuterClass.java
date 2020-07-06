package exam14;

interface readable{
	public void read();
}

class OuterClass {
	
	private String name;
	
	OuterClass(String name){
		this.name = name;
		
				
	}
	public readable createLocalClassInst(int num) {
		/*int num은 stack 영역에 있게 되고 메소드가 호출되면 바로 소멸된다.
		 *그럼 밑의 num이 값을 무엇을 받아야 할지 모르게됨.
		 * 이러한 문제가 없게 하기 위해 final int num으로 해야 한다. 
		 * 근데 6버전부터는 final을 안넣어도 메소드 내에서 쓸수 있게 해준것이다.
		 */
		class LocalClass implements readable{
			//LocalClass를 readable로 바라볼 수 있다. 
			public void read() {
				System.out.println("LocalClass read() : "+ name);
				System.out.println("num : "+num);
			}				
		}
		readable localClass =  new LocalClass();
		return localClass;
	}
	

}
