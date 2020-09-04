<%-- 
    Document   : logout
    Created on : Sep 4, 2020, 4:54:27 PM
    Author     : Roshan Withanage
--%>

<%

    session.invalidate();
    response.sendRedirect("login.jsp");
%>
