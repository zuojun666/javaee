package com.zcx.servlets;

import com.zcx.domain.Fruit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/edit.do")
public class EditServlet extends ViewBaseServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String fid = request.getParameter("fid");
        Fruit fruit = new Fruit();
        fruit.setFid(Integer.valueOf(fid));
        request.getSession().setAttribute("fruit",fruit);
        /*request.getRequestDispatcher("/edit.jsp").forward(request,response);*/
        super.processTemplate("/edit.html",request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
