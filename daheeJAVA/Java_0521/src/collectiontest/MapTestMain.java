package collectiontest;

import java.io.ObjectInputStream.GetField;
import java.util.HashMap;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.TreeMap;

public class MapTestMain {

	public static void main(String[] args) {
		
		
		//HashMap 형식의 저장 공간 생성( 저장하는 방식의 기능, 삭제 기능, 참조기능 메서드도 만들어놓고 제공해줌 )
		//HashMap<Integer, String> hMap = new HashMap<Integer, String>();
		
		/*
		hMap.put(new Integer("1"), "박나래");
		hMap.put(new Integer(2), "손흥민");
		hMap.put(3, "배철수");
		hMap.put(4, "김신영");
		hMap.put(5, "유동하");
		*/
		
		//vlaue key값 가지고 출력
		/*System.out.println("1번 학생의 이름은 "+ hMap.get(1) +" 입니다.");
		System.out.println("2번 학생의 이름은 "+ hMap.get(2) +" 입니다.");
		System.out.println("3번 학생의 이름은 "+ hMap.get(3) +" 입니다.");
		System.out.println("4번 학생의 이름은 "+ hMap.get(4) +" 입니다.");
		System.out.println("5번 학생의 이름은 "+ hMap.get(5) +" 입니다.");
		
		 * hMap.remove(4);
		 * System.out.println(hMap.get(4));
		 * 
		 */
		
		
		
		//정렬이 가능한 TreeMap
		TreeMap<Integer, String> tMap = new TreeMap<Integer, String>();
		
		tMap.put(new Integer("1"), "박나래");
		tMap.put(new Integer(3), "손흥민");
		tMap.put(4, "배철수");
		tMap.put(2, "김신영");
		tMap.put(5, "유동하");
		
		
		NavigableSet<Integer> nav = tMap.navigableKeySet();
		
		//Iterator : 반복시켜서 순차적인 참조가 가능해짐
		Iterator<Integer> itr = nav.iterator();
		
		//오름차순
		System.out.println("[오름차순 정렬]");
		while(itr.hasNext()) {
			//key값 가져오는것
			//System.out.println(itr.next());
			
			//키값에 있는 데이터들 가져오기
			System.out.println(tMap.get(itr.next()));
			
		}
		
		System.out.println("\n[내림차순 정렬]");
		
		
		//descendingIterator(); 반대로 정령
		itr = nav.descendingIterator();
		
		while(itr.hasNext()) {
			System.out.println(tMap.get(itr.next()));
		}
		


	}

}
