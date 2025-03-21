package controllers;

import java.io.IOException;
import java.io.PrintWriter;

import dao.ProductDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Product;

@WebServlet("/CreateProduct")
public class CreateProduct extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        long price = Long.parseLong(request.getParameter("price"));
        String description = request.getParameter("description");
        Product p = new Product();
        p.setName(name);
        p.setPrice(price);
        p.setDescription(description);
        ProductDAO pd = new ProductDAO();
        pd.save(p);
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.print("Product Created Successfully");
        out.print("<br/><a href='Index.html'>Home</a>");

    }

}
