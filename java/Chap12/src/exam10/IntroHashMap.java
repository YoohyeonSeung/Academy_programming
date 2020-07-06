package exam10;

import java.util.HashMap;

public class IntroHashMap {

	public static void main(String[] args) {
		HashMap<String, String> map = new HashMap<String, String>();
		
		map.put("이름", "짐구");
		map.put("주소", "의정부시");
		map.put("이메일", "jimgu@jimgu.com");
		map.put("전화번호", "01012345678");
		map.put("거주지", "의정부");
		
		map.remove("주소");
		System.out.println(map.get("이름"));
		System.out.println(map.get("이메일"));
		System.out.println(map.get("전화번호"));
		System.out.println(map.get("주소"));
		System.out.println(map.get("거주지"));

		
	}

}
