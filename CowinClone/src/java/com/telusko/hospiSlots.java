
package com.telusko;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/hospiSlots")
public class hospiSlots extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
{
    
    PrintWriter out = response.getWriter();
    HttpSession session=request.getSession();
                 String username=(String)session.getAttribute("username");
                 if((username==null))
                 {
                     response.sendRedirect("hospiLogin.jsp");
                 }
try
{
Class.forName("com.mysql.jdbc.Driver");
}
catch(Exception e)
{
System.out.println("Error in loading drivers");
}

int Hslots= Integer.parseInt(request.getParameter("updatedSlots"));

 
try
			{
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/covid?user=root&password=root");
			PreparedStatement ps=con.prepareStatement("update hospital set Hslots=? where Hmail=?");
			ps.setInt(1,Hslots);
                        ps.setString(2,username);
                        
			int x=ps.executeUpdate();
                        
                        if(x>0)
                        {
			response.sendRedirect("hospiWelcome.jsp");
                        session.setAttribute("username", username);
			}
                        else
                        {
                          out.println(username);
                          
                        }
                        }
			catch(SQLException e)
			{
			System.out.println("Error in sql statement");
			}
			}

}
    

