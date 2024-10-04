<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Mis Registros</title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
        tr:nth-child(even) {
            background-color: #f9f9f9;
        }
    </style>
</head>
<body>
    <c:import url="opciones.jsp"/>
    <h2>Mis Registros</h2>

    <c:choose>
        <c:when test="${not empty sessionScope.registro.lstRegistros}">
            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nombre</th>
                        <th>Peso (g)</th>
                        <th>Fecha de Nacimiento</th>
                        <th>Prematuro</th>
                        <th>Sexo</th>
                        <th>Centro</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="registro" items="${sessionScope.registro.lstRegistros}">
                        <tr>
                            <td><c:out value="${registro.id}"/></td>
                            <td><c:out value="${registro.nombre}"/></td>
                            <td><c:out value="${registro.peso}"/></td>
                            <td><c:out value="${registro.fechaNacimiento}"/>
                            <td>
                                <c:choose>
                                    <c:when test="${registro.prematuro}">
                                        Sí
                                    </c:when>
                                    <c:otherwise>
                                        No
                                    </c:otherwise>
                                </c:choose>
                            </td>
                            <td>
                                <c:choose>
                                    <c:when test="${registro.sexo == 'M'}">
                                        Masculino
                                    </c:when>
                                    <c:otherwise>
                                        Femenino
                                    </c:otherwise>
                                </c:choose>
                            </td>
                            <td><c:out value="${registro.centro}"/></td>
                            <!-- Botón de eliminar -->
                            <td>
                                <form action="EliminarRegistroServlet" method="post">
                                    <input type="hidden" name="id" value="${registro.id}"/>
                                    <button type="submit" class="btn-eliminar">Eliminar</button>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:when>
        <c:otherwise>
            <p>No hay registros disponibles.</p>
        </c:otherwise>
    </c:choose>
</body>
</html>
