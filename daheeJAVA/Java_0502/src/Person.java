
class Person {
	long id;

	public boolean equals(Object obj) {
		if (obj != null && obj instanceof Person)
			return id == ((Person) obj).id;
// obj가 Object타입이므로 id값을 참조하기 위해서는 Person타입으로 형변환이 필요하다.
		else
			return false; // 타입이 Person이 아니면 값을 비교할 필요도 없다.
	}

	Person(long id) {
		this.id = id;
	}
}