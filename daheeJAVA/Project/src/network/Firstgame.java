package network;

class Firstgame {
	public static int MAX_COUNT = 3;
	int x = 0, y = 0;
	public boolean val = false;
	public int baseNumber[] = new int[MAX_COUNT];
	public int userNumber[] = new int[MAX_COUNT];
	public int cnt = 0;

	void home() {
		System.out.println("==========================");
		System.out.println("숫자야구를 시작합니다.");

	}
	
	void randomnum() {
		do {
			baseNumber[0] = (int) (Math.random() * 10);
		} while (baseNumber[0] == 0);

		for (int i = 1; i < baseNumber.length; i++) {
			baseNumber[i] = (int) (Math.random() * 10);
			for (int j = 0; j < i; j++) {
				while (baseNumber[i] == baseNumber[j] || baseNumber[i] == 0) {
					baseNumber[i] = (int) (Math.random() * 10);
					j = 0;
				}
			}
		}
	}

	void inputUserNumber1(String receive) {

		String in = receive;
		for (int i = 0; i < userNumber.length; i++) {
			userNumber[i] = in.charAt(i) - 36;
		}
		countSB(baseNumber, userNumber);
	}
	
	void inputUserNumber2(String send) {

		String in = send;
		for (int i = 0; i < userNumber.length; i++) {
			userNumber[i] = in.charAt(i) - 36;
		}
		countSB(baseNumber, userNumber);
	}

	synchronized void countSB(int a[], int b[]) {

		x = 0;
		y = 0;
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < b.length; j++) {
				if (b[i] == a[j])
					if (i == j)
						x += 1;
					else
						y += 1;
			}
		}

		cnt++;
		if (x == MAX_COUNT) {
			val = true;
			return;
		}
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	int getCount() {
		return cnt;
	}

	boolean getValue() {
		return val;
	}
}