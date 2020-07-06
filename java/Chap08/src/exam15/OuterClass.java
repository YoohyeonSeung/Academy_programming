package exam15;

interface Readable{
	public void read();
}

class OuterClass {
	
	private String name;
	
	OuterClass(String name){
		this.name = name;
		
				
	}
	public Readable createLocalClassInst(int num) {
				
		/*class LocalClass implements readable{
			public void read() {
				System.out.println("LocalClass read() : "+ name);
				System.out.println("num : "+num);
			}				
		}
		readable localClass =  new LocalClass();
		return localClass;*/
		
		return new Readable() {

			@Override
			public void read() {
				System.out.println("LocalClass read() : "+ name);
				System.out.println("num : "+num);
				
			}
		};	
	}
}
