<%-- 
    Document   : listar_application
    Created on : 03-10-2024, 23:12:39
    Author     : ivanb
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registros</title>
    </head>
    <body>
        <c:import url="opciones.jsp"/>
        <h2>Todos los registros</h2>
        <c:if test="${not empty applicationScope.registro.lstRegistros}">
            <ul>
                <c:forEach var="msg" items="${applicationScope.registro.lstRegistros}">
                    <li>

                        <c:out value="${msg.texto}"/>:
                        <fmt:formatDate value="${msg.fecha}" pattern="dd/MM/yy HH:mm:ss"/>
                    </li>
                </c:forEach>
            </ul> 
        </c:if>
    </body>
</html>
