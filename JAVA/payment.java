package servelet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;

/**
 * Servlet implementation class payment
 */
@WebServlet("/payment")
public class payment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public payment() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		System.out.println("haai");
		PrintWriter pw=response.getWriter(); response.setContentType("text/html");
		  String a=request.getParameter("name"); 
		  String b=request.getParameter("email"); 
		  String c=request.getParameter("address");
		  String d=request.getParameter("city"); 	  
		  String e=request.getParameter("state"); 
		  String p=request.getParameter("zip"); 
		  String f=request.getParameter("cardname"); 
		  String g=request.getParameter("creditnum"); 
		  String h=request.getParameter("expmonth");
		  String i=request.getParameter("expyear");
		  String j=request.getParameter("cvv");
		  System.out.println(a);
		  System.out.println(b); 
		  System.out.println(c); 
		  System.out.println(d);
		  System.out.println(e); 
		  System.out.println(p); 
		  System.out.println(f);
		  System.out.println(g);
		  System.out.println(h);
		  System.out.println(i);
		  System.out.println(j);
		  
		  
		 
		  try { String
		  query="insert into `payment`(`name`,`email`,`address`,`city`,`state`,`zip`,`ncard`,`ccnum`,`emon`,`eyear`,`cvv`)values(?,?,?,?,?,?,?,?,?,?,?)";
		   PreparedStatement ps=UserConnect.getConnection().prepareStatement(query);
		   ps.setString(1,a); 
		   ps.setString(2,b); 
		   ps.setString(3,c); 
		   ps.setString(4,d);
		   ps.setString(5,e); 
		   ps.setString(6,p); 
		   ps.setString(7,f); 
		   ps.setString(8,g);
		   ps.setString(9,h);
		   ps.setString(10, i);
		   ps.setString(11, j);
		  
		   if(ps.executeUpdate()>0) 
		  {		  
		  RequestDispatcher rd=request.getRequestDispatcher("paymentpopup.html");
		  rd.forward(request,response); 
		  System.out.print("Payment Successfull");
		  } 
		  
		  } 
		  catch(Exception ex) 
		  {
		  System.out.println(ex);
		  
		 }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
