package integration;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import entities.Alimento;
import service.AliementoServiceImpl;
import service.AlimentoService;


@WebServlet("/api/alimenti")
public class AlimentiREST extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private AlimentoService service = null;
	
 
    public AlimentiREST() {
        super();
        System.out.println("servlet costruita");
        this.service = new AliementoServiceImpl();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Vuoi ricevere tutti gli alimenti");
		
		List<Alimento> alimenti = this.service.findAll(); // prende dati dal server
		
		JSONArray json = new JSONArray(alimenti);// trasforma in json
		
		response.setContentType("application/json");// dice al browser che gli restituisce un tipo di dato json
		
		response.getWriter().append(json.toString()); // restituisce i dati
	}

}
