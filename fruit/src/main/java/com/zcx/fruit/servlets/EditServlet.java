package com.zcx.fruit.servlets;

import com.zcx.fruit.domain.Fruit;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
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
        super.processTemplate("edit",request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
