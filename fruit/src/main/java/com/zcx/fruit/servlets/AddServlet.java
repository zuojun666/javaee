package com.zcx.fruit.servlets;

import com.zcx.fruit.dao.FruitDao;
import com.zcx.fruit.domain.Fruit;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/add.do")
public class AddServlet extends ViewBaseServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setCharacterEncoding("UTF-8");
            FruitDao fruitDao = new FruitDao();
            Fruit fruit = new Fruit();
            fruit.setFname(request.getParameter("fname"));
            fruit.setRemark(request.getParameter("remark"));
            fruit.setPrice(Double.valueOf(request.getParameter("price")));
            fruit.setFcount(Integer.valueOf(request.getParameter("fcount")));
            fruitDao.addFruit(fruit);
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
