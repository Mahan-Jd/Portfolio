package com.ShopNest.dbhandler;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ShopNest.product.Product;
import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

public class DataFetcher extends HttpServlet 
{
	public static String fetchPassword(String uname)
	{
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:Xe";
		String u = "system";
		String p = "system";
		String query = "select pass from coustomers where uname=?";
		String dbpass ="";

		try
		{
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, u, p);
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, uname);

			ResultSet rs = pstmt.executeQuery();
			rs.next();
			dbpass=rs.getString(1);

		} catch (Exception e) 
		{
			System.out.println("Login issues");
			e.printStackTrace();
		}

		return dbpass;

	}

	public static List fetchUserInfo()
	{
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:Xe";
		String un = "system";
		String pw = "system";
		String sql = "select uname,mail,gender,address from coustomers ";
		List ulist= new ArrayList();

		try
		{

			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, un, pw);
			Statement stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery(sql);

			while(rs.next())
			{
				String temp= 
						rs.getString(1)+":"+rs.getString(2)+":"+rs.getString(3)+":"+rs.getString(4)+":";
				ulist.add(temp);

			}
		}

		catch(Exception e)
		{
			System.out.println("Error in login");
			e.printStackTrace();

		}

		return ulist;
	}
	

	public static List fetchProductsInfo() {
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String user="system";
		String password="system";
		String sql="SELECT pid,pname,pdesc,pprice,pimg FROM products";
		List ilist=new ArrayList();
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection(url, user, password);
			Statement st=con.createStatement();
			
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()) 
			{
				String temp=""+rs.getInt(1)+":"+rs.getString(2)+":"+rs.getString(3)+":"+rs.getInt(4)+":"+rs.getString(5);
				ilist.add(temp);
			}
			
		}catch(Exception e){
			System.out.println("Problem in fetching product");
			e.printStackTrace();
		}			
		return ilist;
	}
	
	public static Product getProductById(int pid) {
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String user="system";
		String password="system";
		String sql="SELECT pname,pprice FROM products WHERE pid=?";
		Product p=null;
		
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection(url, user, password);
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, pid);
			ResultSet rs=ps.executeQuery();
			rs.next();
			String pname=rs.getString(1);
			int pprice=rs.getInt(2);
			
			p=new Product(pid,pname,pprice);
		}catch(Exception e){
			System.out.println("Problem in fetching product by id");
			e.printStackTrace();
		}			
		finally {
			return p;
		}
	}

}
