package com.zcx.servlets;

import com.zcx.dao.FruitDao;
import com.zcx.domain.Fruit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
            request.getRequestDispatcher("/index").forward(request,response);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
