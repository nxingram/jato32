package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Default
 */
@WebServlet("/appuntamenti")
public class Appuntamenti extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Appuntamenti() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// chiamata DAOImpl che mi restituisce dei dati
		// passandoli ad un'altra jsp
		// appuntamenti.jsp
		
		// ti permette di scrivere un sacco di codice che dovri mettere dentro la pagina
		// jsp insieme all'html, e farei una gran confusione
		
		//List <Appuntamenti> daoImpl.findAll();
		// filtrarle x la data di oggi
		
		// passo i dati filtrati ad una jsp per visualizzarli
		
		
		response.getWriter().append("Default-doGet");
	}



}
