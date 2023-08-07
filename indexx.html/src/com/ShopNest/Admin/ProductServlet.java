package com.ShopNest.Admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ShopNest.dbhandler.DataInjector;


@WebServlet("/addP")
public class ProductServlet extends HttpServlet 
{
	public void doPost(HttpServletRequest req,HttpServletResponse res)
	{
		int pid =Integer.parseInt( req.getParameter("product-id"));
		String pname = req.getParameter("product-name");
		String pdesc= req.getParameter("product-description");
		int pprice =Integer.parseInt( req.getParameter("product-price"));
		String pimg = req.getParameter("product-image");

		DataInjector.addProduct(pid,pname,pdesc,pprice,pimg);

	}


}
