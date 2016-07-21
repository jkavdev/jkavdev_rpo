<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Spring MVC - Tiles Integration tutorial</title>
		<link rel="stylesheet" href="resources/css/main.css" type="text/css" media="print"></link>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" >
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" ></script>
	
	</head>
<body>
	<div class="container templates" style="min-height: 100%;">
		
		<div class="span-5 border" >
			<tiles:insertAttribute name="header" />
		</div>
		
		<div class="span-19 last">
			<tiles:insertAttribute name="body" />
		</div>
		
		<div class="footers">
			<hr />
			<p align="center">&copy; 2015 Livraria Spring Project, Inc.</p>
		</div>
<%-- 		<tiles:insertAttribute name="footer" /> --%>
	</div>
	
</body>
</html>