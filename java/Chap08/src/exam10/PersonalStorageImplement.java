package exam10;

//class PersonalStorageImplement extends PersonalStorage{
class PersonalStorageImplement implements PersonalStorage{
	//interface로 정의 되어있다면 extends로 하면 안되고 implements로 해야됨.
	
	private Personal[] perArr; 
	private int numOfPerInfo;
			
	PersonalStorageImplement() {
		perArr = new Personal[100];
		numOfPerInfo=0;
	}
		
	@Override
	public void addPersonalInfo(String name, String id) {
		perArr[numOfPerInfo++] = new Personal(name, id);
		System.out.println("데이터 저장 완료");
		
	}


	
	@Override
	public String searchName (String name) {
		for(int i=0; i<numOfPerInfo; i++ ) {
			if(perArr[i].getName().compareTo(name) ==0 ) {
				//perArr[i].getName()==name 이라 하면 주소값과 name이 같은지 여부를 묻는 것이기 때문에 제대로된 결과값을 출력할 수 없다.
				//즉 참조변수를 이용해서 값을 보는경우에는 이런식으로해야하며
				//만약 String형으로 두개를 했다면 ==를 써도됨
				return perArr[i].getId();
			}
		}
		return null;	
	}
		
}

	
	
	

