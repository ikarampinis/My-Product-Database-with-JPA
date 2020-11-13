package project_servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import project_dao.productDAO;

@WebServlet(name = "servlet_view", urlPatterns = {"/servlet_view"})
public class servlet_view extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private productDAO prod_dao;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        prod_dao = new productDAO();
        List result = new ArrayList();
        result = prod_dao.getAllProducts();
        
        request.setAttribute("productlist", result);
        RequestDispatcher view = request.getRequestDispatcher("database_view.jsp");
        view.forward(request, response);
        
    }




}
