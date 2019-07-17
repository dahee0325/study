<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP BLOG PAGE</title>
<link
	href="https://fonts.googleapis.com/css?family=Inconsolata|Josefin+Sans|Kaushan+Script|ZCOOL+KuaiLe&display=swap"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css?family=Gochi+Hand|Nanum+Pen+Script|Poor+Story&display=swap"
	rel="stylesheet">
<link href="css/blog_style.css" rel="stylesheet" type="text/css">
<style>
</style>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
</head>
<body>
	<div id="wrap">
		<%@ include file="header.jsp"%>
		<%@ include file="nav.jsp"%>
		<div id="content">
			<div id="post">
				<h2>HTML5 개요와 활용</h2>
				<p>2013년 02월 14일</p>
				<div class="img">
					<img alt="430x280">
				</div>
				<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.
					Necessitatibus deleniti quam amet est aliquam, dolorum impedit sunt
					vero beatae dicta quia, dolores veniam incidunt officia ex
					perferendis, iure voluptatem. Doloribus voluptatibus aspernatur
					nostrum debitis labore possimus enim blanditiis, voluptas. Non,
					iure. Eligendi veritatis repudiandae explicabo quas dolores esse
					nostrum laboriosam quasi voluptatum, accusamus quaerat iusto rerum.
					Sed nulla quibusdam ratione. Voluptate, perferendis ex magni in
					voluptatibus molestiae modi ratione quis ut expedita repellat,
					voluptatum omnis ipsum explicabo voluptates id quo at suscipit
					accusantium necessitatibus quibusdam! Natus, accusantium itaque
					quia repudiandae eum laboriosam, fugit ipsa ex nam sint
					consequuntur aspernatur accusamus?</p>

				<hr>

				<h2>HTML5 응용과 실습</h2>
				<p>2013년 02월 17일</p>
				<div class="img">
					<img alt="430x280" src="img/duck2.gif">
				</div>
				<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.
					Sunt impedit repellendus possimus beatae, voluptate officia autem
					ea, minima tempora in perferendis corporis nam similique? Delectus,
					ut commodi itaque amet nisi, nam aperiam ratione velit. Dolorem
					libero impedit provident odit pariatur magni deleniti labore
					beatae, sint ipsam quasi amet ratione tempora, rerum nisi animi
					obcaecati rem iste. Fugit exercitationem reprehenderit explicabo,
					id quibusdam sunt atque hic tenetur. Illum hic repellat saepe
					inventore odit laboriosam alias suscipit doloribus, voluptate
					quaerat atque vel, labore earum ad exercitationem, ipsum molestias
					deserunt quia eaque officiis. Sapiente et tenetur eius amet
					provident expedita repellendus deserunt enim optio quasi eos
					architecto ad numquam, maiores porro labore culpa beatae nostrum
					molestias quae, quibusdam earum incidunt. Facere dolores eaque non,
					animi, sequi magni aspernatur odio eius at iure fugit deleniti vel
					tempora voluptate itaque similique illo suscipit rem, repellendus
					facilis fugiat rerum placeat quos. Saepe explicabo debitis
					blanditiis consequuntur.</p>
				<hr>
			</div>
			<%@ include file="aside.jsp"%>
		</div>
		<%@ include file="footer.jsp"%>
	</div>
</body>
</html>