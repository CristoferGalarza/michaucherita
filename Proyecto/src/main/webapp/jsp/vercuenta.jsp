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
            <p><strong>Nombre de la Cuenta:</strong> <!-- Aquí se mostrará el nombre de la cuenta dinámica --></p>
            <p><strong>Saldo Total:</strong> <!-- Aquí se mostrará el saldo total de la cuenta --></p>
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
                    <!-- Aquí se mostrarán los movimientos dinámicos -->
                </tbody>
            </table>
        </section>

       <section>
		    <h4>Acciones</h4>
		    <a href="registraringreso.jsp" class="button">Registrar Ingreso</a>
		    <a href="vermovimientos.jsp" class="button">Ver movimientos</a>
		    <a href="verdashboard.jsp" class="button">Volver al dashboard</a>
		    <!-- Aquí se pueden agregar más enlaces para otras acciones si es necesario -->
		</section>
       
    </main>
    <footer>
        <p>&copy; 2024 Gestor de Gastos. Todos los derechos reservados.</p>
    </footer>
</body>
</html>
    