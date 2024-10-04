<%-- 
    Document   : opciones
    Created on : 30-09-2024, 17:54:23
    Author     : ivanb
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
    <p>
        Opciones:
        <a href="<c:url value='/index.jsp' />" style="margin-right: 15px;">Agregar Registro</a>
        <a href="<c:url value='/listar_session.jsp' />" style="margin-right: 15px;">Listar Registros</a>
        <a href="<c:url value='/listar_application.jsp' />">Listar Todos los Registros</a>
    </p>

    <hr/>
    