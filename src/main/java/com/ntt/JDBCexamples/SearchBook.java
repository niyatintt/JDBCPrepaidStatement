package com.ntt.JDBCexamples;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class SearchBook {
Scanner sc = new Scanner(System.in);
	
	
	Connection conUpdated = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	public ResultSet searchBook()
	{
		int bookid;
		
		
		String selectbook = "select * from books where ID = ?";
		
		//System.out.println("Enter employee details to update");
		System.out.println("Enter book id to search his details ");
		bookid = sc.nextInt();

		
		
		try {
			conUpdated = DBConnection.getDBConnection();
			pstmt = conUpdated.prepareStatement(selectbook);			
			pstmt.setInt(1, bookid);
			rs = pstmt.executeQuery();
		
		} 
		
		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return rs;
	}
}
