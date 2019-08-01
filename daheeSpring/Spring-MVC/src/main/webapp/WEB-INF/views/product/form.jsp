<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post">
		<!-- list 명을 name에 지정하면 프라임워크는 자동으로 만들어준다. orderItems[0]에 itemId를 set -->
		<h2>상품</h2>
		상품1 - id : <input type="text" name="orderItems[0].itemId"><br>
		상품1 - 개수 : <input type="text" name="orderItems[0].number"><br>
		상품1 - 주의 : <input type="text" name="orderItems[0].remark"><br>
		<br>
		상품2 - id : <input type="text" name="orderItems[1].itemId"><br>
		상품2 - 개수 : <input type="text" name="orderItems[1].number"><br>
		상품2 - 주의 : <input type="text" name="orderItems[1].remark"><br>
		<br>
		상품3 - id : <input type="text" name="orderItems[2].itemId"><br>
		상품3 - 개수 : <input type="text" name="orderItems[2].number"><br>
		상품3 - 주의 : <input type="text" name="orderItems[2].remark"><br>
		<br>
		
		<h2>배송지</h2>
		<!-- address 객체를 생성하고 zipcode에 저장해줌 -->
		우편번호 : <input type="text" name="address.zipcode"><br>
		주소1 : <input type="text" name="address.address1"><br>
		주소2 : <input type="text" name="address.address2"><br>
		
		<br>
		<input type="submit" value="주문">
		
	</form>
</body>
</html>