package com.ntt.JDBCexamples;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteBook {
	
	Scanner sc = new Scanner(System.in);
	int no_of_rows_deleted =0;
	
	Connection conUpdated = null;
	PreparedStatement pstmt = null;
	public int deleteBook()
	{
		int bookid;
		float price;
		
		String deletebook = "delete from books where ID = ?";
		
		System.out.println("Enter book details to update");
		System.out.println("Enter book id ");
		bookid = sc.nextInt();
	
		
		
		try {
			conUpdated = DBConnection.getDBConnection();
			pstmt = conUpdated.prepareStatement(deletebook);
		
			
			pstmt.setInt(1, bookid);
			no_of_rows_deleted = pstmt.executeUpdate();
		
		} 
		
		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return no_of_rows_deleted;
	}

}
