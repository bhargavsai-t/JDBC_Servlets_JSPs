package controllers;

import java.io.IOException;
import java.io.PrintWriter;

import dao.CouponDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Coupon;

@WebServlet("/CouponCreation")
public class CouponCreation extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CouponDAO cd = new CouponDAO();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action.equals("create")) {
			createCoupon(request, response);
		} else if (action.equals("find")) {
			findCoupon(request, response);
		}
	}

	public void createCoupon(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String code = request.getParameter("code");
		long discount = Long.parseLong(request.getParameter("discount"));
		String exp_date = request.getParameter("expDate");

		Coupon c = new Coupon();
		c.setCode(code);
		c.setDiscount(discount);
		c.setExpDate(exp_date);
		cd.save(c);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.write("<b>Coupon Created Successfully</b><br/>");
		out.write("<a href='Index.html'>Back</a>");
	}

	public void findCoupon(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String code = request.getParameter("code");
		Coupon c = cd.findByCode(code);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.write("Coupon ID: " + c.getId());
		out.write("<br/>Coupon Code: " + c.getCode());
		out.write("<br/>Coupon Discount: " + c.getDiscount());
		out.write("<br/>Coupon Expiry Date: " + c.getExpDate());
		out.print("<br/><a href='Index.html'>Home</a>");
	}

}
