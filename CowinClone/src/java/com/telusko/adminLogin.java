
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

@WebServlet("/adminLogin")
public class adminLogin extends HttpServlet{
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
            try
            {
                Class.forName("com.mysql.jdbc.Driver");
            }
            catch(ClassNotFoundException e)
            {
                System.out.println("Error In Loading Drivers.....");
            }
            PrintWriter out = response.getWriter();
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String name = null;
            try
            {
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/covid?user=root&password=root");
                PreparedStatement ps = con.prepareStatement("Select * from admin where Email=? and Password=?");
                ps.setString(1,username);
                ps.setString(2,password);
            
             ResultSet rs=ps.executeQuery();
             if(rs.next()==true)
             {
                 ps=con.prepareStatement("select * from admin where Email=?");
                 ps.setString(1,username);
                 rs=ps.executeQuery();
                 if(rs.next()==true)
                 {
                     username=rs.getString("Email");
                     
                 }
                 HttpSession session=request.getSession();
                 session.setAttribute("username", username);
                 
                 if((username==null && password==null) || (password==null))
                 {
                 request.setAttribute("msg", " ");

                 RequestDispatcher rd = getServletContext().getRequestDispatcher("/adminLogin.jsp");
                 rd.forward(request, response);
                 }
                 else{
                 response.sendRedirect("adminWelcome.jsp");
                 session.setAttribute("username", username);
                 }
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
                 System.out.println("Error in sql statement");
             } 
    }
    
}
