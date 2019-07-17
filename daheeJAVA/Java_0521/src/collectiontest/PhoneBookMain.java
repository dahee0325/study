package collectiontest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class PhoneBookMain {

	public static void main(String[] args) {
		
		
		//testArrayList()
		//iteratorTest()
		//hashSetTest();
		//hashSetTest1();
		testHashSet();
	}
	
		
	
	static void testArrayList() {
		//친구의 데이터를 저장하고 출력하는 프로그램
		
				/*int cnt = 0;
				PhoneInfo[] arr = new PhoneInfo[30];
				arr[10] = new PhoneInfo("다희", "010-0000-1111");*/
				
				
				//배열을 알아서 만들어주고, 배열크기를 넘어가도 알아서 추가해주고 등등
				ArrayList<PhoneInfo> pList = new ArrayList<PhoneInfo>();
				
				
				
				PhoneInfo pi1 = new PhoneInfo("혜원", "01099991111","19970907");
				PhoneInfo pi2 = new PhoneInfo("다혜", "01022221111");
				
				
				//ArrayList pList에 데이터 추가
				pList.add(pi1);//pi1은 PhoneInfo타입이라 들어갈 수 있음
				pList.add(pi2);
				
				
				/*
				 * pi1.showInfo(); 
				 * System.out.println("===========================");
				 * pi2.showInfo();
				 */

				for (int i = 0; i < pList.size(); i++) {

					pList.get(i).showInfo();
					System.out.println("-----------------------");
					if (pList.get(i).name.equals("다혜")) {
						System.out.println("찾았다 다혜!->" + i);
					}
				}

				pList.remove(0);

				for (int i = 0; i < pList.size(); i++) {

					pList.get(i).showInfo();
					System.out.println("-----------------------");
					if (pList.get(i).name.equals("다혜")) {
						System.out.println("찾았다 다혜!->" + i);
					}
				}
	}

	
	
	//List<E> 같은 경우에는 순서를 가지기 때문에 index기준으로 전체참조가 가능하다(반복문을 사용해서)
	//순서없는 집합은 Iterator<E>을 사용하여서 hasNext(),remove(),next() 메서드 사용해 줄을세워 사용가능하다
	//줄세워서 사용하는것은 Iterator을 사용하여 쓸 수 있따
	
	static void iteratorTest() {

		
		LinkedList<String> list = new LinkedList<String>();
		
		list.add("first");
		list.add("second");
		list.add("third");
		list.add("forth");
		
		//정렬을 위한 인터페이스 Iterator<E>
		Iterator<String> itr = list.iterator();
		
		//list안에 확인할 다음요소가있는지 있으먄 true,없으면 false (True라면 while문 실행) / false면 stop
		while(itr.hasNext()) { 
			//값반환을 하면서 다음 요소로 이동
			//System.out.println(itr.next());//first
			//System.out.println(itr.next().equals("first"));//second
			//System.out.println(itr.next());//third
			
			//값반환하면서 다음요소로 이동하는 것을 str에 저장
			String str = itr.next();
			System.out.println(str);
			//compareTo는 문자들끼리 빼어서 크다작다를 표현할 수 있다. (빼서 0이 나오면 같은 문자인것)
			if(str.compareTo("third") == 0) {
				
				//third가 있다면 지워라
				itr.remove();
			
			}
		}
		
		System.out.println("\n삭제 후 요소 참조");
		
		//삭제된 list값을 줄세워서 가져옴
		itr = list.iterator();
		
		//데이터들을 가져옴
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
	}


	
	static void hashSetTest() {
		
		HashSet<String> set = new HashSet<String>();
		
		set.add("first");
		set.add("second");
		set.add("third");
		set.add("first");
		
		System.out.println("요소의 개수 : "+ set.size());
		
		//iterator()을 통해 줄세우기 (set은 순서와 인덱스 값을 갖고 있지 않기 때문에)
		Iterator<String> itr = set.iterator();
		//확인할 요소가 있는지 내려가면서 확인하는게 hasnext()
		//커서 움직여서 값가져오는게(커서가 다음으로 이동하면서 값을 가져옴) next()
		//삭제 remove()
		
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		//배열 형태로 받을 수 있는게 toArray
		//배열을 사용하면 for문을 사용하여 빠른참조가 가능하다
		System.out.println("====================");
		System.out.println("배열객체로 변환, 참조 ");
		//Object에는 String이 들어가 있기 때문에 문자열 출력가능
		Object[] strArr = set.toArray();
		
		for(int i=0; i<strArr.length; i++) {
			System.out.println(strArr[i]);
		}
		
		
		//
		ArrayList<String> list = new ArrayList<String>(set);
		System.out.println("====================\nSet->List 리스트요소로 변환");
		System.out.println("리스트 요소의 개수 : "+list.size());
		
		
		for(int i=0; i<list.size(); i++) {
			//list는 인덱스값 참조하여 출력
			System.out.println(list.get(i));
		}
		
	}


	static void hashSetTest1() {

		HashSet<SimpleNumber> set = new HashSet<SimpleNumber>();
		set.add(new SimpleNumber(10));
		set.add(new SimpleNumber(20));
		set.add(new SimpleNumber(20));
		
		System.out.println("저장된 요소의 개수 : "+ set.size());
		
		Iterator<SimpleNumber> itr = set.iterator();
		
		while(itr.hasNext()) {
			
			System.out.println(itr.next());
			
		}
	}
	
	
	static void testHashSet() {
		
		
		HashSet<PhoneInfo> pSet = new HashSet<PhoneInfo>();
		
		
		
		PhoneInfo pi1 = new PhoneInfo("혜원", "01099991111","19970907");
		PhoneInfo pi2 = new PhoneInfo("다혜", "01022221111");
		PhoneInfo pi3 = new PhoneInfo("혜원", "01099991111","19970907");
		
		pSet.add(pi1);
		pSet.add(pi2);
		pSet.add(pi3);
		
		System.out.println("저장된 요소의 개수 : "+pSet.size());
		
		Iterator<PhoneInfo> itr = pSet.iterator();
		
		while(itr.hasNext()) {
			itr.next().showInfo();
		}
		
	}
}


class SimpleNumber {
	
	int num;
	
	public SimpleNumber(int num) {
		this.num = num;
	}
	
	
	@Override
	public int hashCode() {
		
		return num%3;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		
		//Object 참조변수에 null이 들어올 수 있어서 초기값을 틀렸다고 과정하고 들어오는 값이 맞는지 비교해야하기 때문에 false로 초기값을 둔다.
		boolean result = false; 
		
		//null이 아니고 형변환이 가능한지
		if(obj != null && obj instanceof SimpleNumber) {
			
			SimpleNumber number = (SimpleNumber) obj;
			
			//result는 불린타입
			//SimpleNumber값에 있는 num을 가지고 비교
			result = this.num == number.num;
		}
		
		return result;
	}
	
	
	public String toString() {
		//num은 int타입이라 String에 그냥 가져올 수 없어서 String타입으로 변환해줘야함
		//return ""+num; 도 가능
		return String.valueOf(num);
		
	}
	
	
}