<%@page import="java.io.File"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html lang="ko">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title></title>
		<script type="text/javascript"></script>
	</head>

	<body>	
	<%
		String saveDir = application.getRealPath("Image");
		int maxSize = 1024*1024*100;
		String encType = "UTF-8";
		MultipartRequest multipartRequest = new MultipartRequest(request, saveDir, maxSize, encType, new DefaultFileRenamePolicy());
		String img = "/0920HW/Image/" + multipartRequest.getFilesystemName("image");
		File file = multipartRequest.getFile("image");
	%>
	<jsp:forward page="Product?action=create">
		<jsp:param value='<%=img%>' name='image'/>
		<jsp:param value='<%=multipartRequest.getParameter("name")%>' name='name'/>
		<jsp:param value='<%=multipartRequest.getParameter("price")%>' name='price'/>
		<jsp:param value='<%=multipartRequest.getParameter("quantity")%>' name='quantity'/>
	</jsp:forward>
	</body>
</html>

<!--
	파일업로드의 경우 바로 파라미터를 전송할경우 null이 되기 때문에 다음과 같이 한번 거쳐서 전송되게 구현했습니다.
	jsp:forward로 자동으로 넘어가게 하였기 때문에 사용자는 이페이지를 볼 수 없습니다.
 -->