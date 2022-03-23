package com.zcx.servlets;

import com.zcx.dao.FruitDao;
import com.zcx.domain.Fruit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
            request.getRequestDispatcher("/index").forward(request, response);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}