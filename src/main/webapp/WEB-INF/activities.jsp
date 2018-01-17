<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Index</title>
		<link rel="stylesheet" type="text/css" href="/css/style.css">	
		<script src="/js/main.js"></script>
	</head>

	<body>
	<div id="content">
		<p>Your gold: ${total}</p>
		<div id="places">
			<div id="farm">
				<h3>Farm</h3>
				<p>(earns 10-20 golds)</p>
				<form action="/process" method="post">
					<input type="hidden" name="building" value="farm" />
  					<input type="submit" value="Find Gold!"/>
				</form>
			</div>		
			<div id="cave">
				<h3>Cave</h3>
				<p>(earns 5-10 golds)</p>
				<form action="/process" method="post">
					<input type="hidden" name="building" value="cave" />
  					<input type="submit" value="Find Gold!"/>
				</form>
			</div>
			<div id="house">
				<h3>House</h3>
				<p>(earns 2-5 golds)</p>
				<form action="/process" method="post">
					<input type="hidden" name="building" value="house" />
  					<input type="submit" value="Find Gold!"/>
				</form>
			</div>
			<div id="casino">
				<h3>Casino</h3>
				<p>(earns/takes 0-50 golds)</p>
				<form action="/process" method="post">
					<input type="hidden" name="building" value="casino" />
  					<input type="submit" value="Find Gold!"/>
				</form>
			</div>			
		</div>
		<p>Activities:</p>
		<div id="activities">
			<c:forEach items="${messages}" var="loop">
    			<p style="color: ${loop.getColor()}">${loop.getText()}</p>
			</c:forEach>
		</div>
	<a href="/clear"><button>Clear Session</button></a>
	<br>
	</div>
</body>
</html>