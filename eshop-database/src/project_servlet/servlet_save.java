package project_servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import project_dao.productDAO;
import project_entity.Product;

@WebServlet(name = "servlet_save", urlPatterns = {"/servlet_save"})
public class servlet_save extends HttpServlet {   
    private static final long serialVersionUID = 1L;
    private productDAO prod_dao;

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        prod_dao = new productDAO();
        
        String product_barcode = request.getParameter("barcode");
        String product_name = request.getParameter("name");
        String product_color = request.getParameter("color");
        String product_description = request.getParameter("description");
        Product newProduct = new Product(Integer.parseInt(product_barcode), product_name, product_color, product_description);
        boolean result = prod_dao.addProduct(newProduct);
        
        List list = new ArrayList();
        if(result){
            list.add(product_barcode);
            list.add(product_name);
            list.add(product_color);
            list.add(product_description);
        }
        request.setAttribute("characteristics", list);
        RequestDispatcher view = request.getRequestDispatcher("result.jsp");
        view.forward(request, response);
        
    }
}
