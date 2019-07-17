package collectiontest;

import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetTest {

	public static void main(String[] args) {
	
		
		TreeSet<Person> tSet = new TreeSet<Person>();
		
		tSet.add(new Person("tiger", 30));
		tSet.add(new Person("scott", 20));
		tSet.add(new Person("adams", 50));
		
		Iterator<Person> itr = tSet.iterator();
		
		//compareTo 메서드에 따라 오름차순, 내림차순을 변경할 수 있음
		while(itr.hasNext()) {
			//Person 데이터 반환
			System.out.println(itr.next());
		}
	}

}


class Person implements Comparable<Person>{
	
	String name;
	int age;
	
	public Person(String name, int age) {
		
		this.name = name;
		this.age = age;
		
	}
	
	
	/*
	void showData() {
		System.out.println("이름 : "+name+", 나이 : "+ age);
	}
	*/
	

	
	@Override
	public String toString() {
		
		//Person 객체에 무엇이 들어가 있는지 확인
		return "Person [name=" + name + ", age=" + age + "]";
	}


	@Override
	public int compareTo(Person o) {
		
		//비교하는 데이터가 작으면 양수 반환
		//비교하는 데이터가 크면 음수 반환
		//같으면 0 반환
		
		int result = 0;
		
		//전달받은 나이 = o.age
		//전달받은 나이가 this.age보다 크다면 양수반환
		if(this.age > o.age) {
			result = 1;//양수반환 (양수면 무슨 숫자들 상관없다)
		} else if(this.age < o.age) {
			result = -1;//음수반환
		}
		
		/*
		 * 초기값이 0이기때문에 필요없는 코드
		 * else { result = 0; 
		 * }
		 */
		
		return result;
		
		//마지막에 어떤값을 반환하느냐에 따라 오름차순 내림차순을 결정해준다.
		//return age-o.age;
		//return o.age-age;
		
	}
}