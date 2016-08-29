package ar.com.bijou.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ar.com.bijou.domain.Cliente;
import ar.com.bijou.domain.Comprador;
import ar.com.bijou.domain.Operacion;
import ar.com.bijou.domain.Revendedor;
import ar.com.bijou.services.OperacionManager;
import ar.com.bijou.util.Configuracion;

@WebServlet("/ventas")
@MultipartConfig
public class Ventas extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher;
		String accion = (String) request.getParameter("accion");
		if(accion==null||accion.equals("")){
		    request.setAttribute("accion", "realizarVenta");
		    HttpSession session = request.getSession();
		    Revendedor revendedor = new Revendedor((String)Configuracion.propiedades.get("defaultNombreRevendedor"), (String)Configuracion.propiedades.get("defaultEMailRevendedor"));
		    session.setAttribute("revendedor", revendedor);
		   // ServletContext application = getServletContext();
	
		     dispatcher = request.getRequestDispatcher("/WEB-INF/results/ventas.jsp");
		    
		}else{
			Comprador comprador = new Cliente(request.getParameter("clienteNombre"), request.getParameter("clienteEMail"));
			String catalogo = request.getParameter("catalogo");
			Comprador revendedor = new Revendedor(request.getParameter("revendedorNombre"), request.getParameter("revendedorEMail"));
			Operacion pedido = (new OperacionManager()).realizarPedido((String)Configuracion.propiedades.get("defaultPathPedidos"), catalogo, revendedor);
			request.setAttribute("vendedor", revendedor);
			request.setAttribute("comprador", comprador);
			request.setAttribute("catalogo", pedido);
			dispatcher = request.getRequestDispatcher("/WEB-INF/results/detalleVenta.jsp");
		}
		dispatcher.forward(request, response);
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}


}
