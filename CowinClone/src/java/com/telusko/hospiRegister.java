

package com.telusko;

import java.io.IOException;
import java.io.PrintWriter;
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

@WebServlet("/hospiRegister")
public class hospiRegister extends HttpServlet {
    
    
    @Override
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

 
String Hname=request.getParameter("name");
String password=request.getParameter("password");
String username1=request.getParameter("username1");
int Hpin = Integer.parseInt(request.getParameter("pin"));
String conpass=request.getParameter("conpass");
String Hstate = request.getParameter("state");
String Hdistrict = request.getParameter("district");


Connection con=null;
PreparedStatement ps=null;
ResultSet rs = null;
        
try
{
con=DriverManager.getConnection("jdbc:mysql://localhost:3306/covid?user=root&password=root");
ps =con.prepareStatement("select * from hospital where Hmail=?");
ps.setString(1,username1);

rs = ps.executeQuery();
if(rs.next()==true)
{
request.setAttribute("message", " ");

RequestDispatcher rd = getServletContext().getRequestDispatcher("/hospiLogin.jsp");
rd.include(request, response);
}
else

{
if(password.equals(conpass))
{
try
{
ps=con.prepareStatement("insert into hospital values(?,?,?,?,?,?,0)");
ps.setString(1,Hname);
ps.setInt(2,Hpin);
ps.setString(3,Hstate);
ps.setString(4, Hdistrict);
ps.setString(5,username1);
ps.setString(6,password);

int x=ps.executeUpdate();
if(x!=0)
{

     HttpSession session=request.getSession();
     session.setAttribute("username", username1);
     response.sendRedirect("hospiWelcome.jsp");



}
else
{
request.setAttribute("message", " ");

 RequestDispatcher rd = getServletContext().getRequestDispatcher("/hospiLogin.jsp");
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

 RequestDispatcher rd = getServletContext().getRequestDispatcher("/hospiLogin.jsp");
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
