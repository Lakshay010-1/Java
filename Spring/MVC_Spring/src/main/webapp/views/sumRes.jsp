<%@page language="java" %>
<html>
    <body>
        <%--Approach to pass the value between JSP(View Page) and Servlets(Controller)--%>
        <%-- 1. JSP Approach --%>
        <%-- <h2> Sum is : <%= session.getAttribute("addResult") %> </h2> --%>
        <%-- 2. JSTL Approach --%>
        <h2> Sum is : ${addResult} </h2>
    </body>
</html>