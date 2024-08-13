package controlador;

import modelo.entidades.Cuenta;
import modelo.entidades.Movimiento;
import modelo.entidades.Categoria;
import modelo.entidades.CategoriaIngreso;
import modelo.dao.CuentaDAO;
import modelo.dao.MovimientoDAO;
import modelo.dao.IngresoDAO;
import modelo.dao.CategoriaDAO;
import modelo.dao.CategoriaIngresoDAO;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ContabilidadController")//Permite que el servidor tomcat reconozca a esta clase como servlet
public class ContabilidadController extends HttpServlet {
	//HAY ERRORES PORQUE NO ESTÁN IMPLEMENTADOS LOS MODELOS
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.ruteador(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.ruteador(req, resp);
	}

	
	//RUTEADOR
	
	private void ruteador(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		String ruta = (req.getParameter("ruta")!=null)? "verDashboard": req.getParameter("ruta");
		
		switch(ruta) {
		case "verDashboard":{
			this.verDashboard(req, resp);
			break;
		}
		
		case "nuevoRegistro":{
			this.nuevoRegistro(req, resp);
			break;
		}
		
		case "registrarIngreso":{
			this.registrarIngreso(req, resp);
			break;
		}
		
		case "verCuenta":{
			this.verCuenta(req, resp);
			break;
		}
		
		}
	}
	
	private void nuevoRegistro(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1. Obtener los parámetros
	    String cuentaId = req.getParameter("cuentaId");
	    
	    // 2. Hablar con el modelo
	    
	    // 3. Llamar a la vista
	    req.setAttribute("cuentaId", cuentaId);
	    req.getRequestDispatcher("jsp/registrarIngreso.jsp").forward(req, resp);
	}


	private void verDashboard(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 // 1. Obtener los parámetros
	    Date inicio = parseDate(req.getParameter("inicio"));
	    Date fin = parseDate(req.getParameter("fin"));
	    
	    // Si el usuario no proporciona fechas, se utilizan las fechas por defecto
	    if (inicio == null || fin == null) {
	        // Obtener la fecha actual
	        long currentTimeMillis = System.currentTimeMillis();
	        Date currentDate = new Date(currentTimeMillis);

	        // Establecer la fecha de inicio al primer día del mes actual
	        String currentMonthStart = currentDate.toString().substring(0, 8) + "01"; // Formato yyyy-MM-01
	        inicio = Date.valueOf(currentMonthStart);

	        // Establecer la fecha de fin al día actual
	        fin = currentDate;
	    }

	    // 2. Hablar con el modelo
	    List<Cuenta> cuentas = CuentaDAO.getAll(); // Obtener todas las cuentas
	    List<Movimiento> movimientos = MovimientoDAO.getAllSumarized(inicio, fin); // Obtener los movimientos en el rango de fechas

	    // 3. Llamar a la vista
	    req.setAttribute("cuentas", cuentas);
	    req.setAttribute("movimientos", movimientos);
	    req.setAttribute("inicio", inicio); 
	    req.setAttribute("fin", fin);
	    req.getRequestDispatcher("jsp/verdashboard.jsp").forward(req, resp); 
	}

	private void registrarIngreso(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    // 1. Obtener los parámetros
	    int cuentaId = Integer.parseInt(req.getParameter("cuentaId"));
	    String concepto = req.getParameter("concepto");
	    Date fecha = parseDate(req.getParameter("fecha"));
	    String categoriaNombre = req.getParameter("categoria");
	    double monto = Double.parseDouble(req.getParameter("monto"));

	    // 2. Hablar con el modelo
	    CategoriaIngreso categoria = CategoriaIngresoDAO.getCategoriaByName(categoriaNombre); // Obtener la categoría 
	    IngresoDAO.agregarIngreso(cuentaId, concepto, fecha, categoria, monto);
	    CuentaDAO.actualizarTotal(cuentaId, monto);

	    //3. LLamar a la vista
	    resp.sendRedirect("ContabilidadController?ruta=verCuenta&cuentaId=" + cuentaId);
	}

	
	private void verCuenta(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    // 1. Obtener los parámetros
	    int cuentaId = Integer.parseInt(req.getParameter("cuentaId"));
	    Date inicio = parseDate(req.getParameter("inicio"));
	    Date fin = parseDate(req.getParameter("fin"));
	    
	    // 2. Hablar con el modelo 
	    Cuenta cuenta = CuentaDAO.getCuenta(cuentaId); // Obtener la cuenta
	    List<Movimiento> movimientos = MovimientoDAO.getMovimientosCuenta(cuentaId, inicio, fin); //obtener lo movs de la cuenta
	    
	    //3. LLamar a la vista
	    req.setAttribute("cuenta", cuenta); // Pasar la cuenta a la vista
	    req.setAttribute("movimientos", movimientos); // Pasar los movimientos a la vista
	    req.setAttribute("inicio", inicio); 
	    req.setAttribute("fin", fin);
	    req.getRequestDispatcher("jsp/vercuenta.jsp").forward(req, resp);
	}
	
	private Date parseDate(String dateStr) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	    try {
	        java.util.Date utilDate = formatter.parse(dateStr); // Parse to java.util.Date
	        return new java.sql.Date(utilDate.getTime()); // Convert to java.sql.Date
	    } catch (ParseException e) {
	        e.printStackTrace();
	        return null;
	    }

	}
	

	
	
	
	
	
	

}
