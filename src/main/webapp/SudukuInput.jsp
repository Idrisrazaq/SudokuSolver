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
	
	<div class="container">
	
		<h1>Sudoku Solver</h1>
		
		<p>Input the incomplete Sudoku puzzle:</p>
			
		<form action="GridInput" method="post">
		
			<table class="sudoku-grid">
				<% for(int i=0;i<9;i++){ %>
					<tr>
						<% for(int j=0;j<9;j++){ %>
							<td style="height: 60px;width: 30px; border: 2px solid black">
								<%String cellName="cell"+i+j; %>
								<input type="text" name="<%=cellName %>" maxlength="1">
							</td> 
						<%} %>
					</tr>
				<%} %>
			</table>
			<br>
			<button type="submit" value="SOLVE">SUBMIT</button>
			
		</form>
	</div>
	
</body>
</html>