<%@page import="org.wpattern.frameworks.hibernate4.entites.CategoryEntity"%>
<%@page import="java.util.List"%>
<%@page import="org.wpattern.frameworks.hibernate4.daos.CategoryDAO"%>
<%@page import="org.wpattern.frameworks.hibernate4.utils.DAOFactory"%>
<html>
	<head>
		<script type="text/javascript" src="/resources/js/main.js" ></script>
		<link rel="shortcut icon" type="image/x-icon" href="/resources/imagens/wpattern.ico" />
		<link rel="stylesheet" type="text/css" href="/resources/css/main.css" />
		<title>WPattern Frameworks Hibernate4</title>
	</head>
	
	<body>
	
		<h1><% out.println("Categories"); %></h1>
		<a href="/category/add" >Add Category</a><br /><br />
		
		<table>
			<tr class="table_header">
				<td>ID</td>
				<td>Category Name</td>
				<td>Description</td>
				<td>Delete</td>
				<td>Edit</td>
			</tr>
			
			<%
			
				CategoryDAO categoryDAO = DAOFactory.categoryInstance();
				List<CategoryEntity> categories = categoryDAO.findAll();
				
				for(int i = 0; i < categories.size(); i++){ %>
					<tr>
						<td><%=categories.get(i).getId() %> </td>
						<td><%=categories.get(i).getCategoryName() %></td>
						<td><%=categories.get(i).getDescription() %></td>
						<td><%= String.format("<a href=\"/category/delete?id=%s\">Delete</a>", categories.get(i).getId()) %></td>
						<td><%= String.format("<a href=\"/category/edit?id=%s\">Edit</a>", categories.get(i).getId()) %></td>
					</tr>		
				<% } %>
			
		</table>
		
	</body>
	
</html>