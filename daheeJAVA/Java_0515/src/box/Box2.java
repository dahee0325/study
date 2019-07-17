package box;

public class Box2 {

	public static void main(String[] args) {
		
		Box2 box = new Box2();
		PaperBox2 paperBox = new PaperBox2();
		GoldPaperBox2 goldPaperBox = new GoldPaperBox2();

		
		 Box2 b1 = box;
		 Box2 b2 = paperBox;
		 Box2 b3 = goldPaperBox;
		 
		 
		 b1.wrap();
		 b2.wrap();
		 b3.wrap();

		
		
		/*
		 * wrapBox(box); 
		 * wrapBox(paperBox); 
		 * wrapBox(goldPaperBox);
		 */
		
	}
	
	void wrap() {
		System.out.println("Simple Wrap");
	}
	
	static void wrapBox(Box2 box)
	{
		box.wrap();
	}


}

class PaperBox2 extends Box2 {
	public void wrap() {
		System.out.println("Paper Wrap");
	}
}


class GoldPaperBox2 extends PaperBox2 {
	public void wrap() {
		System.out.println("Gold Wrap");
	}
}