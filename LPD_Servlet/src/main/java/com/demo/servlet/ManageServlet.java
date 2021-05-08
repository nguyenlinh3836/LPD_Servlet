package com.demo.servlet;

import com.demo.dao.ProductDao;
import com.demo.entity.ProductEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ManageServlet",urlPatterns = {"/manage"})
public class ManageServlet extends HttpServlet {
    ProductDao dao = new ProductDao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<ProductEntity> products = getAllProduct();
        request.setAttribute("products", products);
        request.getRequestDispatcher("manage.jsp").forward(request, response);
    }

    private List<ProductEntity> getAllProduct() {
        List<ProductEntity> products = dao.getAll();
        return products;
    }
}

