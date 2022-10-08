
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

@WebServlet("/hospiUpdate")
public class hospiUpdate extends HttpServlet {
    
    public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
{
    HttpSession session=request.getSession();
                 String prevUsername=(String)session.getAttribute("prevUsername");
                 if((prevUsername==null))
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

String username=request.getParameter("username");
String Hname=request.getParameter("Hname");
String Hstate=request.getParameter("Hstate");
String Hdistrict = request.getParameter("Hdistrict");
int Hpin= Integer.parseInt(request.getParameter("Hpin"));

PrintWriter out=response.getWriter();
 
try
			{
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/covid?user=root&password=root");
			PreparedStatement ps=con.prepareStatement("update hospital set Hname=?, Hpin=?, Hstate=? , Hdistrict=?   where Hmail=?");
			ps.setString(1,Hname);
                        ps.setInt(2,Hpin);
                        ps.setString(3,Hstate);
                        ps.setString(4,Hdistrict);
                        
                        ps.setString(5,prevUsername);
			int x=ps.executeUpdate();
                        if(x>0)
                        {
			response.sendRedirect("hospiWelcome.jsp");
                        session.setAttribute("username", prevUsername);
			}
                        else
                        {
                          out.println(username);
                          out.println(Hname);
                        }
                        }
			catch(SQLException e)
			{
			System.out.println("Error in sql statement");
			}
			}
    
}
