package com.zcx.fruit.servlets;

import com.zcx.fruit.dao.FruitDao;
import com.zcx.fruit.domain.Fruit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/list.do")
public class ListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setCharacterEncoding("UTF-8");
            String pageNum_s = req.getParameter("pageNum");
            FruitDao fruitDao = new FruitDao();
            if(pageNum_s==null)
                pageNum_s="1";
            int pageNum=Integer.parseInt(pageNum_s);
            if(pageNum<1){
                req.getRequestDispatcher("index.jsp").forward(req,resp);
                return;
            }
            if((pageNum-1)*5>=fruitDao.count()) {
                req.getRequestDispatcher("index.jsp").forward(req,resp);
                return;
            }
            List<Fruit> fruitList = fruitDao.listByPageNum(pageNum);
            HttpSession session = req.getSession();
            session.setAttribute("fruitList",fruitList);
            session.setAttribute("pageNum",pageNum);
            req.getRequestDispatcher("index.jsp").forward(req,resp);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
