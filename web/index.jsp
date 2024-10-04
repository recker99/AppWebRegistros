<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Registro Nacimientos</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }
        table {
            width: 100%;
            max-width: 600px;
            margin: 0 auto;
            border-collapse: collapse;
        }
        th, td {
            padding: 10px;
            border: 1px solid #ccc;
        }
        th {
            text-align: left;
        }
        .alert {
            color: red;
            font-weight: bold;
            text-align: center;
        }
        
         .alert ul {
            list-style-type: none;
            padding: 0;
        }
        .alert li {
            margin: 5px 0;
        }
         h2 {
            color: green;
            text-align: center;
        }
    </style>
</head>
<body>
    <c:import url="opciones.jsp"/>
    <c:url var="urlForm" value="/RegistroServlet"/>

    <form action="${urlForm}" method="post">
        <table>
            <tr>
                <th><label for="id">ID:</label></th>
                <td><input type="number" name="id" id="id"></td>
            </tr>
            <tr>
                <th><label for="nombre">Nombre:</label></th>
                <td><input type="text" name="nombre" id="nombre"></td>
            </tr>
            <tr>
                <th><label for="peso">Peso (en gramos):</label></th>
                <td><input type="number" name="peso" id="peso"></td>
            </tr>
            <tr>
                <th>¿Es prematuro?</th>
                <td>
                    <input type="radio" name="prematuro" id="prematuroSí" value="true">
                    <label for="prematuroSí">Sí</label>
                    <input type="radio" name="prematuro" id="prematuroNo" value="false">
                    <label for="prematuroNo">No</label>
                </td>
            </tr>
            <tr>
                <th>Sexo:</th>
                <td>
                    <input type="radio" name="sexo" id="sexoMasculino" value="M">
                    <label for="sexoMasculino">Masculino</label>
                    <input type="radio" name="sexo" id="sexoFemenino" value="F">
                    <label for="sexoFemenino">Femenino</label>
                </td>
            </tr>
            <tr>
                <th><label for="centro">Centro:</label></th>
                <td>
                    <select name="centro" id="centro">
                        <option value="">Seleccione un centro</option>
                        <option value="1">Centro 1</option>
                        <option value="2">Centro 2</option>
                        <option value="3">Centro 3</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="Registrar">
                </td>
            </tr>
        </table>
    </form>

    <c:if test="${not empty errores}">
        <div class="alert">
            <ul>
                <c:forEach var="error" items="${errores}">
                    <li><c:out value="${error}"/></li>
                </c:forEach>
            </ul>
        </div>
    </c:if>

    <c:if test="${not empty respuesta}">
        <h2><c:out value="${respuesta}"/></h2>
    </c:if>
</body>
</html>
