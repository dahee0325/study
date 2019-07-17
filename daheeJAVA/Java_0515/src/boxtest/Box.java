package boxtest;

public class Box {
	//Box에는 기능만 존재
	public void simpleWrap() {
		System.out.println("Simple Wrap");
	}
	
	//메인메소드는 대표 클래스 안에 존재
	public static void main(String[] args) {
		
		Box box = new Box();
		PaperBox paperBox = new PaperBox();
		GoldPaperBox goldGaperBox = new GoldPaperBox();
		
		//Box 타입의 매개변수 : 상속관계에 있는 하위 클래스의 인스턴스들은 다 가져올 수 있게된다.
		//매개변수들이 wrapBox에 있는 매개변수 안에 들어가면서
		//하위클래스들이 상위클래스로 형변환이 가능한지 확인한다.
		wrapBox(box);
		wrapBox(paperBox);
		wrapBox(goldGaperBox);
		
	}
	
	//최상위클래스는 전달받기 때문에 하위클래스들의 요소들을 받으려면 형변환해줘야한다.
	public static void wrapBox(Box box) {
		//어떤 박스이냐에 따라 맞는 포장을 해야한다.
		//어떤 박스이냐를 확인해야함
		//Box -> PaperBox, Box -> GoldPaperBox
		// : Box가 PaperBox로 형변환이 가능한지 확인해야함
		//대상 instanceof 확인할 참조변수 -> 결과값이 형변환이 가능하면 true, 안된다면 false 
		
		if(box instanceof GoldPaperBox) {
			//box가 GoldPaperBox로 형변환이 가능한지 확인 
			((GoldPaperBox) box).goldWrap();
		}else if(box instanceof PaperBox) {
			((PaperBox)box).paperWrap();
		}else {
			box.simpleWrap();
		}
	}
}

// public을 쓸수 있는 클래스는 하나만 가능해서 퍼블릭 사용 X
class PaperBox extends Box {
	public void paperWrap() {
		System.out.println("Paper Wrap");
	}
}

class GoldPaperBox extends PaperBox {
	public void goldWrap() {
		System.out.println("Gold Wrap");
	}
}
