package exam05;

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

class ColdPatient {
	public void takeSnuffleCap(SnuffleCap snu) { // 콧물 증상
		snu.take();
	}
	public void takeSneezeCap(SneezeCap sne) { // 재채기 증상
		sne.take();
	}
	public void takeNasalStuffinessCap(NasalStuffinessCap nas) { // 코막힘 증상
		nas.take();
	}
}

public class EncapsulationMain {
	public static void main(String[] args) {
		ColdPatient young_hee = new ColdPatient();
		ColdPatient chul_soo = new ColdPatient();

		SnuffleCap snu = new SnuffleCap();
		SneezeCap sne = new SneezeCap();
		NasalStuffinessCap nas = new NasalStuffinessCap();

		young_hee.takeSnuffleCap(snu); // 콧물
		young_hee.takeSneezeCap(sne); // 재채기

		chul_soo.takeSnuffleCap(snu);
		chul_soo.takeSneezeCap(sne);
		chul_soo.takeNasalStuffinessCap(nas);
	}
}