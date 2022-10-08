package com.telusko;
import java.sql.*;
import java.util.*;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/Update")
public class Update extends HttpServlet 
{

public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
{
    HttpSession session=request.getSession();
                 String uname=(String)session.getAttribute("username");
                 if((uname==null))
                 {
                     response.sendRedirect("login.jsp");
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
String name=request.getParameter("t1");
String aadhar=request.getParameter("t2");
String dob=request.getParameter("t3");
PrintWriter out=response.getWriter();
 
try
			{
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/covid?user=root&password=root");
			PreparedStatement ps=con.prepareStatement("update user set Name=?, aadharno=?, dob=? where username=?");
			ps.setString(1,name);
                        ps.setString(2,aadhar);
                        ps.setString(3,dob);
                        ps.setString(4,username);
			int x=ps.executeUpdate();
                        if(x>0)
                        {
			response.sendRedirect("welcome.jsp");
			}
                        else
                        {
                          out.println(username);
                          out.println(name);
                        }
                        }
			catch(SQLException e)
			{
			System.out.println("Error in sql statement");
			}
			}

}    
	

