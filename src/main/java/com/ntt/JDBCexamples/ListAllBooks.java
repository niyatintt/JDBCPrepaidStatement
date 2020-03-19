package com.ntt.JDBCexamples;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ListAllBooks {
Scanner sc = new Scanner(System.in);
	
	
	Connection conUpdated = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	public ResultSet listAllBook()
	{
		int bookid;
		
		
		String selectallbook = "select * from books";
		


		
		
		try {
			conUpdated = DBConnection.getDBConnection();
			pstmt = conUpdated.prepareStatement(selectallbook);			
			rs = pstmt.executeQuery();
		
		} 
		
		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return rs;
	}
}
