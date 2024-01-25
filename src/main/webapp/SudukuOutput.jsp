<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
	
	<% 	int[][] m =(int[][])request.getAttribute("matrix"); %>
	
	<div class="container">
		<h2>The Suduku is Solved</h2><br>
		<table class="sudoku-grid">
			<% for(int i=0;i<9;i++){ %>
				<tr>
					<% for(int j=0;j<9;j++){ %>
						<td style="height: 60px;width: 30px; border: 2px solid black; font-size: 25px">
							<%=m[i][j] %>
						</td> 
					<%} %>
				</tr>
			<%} %>
		</table>
		<h2><a href="index.jsp">Back to Main Page</a></h2>
		<h2><a href="SudukuInput.jsp">Back to Sudoku Input Page</a></h2>	
	</div>
	
</body>
</html>