package ar.com.bijou.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Paths;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import ar.com.bijou.domain.Operacion;
import ar.com.bijou.domain.Revendedor;
import ar.com.bijou.services.OperacionManager;
import ar.com.bijou.util.Configuracion;

@WebServlet("/compras")
@MultipartConfig
public class Compras extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher;
		String accion = (String) request.getParameter("accion");
		if(accion==null||accion.equals("")){
		    request.setAttribute("accion", "realizarPedido");
		    HttpSession session = request.getSession();
		    session.setAttribute("revendedorNombre", (String) Configuracion.propiedades.get("defaultNombreRevendedor"));
		    session.setAttribute("revendedorEMail", (String) Configuracion.propiedades.get("defaultEMailRevendedor"));
		   // ServletContext application = getServletContext();
	
		    dispatcher = request.getRequestDispatcher("/WEB-INF/results/compras.jsp");
		}else{
			String anio = request.getParameter("anio");
			String mes = request.getParameter("mes");
			final Part filePart = request.getPart("file");
			String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
		    //InputStream in = filePart.getInputStream();
		    			
			//final PrintWriter writer = response.getWriter();

			final String path = (String) Configuracion.propiedades.get("pathArchivoPedidos");
			//prepararArchivo(filePart, path, fileName, writer);			
			prepararArchivo(filePart, path, fileName);
			HttpSession session = request.getSession();  
			Revendedor revendedor = new Revendedor((String)session.getAttribute("revendedorNombre"), (String)session.getAttribute("revendedorMail"));
			Operacion pedido = (new OperacionManager()).realizarPedido(path + File.separator + fileName, Integer.parseInt(anio), Integer.parseInt(mes), revendedor);
			//Operacion pedido = (new OperacionManager()).realizarPedido((String)Configuracion.propiedades.get("defaultPathPedidos"), Integer.parseInt(anio), Integer.parseInt(mes), revendedor);
			
			request.setAttribute("comprador", revendedor);
			request.setAttribute("vendedor", pedido.getVendedor());
			request.setAttribute("operacion", pedido);
			dispatcher = request.getRequestDispatcher("/WEB-INF/results/detalleOperacion.jsp");
		}
	    dispatcher.forward(request, response);
	  }

	private void prepararArchivo(final Part filePart, final String path, String fileName) throws IOException {
		OutputStream out = null;
		InputStream filecontent = null;
		try {
		    out = new FileOutputStream(new File(path + File.separator
		            + fileName));
		    filecontent = filePart.getInputStream();

		    int read = 0;
		    final byte[] bytes = new byte[1024];

		    while ((read = filecontent.read(bytes)) != -1) {
		        out.write(bytes, 0, read);
		    }
		} finally {
		    if (out != null) {
		        out.close();
		    }
		    if (filecontent != null) {
		        filecontent.close();
		    }
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
}
