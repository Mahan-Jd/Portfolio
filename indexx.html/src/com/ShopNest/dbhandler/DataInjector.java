package com.ShopNest.dbhandler;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class DataInjector extends HttpServlet 
{
	public static String addCustomer(String uname,String mail,String pass,String gender,String address)
	{
		String driver="oracle.jdbc.driver.OracleDriver";
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String un = "system";
		String passw="system";
		String sql="insert into COUSTOMERS values(?,?,?,?,?)";
		String regstatus="";
		try
		{
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url,un,passw);
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, uname);
			pstmt.setString(2, mail);
			pstmt.setString(3, pass);
			pstmt.setString(4, gender);
			pstmt.setString(5, address);
			
			pstmt.executeUpdate();
			
			regstatus = "success";
			

		} 
		catch (Exception ex) 
		{
			System.out.println("Problem in adding coustomer");
			ex.printStackTrace();
			
			regstatus="fail";

		}
		finally
		{
			return regstatus;
			
		}


	}
	
	public static boolean addProduct(int pid,String pname,String pdesc,int pprice,String pimg){
		
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String user="system";
		String password="system";
		String sql="INSERT INTO products VALUES(?,?,?,?,?)";
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection(url, user, password);
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, pid);
			ps.setString(2, pname);
			ps.setString(3, pdesc);
			ps.setInt(4, pprice);
			ps.setString(5, pimg);
			ps.executeUpdate();
		}catch(Exception e){
			System.out.println("Problem in adding product");
			e.printStackTrace();
			return false;
		}			
		return true;
	}

}
