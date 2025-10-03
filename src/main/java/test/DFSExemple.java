package test;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Servlet implementation class DFSExemple
 */
@WebServlet("/DFSExemple")
public class DFSExemple extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DFSExemple() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#getServletConfig()
	 */
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @see Servlet#getServletInfo()
	 */
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null; 
	}
 
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
	    
	    try (PrintWriter pw = response.getWriter()) {
	    	
	        String stringConnection = "jdbc:mysql://localhost:3306/db_servlet?useSSL=false&serverTimezone=UTC";
	        String user = "root";
	        String password = "";

	        String query = "SELECT * FROM person";

	        try (Connection connexion = DriverManager.getConnection(stringConnection, user, password);
	             Statement statement = connexion.createStatement();
	             ResultSet resultSet = statement.executeQuery(query)) {

	            pw.println("<h2>Le contenu de la table Person</h2>");
	            pw.println("<table border = '1' style='width: 100%;'>");
	            pw.println("<tr style = 'background-color : yellow; padding : 5px'><th>Id</th><th>Nom</th><th>Prenom</th><th>DateNaissance</th><th>Moyenne</th></tr>");

	            while(resultSet.next()) {
	                int id = resultSet.getInt("id");
	                String name = resultSet.getString("Nom");
	                String prenom = resultSet.getString("Prenom");
	                Date dateNaissance = resultSet.getDate("DateNaissance");
	                double moyenne = resultSet.getDouble("Moyenne");

	                String row = """
	                	    <tr style='border:1px solid black; text-align :center'>
	                	        <td>%d</td>
	                	        <td>%s</td>
	                	        <td>%s</td>
	                	        <td>%s</td>
	                	        <td>%.2f</td>
	                	    </tr>
	                	    """.formatted(id, name, prenom, dateNaissance, moyenne);
	                
	                pw.println(row);
	            }

	            pw.println("</table>");

	        } catch (SQLException e) {
	            pw.println("<p>Erreur SQL : " + e.getMessage() + "</p>");
	            e.printStackTrace(pw);
	        }

	    }

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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
