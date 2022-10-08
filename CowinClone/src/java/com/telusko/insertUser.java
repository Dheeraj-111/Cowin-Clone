
package com.telusko;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/insertUser")
public class insertUser extends HttpServlet{
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
 {
     try
     {
         Class.forName("com.mysql.jdbc.Driver");
     }
     catch(ClassNotFoundException e)
     {
         System.out.println("Error in loading drivers");
     }
 HttpSession session=request.getSession();
 String username = (String)session.getAttribute("username");
 session.setAttribute("username", username);
 
String name=request.getParameter("name");
String password=request.getParameter("password");
String username1=request.getParameter("username1");
String aadharno=request.getParameter("aadharno");
String conpass=request.getParameter("conpass");

String dob=null;
String Hname=null;
int dose=0;
int id=0;
Connection con=null;
PreparedStatement ps=null;
ResultSet rs = null;
        
try
{

con=DriverManager.getConnection("jdbc:mysql://localhost:3306/covid?user=root&password=root");
ps =con.prepareStatement("select * from user where username=?");
ps.setString(1,username);

rs = ps.executeQuery();
if(rs.next()==true)
{
request.setAttribute("message", " ");

RequestDispatcher rd = getServletContext().getRequestDispatcher("/insertUser.jsp");
rd.include(request, response);
}
else
{
if(password.equals(conpass))
{
try
{
ps=con.prepareStatement("insert into user values(?,?,?,?,?,null,null,0,null)");
ps.setString(1,name);
ps.setString(2,password);
ps.setString(3,username1);
ps.setString(4,aadharno);
ps.setString(5,conpass);
int x=ps.executeUpdate();
if(x!=0)
{
ps=con.prepareStatement("select * from user where username=?");
ps.setString(1,username1);
rs=ps.executeQuery();
if(rs.next()==true)
{
 dob=rs.getString("dob");
 Hname=rs.getString("Hname");
 dose=rs.getInt("dose");
 id=rs.getInt("User_ID");

}

response.sendRedirect("adminWelcome.jsp");
}
else
{
request.setAttribute("message", " ");

 RequestDispatcher rd = getServletContext().getRequestDispatcher("/adminLogin.jsp");
 rd.include(request, response);
}
}
catch(SQLException e)
{
System.out.println("error in SQL statement");
}
}
else
{
request.setAttribute("message", " ");

 RequestDispatcher rd = getServletContext().getRequestDispatcher("/adminLogin.jsp");
 rd.include(request, response);
}
}
}
catch(SQLException e)
{
System.out.println("Error in loading sql statements of user");
}   
}
}
