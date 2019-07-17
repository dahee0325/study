package tirangle;

public class Triangle {

	float width; //삼각형의 밑변 데이터, 단위 cm, 자동초기화라 값은 0
	float hight; //삼각형의 높이 데이터, 단위 cm
	
	
	//데이터 변경하는 메소드
	//삼각형의 밑변 데이터와 높이 데이터를 설정
	//@w : 설정할 밑변 데이터
	//@h : 설정할 높이 데이터
	void setData(float w, float h) {
		
		width = w;
		hight = h;
		
	}
	
	//객체가 가지고 있는 높이 데이터와 밑변데이터를 가지고 넓이 계산해서 반환
	//위에 변수가지고 연산하면 되기때문에 매개변수를 정의할 필요없다.
	//삼각형의 넓이를 계산해서 반환하는 메소드 (반환은 float타입)
	//@return : 삼각형의 넓이 계산 후 flaot형의 데이터 반환
	float calArea() {
		
		//삼각형 넓이 구하는 공식 : 높이*밑변/2
		float result = hight*width/2f;
		return result;
	}
}
