package integration;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import service.LibroService;


@WebServlet("/api/libri")
public class LibroRESTCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LibroService libroService;
       
    public LibroRESTCtrl() {
        super();
        libroService = new LibroService();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		// tipo di dato che restituisco
		response.setContentType("application/json");
		
		// traformo i dati in formato json
		JSONArray json = new JSONArray();
		for (String titolo : libroService.getTitoli()) {
			JSONObject t = new JSONObject();
			t.put("titolo", titolo);
			json.put(t);
		}
		
		// restituisco i dati a javascript
		response.getWriter().append(json.toString());
	
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
