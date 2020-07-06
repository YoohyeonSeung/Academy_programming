package exam13;

class OuterClass {

	private String name;
	private int num;
	InnerClass innerClass;
	
	OuterClass(String name){
		this.name = name;
		num=0;
		innerClass = new InnerClass();
		
	}
	
	public void whoAreYou() {
		num++;
		System.out.println(name + "OuterClass"+ num);
	}
	
	
	class InnerClass{
		
		InnerClass(){
			whoAreYou();
			//InnerClass는 OuterClass가 이미 메모리에 할당되어 있는 상태에서 
			//호출되기때문에 오류가 뜰일이 없음.
		}
		
		
		
		
	}
	
	
	
	
	
	
}
