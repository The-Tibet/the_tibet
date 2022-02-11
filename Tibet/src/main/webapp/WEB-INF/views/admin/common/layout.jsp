<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
request.setCharacterEncoding("UTF-8");
%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<link href="${contextPath}/resources/css/admin/style.css" rel="stylesheet" type="text/css">
<meta charset="UTF-8">
<title><tiles:insertAttribute name="title" /></title>
</head>
<body>
	<div>
		</div>
		<div>
			<tiles:insertAttribute name="header" />
		</div>
		<div>
			<tiles:insertAttribute name="side" />
		</div>
		<div>
			<tiles:insertAttribute name="body" />
		</div>
		<div>
		</div>
</body>
</html>