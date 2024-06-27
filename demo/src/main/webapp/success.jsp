<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import= "java.util.List"
     %>
     <%@ page import="com.chainsys.demo.model.Registration"%>
     
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Registered</h1>

		<form action="/search" method="post">
		<input type="text" name="search">
		<input type="submit" >
		</form>

<table>
        <tr>
            <th>Name</th>
            <th>Mail</th>
            <th>Password</th>

            <th></th>
            
        </tr>
        <%
        List<Registration> list = (List<Registration>) request.getAttribute("view");
        for(Registration values:list){
                
        %>

        <tr>
            <td><%=values.getName()%></td>
            <td><%=values.getMail()%></td>
            <td><%=values.getPassword()%></td>
       <%--      <td><%=values.getRepassword()%></td> --%>
             <td><form action="update.jsp">
            <input type="submit" value="update">
            <input type="hidden" name="update" value="<%=values.getName()%>">
            </form></td>
            <td><form action="/delete">
            <input type="submit" value="delete">
            <input type="hidden" name="delete" value="<%=values.getName()%>">
            </form></td>
            
            
            
            <%} %>
            </tr>
            </table>
            
		


</body>
</html>