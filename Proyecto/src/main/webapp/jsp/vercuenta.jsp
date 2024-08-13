<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ver Cuenta - Gestor de Gastos</title>
    <link rel="stylesheet" href="../styles.css">
    
</head>
<body>
    <header>
        <h1>Detalles de la Cuenta</h1>
    </header>
    <main>
        <section>
		    <h4>Información de la Cuenta</h4>
		    <p><strong>Nombre de la Cuenta:</strong> ${cuenta.nombre}</p> <!-- Muestra el nombre de la cuenta -->
		    <p><strong>Saldo Total:</strong> ${cuenta.total}</p> <!-- Muestra el total -->
		</section>
        

        <section>
		    <h4>Movimientos de la Cuenta</h4>
		    <table>
		        <thead>
		            <tr>
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
		    </table>
	</section>
        

       <section>
		    <h4>Acciones</h4>
		    <a href="../ContabilidadController?ruta=nuevoRegistro&cuentaId=${cuenta.id}">Registrar Ingreso</a>
		    <a href="../ContabilidadController?ruta=verDashboard&inicio=${inicio}&fin=${fin}">Volver al dashboard</a>
		</section>
       
    </main>
    <footer>
        <p>&copy; 2024 Gestor de Gastos. Todos los derechos reservados.</p>
    </footer>
</body>
</html>
    