<%@ page language="java" import="java.util.*" %>
<html><Head><Title>Ass4SetA1</Title></Head>
<body><H2> Welcome

<BR>1) Current Time is : 
<% out.print(new Date()); %>

<BR>2) Request User-Agent :
<%=request.getHeader("User-Agent") %>

<BR>3) <% response.addCookie(new Cookie("Class","TYBCS"));
		out.print("Cookie Added");%>

<BR>4) City init param value :
<%= config.getInitParameter("city") %>

<BR>5) State context param value :
<%=application.getInitParameter("state") %>

<BR>6) User Session Id : <%=session.getId() %>

<BR>7) Page Context attribute : 
<% pageContext.setAttribute("Test", "Test Value"); %>
<%=pageContext.getAttribute("Test") %>

<BR>8) Generated Servlet Name : 
Generated Servlet Name:<%=page.getClass().getName() %>

</H2></body> </html>
