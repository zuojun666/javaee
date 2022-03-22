package com.zcx.fruit.servlets;


import com.zcx.fruit.dao.FruitDao;
import com.zcx.fruit.domain.Fruit;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/update.do")
public class UpdateServlet extends ViewBaseServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setCharacterEncoding("UTF-8");
            Fruit fruit = new Fruit();
            fruit.setFid(Integer.valueOf(request.getParameter("fid")));
            fruit.setFname(request.getParameter("fname"));
            fruit.setFcount(Integer.valueOf(request.getParameter("fcount")));
            fruit.setPrice(Double.valueOf(request.getParameter("price")));
            fruit.setRemark(request.getParameter("remark"));
            request.getSession().setAttribute("fruit",fruit);
            FruitDao fruitDao = new FruitDao();
            fruitDao.updateById(fruit);
            response.sendRedirect("/index.html");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
