package com.zcx.fruit.servlets;

import com.zcx.fruit.dao.FruitDao;
import com.zcx.fruit.domain.Fruit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/index.html")
public class IndexServlet extends ViewBaseServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            FruitDao fruitDao = new FruitDao();
            List<Fruit> fruitList;
            fruitList = fruitDao.list();
            request.getSession().setAttribute("fruitList",fruitList);
            super.processTemplate("index",request,response);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
