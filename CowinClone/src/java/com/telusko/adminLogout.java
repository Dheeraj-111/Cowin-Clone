package com.telusko;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/adminLogout")
public class adminLogout extends HttpServlet
{
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
{
    HttpSession session= request.getSession();
    session.removeAttribute("username");
    session.invalidate();
    response.sendRedirect("adminLogin.jsp");
}
}
