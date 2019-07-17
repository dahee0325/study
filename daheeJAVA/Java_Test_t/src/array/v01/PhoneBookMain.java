package array.v01;

import java.util.ArrayList;

public class PhoneBookMain {

	public static void main(String[] args) {
		// 친구의 데이터를 저장하고 출력하는 프로그램

		/*
		 * int cnt = 0; PhoneInfo[] arr = new PhoneInfo[30]; arr[10] = new
		 * PhoneInfo("다희", "010-0000-1111");
		 */

		// 배열을 알아서 만들어주고, 배열크기를 넘어가도 알아서 추가해주고 등등
		ArrayList<PhoneInfo> pList = new ArrayList<PhoneInfo>();

		PhoneInfo pi1 = new PhoneInfo("혜원", "01099991111", "19970907");
		PhoneInfo pi2 = new PhoneInfo("다혜", "01022221111");

		// ArrayList pList에 데이터 추가
		pList.add(pi1);// pi1은 PhoneInfo타입이라 들어갈 수 있음
		pList.add(pi2);

		/*
		 * pi1.showInfo(); System.out.println("===========================");
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

}
