package com.ntt.JDBCexamples;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {

	
		// TODO Auto-generated method stub
		public static void main(String[] args) {
			
			Scanner option = new Scanner(System.in);	
			System.out.println("Enter the choice");
			System.out.println("1.addNewBook");
			System.out.println("2.updateBook");
			System.out.println("3.deleteBook");
			System.out.println("4.searchBook");
			System.out.println("5.listAllBook");
			
			int choice = option.nextInt();
			
			switch(choice)
			{
			
			case 1:
			InsertBooks ie = new InsertBooks();
			int rows = ie.addNewBook();
			
			if(rows > 0)
			{
				System.out.println("User added successfully");
			}
			else
			{
				System.out.println("Error adding User try again");
			
			}break;
			
			case 2:
			UpdateBooks ue = new UpdateBooks();
			int updatedrows = ue.updateBook();
			
			if(updatedrows > 0)
			{
				System.out.println("books information  updated");
			}
			else
			{
				System.out.println("no informatin for books updated");
			}
			
			break;
		
case 3:
			
			DeleteBook de = new DeleteBook();
			int deletedrows = de.deleteBook();
			
			if(deletedrows > 0)
			{
				
				System.out.println("book details is removed successfully");
			}
			else
			{
				System.out.println("no such book");
			}break;
			
		case 4:			
			SearchBook se = new SearchBook();
			ResultSet rs = se.searchBook();			
			if(rs!=null)
			{
				System.out.println("book found....loading details...");
				System.out.println("books details are");
				try {
					while(rs.next())
					{
						System.out.println("Book id :" + rs.getInt("ID"));
						System.out.println("Book title :" + rs.getString("Title"));
						System.out.println("Book price  :" + rs.getFloat("price"));
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else
			{
				System.out.println("Book not found...check Book id");
			}break;
			
		case 5:			
			ListAllBooks lae= new ListAllBooks();
			ResultSet rs_listemps = lae.listAllBook();
			
			if(rs_listemps!=null)
			{
				
				System.out.println("Books details are");
				try {
					while(rs_listemps.next())
					{
						System.out.print("Book id :" + rs_listemps.getInt("ID") + "\t");
						System.out.print("Book title :" + rs_listemps.getString("Title")+ "\t");
						System.out.print("Book price  :" + rs_listemps.getFloat("price")+ "\t");
						System.out.println();
					
					}
		
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else
			{
				System.out.println("book  not found...check book id");
			}		
		}//switch close
	}
	}


