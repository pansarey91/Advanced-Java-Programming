<html>
<body>
<center><h1> Addition = 
<%
String s1 = request.getParameter(("t1"));
int a = Integer.parseInt(s1);

String s2 = request.getParameter(("t2"));
int b = Integer.parseInt(s2);

int c =a+b;
out.println(c);
%>

</center>
</body>
</html>