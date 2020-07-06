package exam09;

public class ConstructorOverloading {

	public static void main(String[] args) {
		Person choolsu = new Person("철수", 20181106);
		Person mansoo = new Person("만수", 20181106);
		
		Person kildong = new Person("길동");
		
		choolsu.ShowInfo();
		mansoo.ShowInfo();
		kildong.ShowInfo();
	}

}
