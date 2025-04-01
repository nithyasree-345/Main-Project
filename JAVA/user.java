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

import servelet.UserConnect;
/**
 * Servlet implementation class user
 */
@WebServlet("/user")
public class user extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public user() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		System.out.println("Haai");
		
		PrintWriter pw=response.getWriter();
		response.setContentType("text/html");
		String a=request.getParameter("name");
		String b=request.getParameter("username");
		String c=request.getParameter("email");
		String d=request.getParameter("phone");
		String e=request.getParameter("pass");
		String p=request.getParameter("cpass");
		String f=request.getParameter("gender");
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
		System.out.println(e);
		System.out.println(p);
		System.out.println(f);	
		
		
		
		try
		{
          String query="insert into `user`(`Fullname`,`UserName`,`email`,`Phone`,`password`,`cpassword`,`gender`)values(?,?,?,?,?,?,?)";
          PreparedStatement ps=UserConnect.getConnection().prepareStatement(query);
          ps.setString(1,a);
          ps.setString(2,b);
          ps.setString(3,c);
          ps.setString(4,d);
          ps.setString(5,e);
          ps.setString(6,p);
          ps.setString(7,f);
          if(ps.executeUpdate()>0)
          {
        	 
        	  RequestDispatcher rd=request.getRequestDispatcher("Login.html");
        	  rd.include(request,response);
        	  
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
