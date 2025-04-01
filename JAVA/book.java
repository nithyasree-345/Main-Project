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
 * Servlet implementation class book
 */
@WebServlet("/book")
public class book extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public book() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

		System.out.println("haai");
		PrintWriter pw=response.getWriter(); response.setContentType("text/html");
		  String a=request.getParameter("name"); String
		  b=request.getParameter("email"); String c=request.getParameter("product");
		  String d=request.getParameter("rental_start"); String
		  e=request.getParameter("rental_end"); String
		  p=request.getParameter("rent_per_day"); String
		  f=request.getParameter("total_days"); String
		  g=request.getParameter("total_cost"); System.out.println(a);
		  System.out.println(b); System.out.println(c); System.out.println(d);
		  System.out.println(e); System.out.println(p); System.out.println(f);
		  System.out.println(g);
		  
		  
		 
		  try { String
		  query="insert into `book`(`name`,`email`,`product`,`sdate`,`edate`,`pday`,`tday`,`tcost`)values(?,?,?,?,?,?,?,?)";
		   PreparedStatement ps=UserConnect.getConnection().prepareStatement(query);
		   ps.setString(1,a); ps.setString(2,b); ps.setString(3,c); ps.setString(4,d);
		   ps.setString(5,e); ps.setString(6,p); ps.setString(7,f); ps.setString(8,g);
		  
		   if(ps.executeUpdate()>0) 
		  {		  
		  RequestDispatcher rd=request.getRequestDispatcher("cart.html");
		  rd.forward(request,response); 
		  System.out.print("Cart Added");
		  } 
		  
		  } 
		  catch(Exception ex) 
		  {
		  System.out.println(ex);
		  
		 }
		 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

	}

}
