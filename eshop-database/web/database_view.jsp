<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>DATABASE</title>
    </head>
    <body>
        <h1 align="center">My Database</h1>
        <%
            List list = (List)request.getAttribute("productlist");
            Iterator it = list.iterator();
            int counter=0;
            out.print("<center>");
            while(it.hasNext()){
                counter++;
                out.print("<br>"+counter+". "+it.next()+"<br>");
            }
            out.print("</center>");
        %>
    </body>
</html>
