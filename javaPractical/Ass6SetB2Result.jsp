<%@ page import="java.sql.*"%>
<%
	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;
	PreparedStatement prstm = null;
	
	int cnt=0;
	con = DriverManager.getConnection("jdbc:mysql:///java_db","root","root");
	stmt = con.createStatement();
	rs = stmt.executeQuery("select count(*) from Ass4SetB2 where flg=1");
	rs.next();
	cnt=rs.getInt(1);
	out.println("<center><h1>Correct Answer = "+cnt+"</h1></center>");	
	rs.close();
	
	rs = stmt.executeQuery("select count(*) from Ass4SetB2 where flg=2");
	rs.next();
	cnt=rs.getInt(1);
	out.println("<center><h1>Wrong Answer = "+cnt+"</h1></center>");	
	rs.close();
	
	prstm = con.prepareStatement("update Ass4SetB2 set flg=0");
	prstm.execute() ;
	prstm.close();
	con.close(); 
%>

<html>
	<body>
		<form action = "Ass6SetB2.jsp">
			<center>
				<input type="submit" value="Start Quiz Again"/>
			</center>
			
		</form>
	</body>
</html>	