<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ver Movimientos - Gestor de Gastos</title>
    <link rel="stylesheet" href="../styles.css">
    
</head>
<body>
    <header>
        <h1>Listado de Movimientos</h1>
    </header>

    <main>
        <section>
            <h4>Movimientos</h4>
            <table>
                <thead>
                    <tr>
                        <th>Fecha</th>
                        <th>Hora</th>
                        <th>Concepto</th>
                        <th>Cuenta Origen</th>
                        <th>Cuenta Destino</th>
                        <th>Categoría</th>
                        <th>Valor</th>
                    </tr>
                </thead>
                <tbody>
                    <!-- Aquí se mostrarán los movimientos del rango de fechas especificado -->
                </tbody>
            </table>
        </section>
        
        <br>
        <br>

        <section>
            <a href="verdashboard.jsp" class="button">Volver al dashboard</a>
        </section>
    </main>
    
    <footer>
        <p>&copy; 2024 Gestor de Gastos. Todos los derechos reservados.</p>
    </footer>
</body>
</html>
