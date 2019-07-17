package generic.test;

public class FruitBox<T> {
	
	
	T item;
	
	
	public FruitBox(T item) {
		this.item = item;
	}
	
	//어떤 과일인지에 따라서 저장해야하니까
	public void store(T item) {
		this.item = item;
	}
	
	//꺼내기
	public T pullOut() {
		return item;
	} 
}
