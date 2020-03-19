package com.ntt.JDBCexamples;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertBooks {
	Scanner sc = new Scanner(System.in);
	PreparedStatement pstmt = null;
	Connection con = null;
	public int addNewBook()
	{
		int noofrowsinserted = 0;
		int bookid;
		String titlename;
		String authorname;
		float price;
		int qty;
		System.out.println("Enter the details to enter the  new book");
		System.out.println("enter book id");
		bookid = sc.nextInt();
		System.out.println("enter book title");
		titlename = sc.next();
		System.out.println("enter author name");
		authorname = sc.next();
		System.out.println("enter price of book");
		price = sc.nextFloat();
		System.out.println("enter quantity of book");
		qty = sc.nextInt();
		
		
		try{
			
		String addemp = "insert into books values (?,?,?,?,?);";
		con = DBConnection.getDBConnection();		
		pstmt = con.prepareStatement(addemp);
		
		pstmt.setInt(1, bookid);
		pstmt.setString(2, titlename);
		pstmt.setString(3, authorname);
		pstmt.setFloat(4,price);
		pstmt.setInt(5,qty);
		
		noofrowsinserted = pstmt.executeUpdate();
		
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try {
			   con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return noofrowsinserted;
	}
	
	
}
