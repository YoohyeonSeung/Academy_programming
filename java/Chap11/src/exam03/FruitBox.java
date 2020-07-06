package exam03;

class FruitBox<T> {    // 제너릭 클래스
	T item;

	FruitBox(){}
	
	public void store(T item) {
		this.item = item;
	}
	
	public T pullOut() {
		return this.item;
	}
}
