package collectiontest;

import java.util.ArrayList;

public class ArrayListTest {

	public static void main(String[] args) {
		
		//ArrayList<저장하는타입 정의>
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		
		//컬렉션(List -> ArrayList) 객체에 요소(객체, 참조변수) 저장 - 실제로 메모리에 저장되는건 주소값
		//Integer타입으로 지정해놓았기 때문에 Integer타입만올 수 있다.
		list.add(new Integer(11));
		list.add(new Integer("22"));
		list.add(33);//자동으로 Integer타입으로 감싸줌
		

		//값을 확인하기 위해 데이터 참조
		System.out.println("리스트에 저장된 요소들의 출력");
		
		//list.size : list의 크기(사이즈값을 가져올 수 있음)
		for(int i=0; i<list.size(); i++) {	
			//get(i)를 통해 list i번째에 있는 요소를 출력함
			System.out.println(list.get(i));
		}
		
		//요소 삭제 : 0번째에 있는 리스트 요소 삭제
		list.remove(0);
		
		System.out.println("삭제 후 리스트에 저장된 요소들 출력");
		for(int i=0; i<list.size(); i++) {	
			System.out.println(list.get(i));
		}
		
	}

}
