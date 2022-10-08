
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

@WebServlet("/updateUser")
public class updateUser extends HttpServlet {
    
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
String userid = (String)session.getAttribute("userid");
String name = request.getParameter("NAME");
String dob = request.getParameter("DOB");
String aadhar = request.getParameter("AADHAR");
//Integer dose = (Integer)session.getAttribute("dose");
 
PrintWriter out=response.getWriter();

try
			{
                       
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/covid?user=root&password=root");
			PreparedStatement ps=con.prepareStatement("UPDATE user set Name=? , dob=? , aadharno=? where username=?");
			
                        ps.setString(1, name);
                        ps.setString(2, dob);
                        ps.setString(3, aadhar);
                        ps.setString(4, userid);
                        
                        int x = ps.executeUpdate();
			
                        if(x>0)
                        {
                            response.sendRedirect("userList.jsp");
                            session.setAttribute("username", username);
			}
                        else
                        {
                          out.println(username);
                          out.println(userid);
                        }
                        }
			catch(SQLException e)
			{
			out.println("Error in sql statement");
			}

}
}
