package exam10;

//abstract class PersonalStorage {  //상속의 목적으로 정의 
interface PersonalStorage{    //interface로 바꿀수 있는 조건은 아래의 메소드들이 다 abstract메소드로 정의 되어있어야함.
	abstract public void addPersonalInfo(String name, String id); //오버라이딩해서 쓸 목적으로 추상메서드 정의
	abstract public String searchName(String name);
}
