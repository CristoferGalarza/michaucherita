<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registrar Ingreso - Gestor de Gastos</title>
    <link rel="stylesheet" href="../styles.css">
    
</head>
<body>
    <header>
        <h1>Registrar Ingreso</h1>
    </header>
    <main>
        <section>
            <h4>Datos del Movimiento</h4>
            <form method="POST" action="../ContabilidadController?ruta=registrarIngreso">
                <!-- Campo oculto para el ID de la cuenta -->
                <input type="hidden" id="cuentaId" name="cuentaId" value="${param.cuentaId}">
                <label for="concepto">Concepto:</label>
                <input type="text" id="concepto" name="concepto" placeholder="Ej. Pago de nómina" required>

                <label for="fecha">Fecha:</label>
                <input type="date" id="fecha" name="fecha" required>

                <label for="categoriaNombre">Categoría:</label>
                <select id="categoriaNombre" name="categoriaNombre" required>
                    <option value="">Selecciona una categoría</option>
                    <!-- Aquí se pueden agregar opciones dinámicamente -->
                    <option value="salario">Salario Mensual</option>
                    <option value="venta">Trabajo extra</option>
                    <option value="otro">Otro</option>
                </select>

                <label for="monto">Monto:</label>
                <input type="number" id="monto" name="monto" placeholder="Ej. 1000" step="0.01" required>
                
                <br><br>
                <button type="submit" class="button">Registrar Ingreso</button>
            </form>
        </section>
        
    </main>
    <footer>
        <p>&copy; 2024 Gestor de Gastos. Todos los derechos reservados.</p>
    </footer>
</body>
</html>
    