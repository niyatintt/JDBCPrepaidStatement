package com.ntt.JDBCexamples;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateBooks {
	Scanner sc = new Scanner(System.in);
	int no_of_rows_updated =0;
	
	Connection conUpdated = null;
	PreparedStatement pstmt = null;
	public int updateBook()
	{
		int bookid;
		float price;
		
		String updateemp = "update books set price = ? where eid = ?";
		
		System.out.println("Enter books details to update");
		System.out.println("Enter book id ");
		bookid = sc.nextInt();
		System.out.println("Enter book price");
		price = sc.nextFloat();
		
		
		try {
			conUpdated = DBConnection.getDBConnection();
			pstmt = conUpdated.prepareStatement(updateemp);
		
			pstmt.setFloat(1, price);
			pstmt.setInt(2, bookid);
			no_of_rows_updated = pstmt.executeUpdate();
		
		} 
		
		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return no_of_rows_updated;
	}
}
