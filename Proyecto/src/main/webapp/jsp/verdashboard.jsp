<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard - Gestor de Gastos</title>
    <link rel="stylesheet" href="../styles.css">
    
</head>
<body>
    <header>
        <h1>Dashboard de Contabilidad</h1>
    </header>
    
    <main class="ver-dashboard">
        <section>
            <h4>Consolidado de Cuentas</h4>
            <table>
                <thead>
                    <tr>
                        <th>Cuenta</th>
                        <th>Saldo Total</th>
                        <th>Acción</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="cuenta" items="${cuentas}">
                        <tr>
                            <td>${cuenta.nombre}</td>
                            <td>${cuenta.total}</td>
                            <td>
                                <a href="ContabilidadController?ruta=verCuenta&cuentaId=${cuenta.id}&inicio=${inicio}&fin=${fin}">Ver Cuenta</a>|  
                                <a href="ContabilidadController?ruta=nuevoRegistro&cuentaId=${cuenta.id}">Crear Ingreso</a>       
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </section>

        <section>
        <!----
            <h4>Lista de Movimientos</h4>
            <table>
                <thead>
                    <tr>
                    	<th>id</th>
                        <th>Fecha</th>
                        <th>Concepto</th>
                        <th>Cuenta Origen</th>
                        <th>Cuenta Destino</th>
                        <th>Categoría</th>
                        <th>Valor</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="movimiento" items="${movimientos}">
                        <tr>
                            <td>${movimiento.fecha}</td>
                            <td>${movimiento.concepto}</td>
                            <td>${movimiento.cuentaOrigen}</td>
                            <td>${movimiento.cuentaDestino}</td>
                            <td>${movimiento.categoria}</td>
                            <td>${movimiento.valor}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>---->
        </section>
    </main>
    <footer>
        <p>&copy; 2024 Gestor de Gastos. Todos los derechos reservados.</p>
    </footer>
</body>
</html>