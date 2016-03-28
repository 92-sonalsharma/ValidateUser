import java.io.IOException;  
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
  
  
@SuppressWarnings("serial")
public class Validate extends HttpServlet {  
public void doPost(HttpServletRequest request, HttpServletResponse response)  
        throws ServletException, IOException {  
  
    response.setContentType("text/html");  
    PrintWriter out = response.getWriter(); 
 
    String user=request.getParameter("first_name");      
    String userId=request.getParameter("username");  
    String userPwd=request.getParameter("pwd");  

    if(user !="" && userId != "" && userPwd != "")
	{
        RequestDispatcher rd = request.getRequestDispatcher("Welcome"); // redirects to success page
        rd.forward(request, response);
	}
    else
	{
        out.println("<h1><font color=Red><b>Please fill in all required fields !<b></font></h1>");
        RequestDispatcher rd = request.getRequestDispatcher("index.html");  // reloads form page again in case of invalid details
        rd.include(request, response);
        }
	out.close();
     }

}