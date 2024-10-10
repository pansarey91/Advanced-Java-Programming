<%--
drop table Ass4SetB2;
create table Ass4SetB2
(
qno numeric(3) primary key,
ques varchar(100),
ansa varchar(100),
ansb varchar(100),
ansc varchar(100),
ansd varchar(100),
corr varchar(2),
flg numeric(1)
);

insert into Ass4SetB2 values(1,'What is 2+2','2','4','6','8','B',0);
insert into Ass4SetB2 values(2,'What is 3+2','5','7','9','11','A',0);
insert into Ass4SetB2 values(3,'What is 5+5','8','12','10','20','C',0);
insert into Ass4SetB2 values(4,'What is 12+2','12','14','16','18','B',0);
insert into Ass4SetB2 values(5,'What is 13+2','15','17','19','111','A',0);
insert into Ass4SetB2 values(6,'What is 15+5','18','12','10','20','D',0);

select * from Ass4SetB2;

update Ass4SetB2 set flg=0;

FLG=0 => NEW Ques
FLG=1 => Correct ANS
FLG=2 => Wrong ANS
--%>

<%@ page import="java.sql.*,java.util.*"%>
<html><body><H2>
<form action = "Ass4SetB2.jsp">
<%
	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;
	PreparedStatement prstm = null;
	int cnt=0,i=0;
	String sql;

	con = DriverManager.getConnection("jdbc:mysql:///ras","root","");
	stmt = con.createStatement();

	String ans = request.getParameter("ans");
	String qno = request.getParameter("txt1");
	String correctans = request.getParameter("txtans");
	if(ans != null)
	{
		if(ans.equals(correctans))
			sql = "update Ass4SetB2 set flg=1 where qno="+qno;
		else
			sql = "update Ass4SetB2 set flg=2 where qno="+qno;
		prstm = con.prepareStatement(sql);
        prstm.execute() ;
        prstm.close();
	}
	rs = stmt.executeQuery("select count(*) from Ass4SetB2 where flg=0");
	rs.next();
	cnt=rs.getInt(1);
	rs.close();

	if(cnt>0)
	{
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(cnt);
		if(randomInt==0)
			randomInt++;

		rs = stmt.executeQuery("select * from Ass4SetB2 where flg=0 order by qno");
		while (rs.next()) 
		{	
			i++;
			if(i==randomInt)
			{
			out.println("<input type=hidden name='txt1' value="+rs.getString(1)+"><br>");
			out.println(rs.getString(2)+"<br>");
			out.println("<input type=radio name='ans' value='A'>"+rs.getString(3)+"<br>");
			out.println("<input type=radio name='ans' value='B'>"+rs.getString(4)+"<br>");
			out.println("<input type=radio name='ans' value='C'>"+rs.getString(5)+"<br>");
			out.println("<input type=radio name='ans' value='D'>"+rs.getString(6)+"<br>");
			out.println("<input type=hidden name='txtans' value="+rs.getString(7)+"><br>");
			}
		}
	}
	else
		out.println("<h1>Test is Finished <BR> Click on Submit Button to get Result</h1>");	
	rs.close(); 
	con.close(); 
%>
<input type="submit" value="Next"/>
</form>

<form action = "Ass4SetB2Result.jsp">
<input type="submit" value="Submit"/>
</form>
</H2></body></html>
