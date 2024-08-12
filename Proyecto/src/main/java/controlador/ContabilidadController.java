package controlador;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ContabilidadController")//Permite que el servidor tomcat reconozca a esta clase como servlet
public class ContabilidadController extends HttpServlet {
	
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
			this.verDasboard(req, resp);
			break;
		}
		
		case "verMovimientos":{
			this.verMovimientos(req, resp);
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
	
	private void verDasboard(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//1. Obtener los parámetros
		//2. Hablar con el modelo
		//3. LLamar a la vista
		
		
	}
	
	private void verMovimientos(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1. Obtener los parámetros
		 //2. Hablar con el modelo
		 //3. LLamar a la vista
		
	}
	
	private void registrarIngreso(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1. Obtener los parámetros
		//2. Hablar con el modelo
		//3. LLamar a la vista
	 
	}
	
	private void verCuenta(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1. Obtener los parámetros
		//2. Hablar con el modelo
		//3. LLamar a la vista
	 
	}
	
	
	
	
	
	

}
