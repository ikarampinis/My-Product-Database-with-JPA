<%@ page import="java.util.*" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product page</title>
    </head>
    <body>
        <h1 align="center">Product Page</h1>
        
        <%
            List list = (List)request.getAttribute("characteristics");
            if(!list.isEmpty()){
                Iterator it = list.iterator();
                out.print("<br><center>barcode: "+it.next()+"</center>");
                out.print("<br><center>name: "+it.next()+"</center>");
                out.print("<br><center>color: "+it.next()+"</center>");
                out.print("<br><center>description: "+it.next()+"</center>");
            }
            else{
                out.print("<br><center>Error: The product already exists</center>");
            }
        %>
    </body>
</html>
