package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Jugador;
import logic.ControladorABMCJugador;
import utils.ApplicationException;

/**
 * Servlet implementation class ABMJugador
 */
@WebServlet("/ABMJugador")
public class ABMJugador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ABMJugador() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
		ControladorABMCJugador ctrl = new ControladorABMCJugador();
		if (request.getParameter("agregar")!=null)
		{
			Jugador j = MapearDeFormulario(request);
			
			try {
				ctrl.agregarJugador(j);
			} catch (ApplicationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.getRequestDispatcher("WebContent/jsp/ABMJugador.jsp").forward(request, response);
		}
	}
	public Jugador MapearDeFormulario(HttpServletRequest request) {
		String posicion = new String();
		Jugador j = new Jugador();
		j.setNombre(request.getParameter("nombre"));
		j.setApellido(request.getParameter("apellido"));
		posicion = request.getParameter("posicion");
		if(!posicion.isEmpty()){
			j.setPosicion(request.getParameter("posicion"));
		}
		//Aca tiene que haber una evaluacion del dropdown del equipo y si esta vacio estado = false
		//pero si esta con algun equipo estado = true
		j.setEstado(false);
		return j;
	}

}
