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

@WebServlet(name = "HomeServlet",urlPatterns = {"/home"})
public class HomeServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        List<ProductEntity> products = getAllProduct();
        request.setAttribute("products", products);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    List<ProductEntity> getAllProduct() {
        ProductDao dao = new ProductDao();
        return dao.getAll();
    }
}
