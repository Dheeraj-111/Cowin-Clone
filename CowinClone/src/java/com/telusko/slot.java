package com.telusko;
import java.sql.*;
import java.util.*;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/slot")
public class slot extends HttpServlet {
	

public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
{
    
try
{
Class.forName("com.mysql.jdbc.Driver");
}
catch(Exception e)
{
System.out.println("Error in loading drivers");
}
HttpSession session = request.getSession();
String user=(String)session.getAttribute("username");
                 if(user==null)
                 {
                     response.sendRedirect("login.jsp");
                 }
                       String search = request.getParameter("search"); 
                       
                       
                       
                       String item=null;
                       session.setAttribute("search",search);
                       if(search.equals("dist"))
			{
                        item=request.getParameter("district"); 
                        
                       
                        
			try
			{
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/covid?user=root&password=root");
			PreparedStatement ps=con.prepareStatement("select * from hospital where Hdistrict=?");
			ps.setString(1,item);
			ResultSet rs=ps.executeQuery();
                        
			}
			catch(SQLException e)
			{
			System.out.println("Error in sql statement");
			}
			}
                       
                       if(search.equals("pin"))
			{
                        item=request.getParameter("pincode"); 
                        
                        
                        int item1=Integer.parseInt(item);
			try
			{
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/covid?user=root&password=root");
			PreparedStatement ps=con.prepareStatement("select * from hospital where Hpin=?");
			ps.setInt(1,item1);
			ResultSet rs=ps.executeQuery();
                        while(rs.next()==true)
                        {
                           item= rs.getString("Hdistrict");
                        }
			}
			catch(SQLException e)
			{
			System.out.println("Error in sql statement");
			}
			}
                        

session.setAttribute("item",item);

response.sendRedirect("slot.jsp");
}
}