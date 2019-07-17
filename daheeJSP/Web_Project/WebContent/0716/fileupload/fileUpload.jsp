<%@page import="java.io.File"%>
<%@page import="java.util.Iterator"%>
<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	
	String name = "";//이름
	String sNum = "";//학번
	String fileName = "";//사용자가 입력한 파일을 받아와서 처리
	String saveFileName = "";
	long fileSize = 0;
	String uploadPath = "/0716/upload";//파일이 저장될 파일명
	String dir = request.getSession().getServletContext().getRealPath(uploadPath);
	
	//FileItem 을 사용하기 위한 공식
	//isMultipartContent 여부를 확인
	boolean inMultipart = ServletFileUpload.isMultipartContent(request);

	DiskFileItemFactory factory = new DiskFileItemFactory();
	
	ServletFileUpload upload = new ServletFileUpload(factory);
	
	//FileItem 을 통해 사용자가 업로드한(전송한) 데이터들을 가져온다. uName,sNumber,report 를 fileItem에 담아 꺼낼수있다.
	List<FileItem> items = upload.parseRequest(request);
	
	//컬렉션 클래스 안에 존재하는 인터페이스 타입
	//List를 줄세워서 데이터 정리(hasNext()를 사용할 수 있음)
	Iterator<FileItem> itr = items.iterator();
	
	
	
	while(itr.hasNext()) {
		//naxt()를 통해 object를 가져옴
		FileItem item = itr.next();
		
		//isFormField() : input타입이 file인지 아닌지 구분하기위한 메소드
		if(item.isFormField()) {
			//input 타입이 file이 아닌경우
			
			//가져온 데이터들 중에서 Iterator를 통해 어떻게 정렬되었는지 몰라서 확인하기 위한것
			if(item.getFieldName().equals("uName")){
				//파라미터 필드이름이 uName이라면 item이 가지고 있는 value값을 name넣음
				name = item.getString("utf-8");
			}
			
			if(item.getFieldName().equals("sNumber")) {
				sNum = item.getString("utf-8");
			}
			
		}else {
			//input 타입이 file인 경우
			if(item.getFieldName().equals("report")) {
				fileName = item.getName();
				fileSize = item.getSize();
				
				//중복되 파일명을 막기 위함
				//밀리초
				//saveFileName = System.currentTimeMillis()+"_"+fileName;
				//나노초 (기준이 서버의 기준시간을 나노초로 나눠서 가져옴(밀리초보다 낮은단위라 중복X))
				saveFileName = System.nanoTime()+"_"+fileName;
				//write : 파일저장할 때 사용 (절대경로를 구해서 넣어야함);
				item.write(new File(dir, saveFileName));
			}
		}
	}
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>

</style>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
</head>
<body>
	<h1>
		이름 : <%= name %><br>
		학번 : <%= sNum %><br>
		레포트 파일명 : <%= fileName %>(<%= fileSize %>)<br>
		저장 파일 이름 : <%= saveFileName %><br>
		저장경로 : <%= dir %>
	</h1>
</body>
</html>