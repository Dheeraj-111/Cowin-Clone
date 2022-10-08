
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

@WebServlet("/updateHospi")
public class updateHospi extends HttpServlet {
    
    public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
{
    HttpSession session=request.getSession();
    
try
{
Class.forName("com.mysql.jdbc.Driver");
}
catch(Exception e)
{
System.out.println("Error in loading drivers");
}


String username = (String)session.getAttribute("username");
String Hmail = (String)session.getAttribute("Hmail");
String name = request.getParameter("Name");
String state = request.getParameter("State");
String district = request.getParameter("District");
//Integer dose = (Integer)session.getAttribute("dose");

 
PrintWriter out=response.getWriter();
out.println(name);
out.println(state);
out.println(district);
out.println(Hmail);

try
			{
                       
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/covid?user=root&password=root");
			PreparedStatement ps=con.prepareStatement("UPDATE hospital set Hname=? , Hstate=? , Hdistrict=? where Hmail=?");
			
                        ps.setString(1, name);
                        ps.setString(2, state);
                        ps.setString(3, district);
                        ps.setString(4, Hmail);
                        
                        int x = ps.executeUpdate();
			
                        if(x>0)
                        {
                            response.sendRedirect("hospiList.jsp");
                            session.setAttribute("username", username);
			}
                        else
                        {
                          out.println(username);
                          out.println(Hmail);
                        }
                        }
			catch(SQLException e)
			{
			out.println("Error in sql statement");
			}

}
}
