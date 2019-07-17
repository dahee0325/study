package box;

public class Box {

	public static void main(String[] args) {
		
		Box box = new GoldPaperBox();
	
		wrapBox(box);
	}
	
	public void wrap() {
		System.out.println("Simple Wrap");
	}
	
	public static void wrapBox(Box box) {

			box.wrap();
		}
	}


class PaperBox extends Box {
	public void wrap() {
		super.wrap();
		System.out.println("Paper Wrap");
	}
}


class GoldPaperBox extends PaperBox {
	public void wrap() {
		super.wrap();
		System.out.println("Gold Wrap");
	}
}
