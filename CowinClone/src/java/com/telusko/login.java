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

@WebServlet("/login")
public class login extends HttpServlet
{
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
     PrintWriter out=response.getWriter();
     String uname=request.getParameter("uname");
     String pass=request.getParameter("pass");
     String dob=null;
     String Hname=null;
     int dose=0;
     int id=0;
     String name=null;
     String aadharno=null;
     try
     {
             Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/covid?user=root&password=root");
             PreparedStatement ps = con.prepareStatement("select * from user where username=? and password=?");
             ps.setString(1, uname);
             ps.setString(2, pass);
             ResultSet rs=ps.executeQuery();
             if(rs.next()==true)
             {
                 ps=con.prepareStatement("select * from user where username=?");
                 ps.setString(1,uname);
                 rs=ps.executeQuery();
                 if(rs.next()==true)
                 {
                 name=rs.getString("Name");
                 aadharno=rs.getString("aadharno");
                 dob=rs.getString("dob");
                 Hname=rs.getString("Hname");
                 dose=rs.getInt("dose");
                 id=rs.getInt("User_ID");
                 }
                 HttpSession session=request.getSession();
                 session.setAttribute("username", uname);
                 if((uname==null && pass==null) || (pass==null))
                 {
                   request.setAttribute("msg", " ");

                 RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.jsp");
                 rd.forward(request, response);
                 }
                 else
                 response.sendRedirect("welcome.jsp");
                session.setAttribute("fullname", name);
                session.setAttribute("dob", dob);
                session.setAttribute("aadhar", aadharno);
                session.setAttribute("Hname", Hname);
                session.setAttribute("dose", dose);
                session.setAttribute("id", id);
             }
             else
             {
                 request.setAttribute("message", " ");

                 RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.jsp");
                 rd.include(request, response);
             }
         }
     catch(SQLException e)
             {
                 System.out.println("Error in sql statement");
             } 
 }
}
