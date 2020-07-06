package exam06;

public class MethodOverriding {

	public static void main(String[] args) {
		Speaker LGSpeaker = new Speaker();
		
		LGSpeaker.setVolumeRate(7);
		LGSpeaker.showCurrentState();
		
		
		System.out.println("===================");
		
		BaseEnSpeaker baseSpeaker = new BaseEnSpeaker();
		
		baseSpeaker.setVolumeRate(5);
		baseSpeaker.getVolumeRate();
		baseSpeaker.setBaseRate(6);
		baseSpeaker.getBaseRate();
	 	
		baseSpeaker.showCurrentState(); //->이경우 자식의 method를 호출(같은 이름으로 정의 하였을 때)
		
		
		//BaseEnSpaeker 로 햇다 하더라도 상속의 관계에 있기 때문에 가능
		Speaker speaker1 = new BaseEnSpeaker();
		/* 메모리 할당(Heap영역)은 Speaker대신 BaseEnSpeaker와 같이 할당이 된다.
		 *  그러나 speaker1의 자료형은 Speaker형으로 된다.(변수 선언)
		 *  이런 것이 가능한 것은 '상속의 조건하에서' 라는 대전제가 필요함.(다형성)
		 */
		speaker1.setVolumeRate(5);
		speaker1.getVolumeRate();
		
		/*
		speaker1.setBaseRate(7); 
		speaker1.getBaseRate(8);
		speaker형으로 정의하였기에 baseEnBase의 입장에서 바라볼 수 없다.
		그러므로 저런 코드는 쓸 수 없다.
		*/		
		
		speaker1.showCurrentState();
		//자료형이 speaker으로 정의 되었다 하더라도 메소드는 자식에 정의되어있는 메소드로 나옴
		
	}
	
	

}
