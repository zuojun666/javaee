package com.zcx.fruit.servlets;

import com.zcx.fruit.dao.FruitDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/del.do")
public class DelServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setCharacterEncoding("UTF-8");
            FruitDao fruitDao = new FruitDao();
            fruitDao.deleteById(Integer.valueOf(request.getParameter("fid")));
            /*response.sendRedirect("/index");*/
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            request.getRequestDispatcher("/index").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
