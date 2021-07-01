package presentation;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.LibroService;


@WebServlet("/libri")
public class LibroCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LibroService libroService;

    public LibroCtrl() {
        super();
        libroService = new LibroService();
    }

    // tomcat mi da la request con dentro i parametri (se ci sono, per esempio in un form)
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		

		// salvo i dati nell'oggetto request
		request.setAttribute("libri", libroService.getTitoli());
		
		// passo il controllo alla jsp, e gli passo i dati
		request.getRequestDispatcher("libri.jsp").forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
