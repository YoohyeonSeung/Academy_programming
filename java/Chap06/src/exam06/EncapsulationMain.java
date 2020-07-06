package exam06;

class SnuffleCap {
	public void take() {
		System.out.println("콧물이 싹~ 납니다.");
	}
}

class SneezeCap {
	public void take() {
		System.out.println("재채기가 멎습니다.");
	}
}

class NasalStuffinessCap {
	public void take() {
		System.out.println("코가 뻥 뚫립니다.");
	}
}

class CONTAC600 {
	SnuffleCap snu;
	SneezeCap sne;
	NasalStuffinessCap nas;

	CONTAC600() {
		snu = new SnuffleCap();
		sne = new SneezeCap();
		nas = new NasalStuffinessCap();
	}

	public void take() {
		snu.take();
		sne.take();
		nas.take();
	}
}

class ColdPatient {
	public void takeCONTAC600(CONTAC600 cap) {
		cap.take();
	}
}

public class EncapsulationMain {
	public static void main(String[] args) {
		ColdPatient chul_soo = new ColdPatient();
		CONTAC600 cap = new CONTAC600();

		chul_soo.takeCONTAC600(cap);
	}
}