package com.user,servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.Webservlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException
    try{

        UserDADImpl dao=new UsserDAOImpl(DBConnect.getConn());
        
        HttpSession=req.getSession();

        String email=req.getParameter("email");
        String password=req.getParameter("password");

    if("admin@gmail.com".equals(email) && "admin".equals(password)){
        User us=new User();
        session.setAttribute("",us);
        resp.sendRedirect("admin/home.jsp");
    }else{

           User us=dao.login(email,password);
           if(us!=null)
           {
            session.setAttribute("userobj",us);
            resp.sendRedirect(home.jsp);
           }else{
            session.setAttribute("failedMsg","Email & Password Invalid");
            resp.sendRedirect(login.jsp);
           }
           

        resp.sendRedirected("home.jsp");
    }

    }catch(Exception e){
      e.printintStackTrace();
    }
    
}