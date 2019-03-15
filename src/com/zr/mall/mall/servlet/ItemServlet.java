package com.zr.mall.mall.servlet;

import com.zr.mall.mall.dao.ItemDao;
import com.zr.mall.mall.entity.Items;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name="ItemServlet",urlPatterns="/ItemServlet")
public class ItemServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ItemDao dao = new ItemDao();
        String method = request.getParameter("method");
        if ("detail".equals(method)){
            String id = request.getParameter("id");
            Items items = dao.findById(Integer.parseInt(id));
            request.setAttribute("items",items);
            request.getRequestDispatcher("/detail.jsp").forward(request,response);
        }else {
            findAll(request, response, dao);
        }

    }

    private void findAll(HttpServletRequest request, HttpServletResponse response, ItemDao dao) throws ServletException, IOException {
        List<Items> itemsList = dao.findAll();
        request.setAttribute("itemsList",itemsList);
        request.getRequestDispatcher("/itemlist.jsp").forward(request,response);
    }
}
