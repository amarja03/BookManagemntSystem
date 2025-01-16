package com.tka.BookManagement.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.mysql.cj.protocol.Resultset;
import com.tka.BookManagement.Entity.Book;

public class BookDao {
	private static final String url = "jdbc:mysql://localhost:3306/studentdb";
	private static final String username = "root";
	private static final String password = "test123";
	public static Connection con;
	public static PreparedStatement pstmt;//use to execute any query

	public static Connection getDbConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	public  void insertBook(Book book) {
		String sql = "insert into book values(?,?,?,?)";  

		try {
			System.out.println(1);
			con=getDbConnection();;
			System.out.println(2);
			pstmt = con.prepareStatement(sql);
			System.out.println(3);
			pstmt.setInt(1,book.getId() );
			pstmt.setString(2, book.getName());
			System.out.println(book.getAuthor());
			pstmt.setString(3, book.getAuthor());
			pstmt.setDouble(4, book.getPrice());
			
			pstmt.executeUpdate();
			
			System.err.println("Data inserted successfully");
		} catch (SQLException e) {
			System.out.println("Exception occured");
			e.printStackTrace();
		}
	}
	public ArrayList<Book> getallbooks()
	 {
		 ArrayList<Book> albook=new ArrayList<Book>();
		 String sql="select * from book";
			try {
				con=getDbConnection();;
				pstmt=con.prepareStatement(sql);
				ResultSet rs=pstmt.executeQuery();
				while(rs.next())
				{
					int id=rs.getInt(1);
					String name=rs.getString(2);
					String Author=rs.getString(3);
					double price=rs.getDouble(4);
					albook.add(new Book(id, name, Author, price));
					
				}
			}catch(Exception e)
			{
				
			}
			return albook;
	 }
	public void deletebooks(int id) {
		String sql = "delete from book where id=?";

		try {
			con=getDbConnection();;

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,id);
			pstmt.executeUpdate();
			
			System.err.println("Data deleted successfully");
		} catch (SQLException e) {
			System.out.println("Exception occured");
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		
	}
	
	public void updateBooks(Book book) {
		String sql="update book set name=?,author=?,price=? where id=? ";
		try {
			pstmt=con.prepareStatement(sql);
			
			pstmt.setInt(1,book.getId());
			pstmt.setString(2, book.getName());
			pstmt.setString(3,book.getAuthor());
			pstmt.setDouble(4,book.getPrice());
			
			int i=pstmt.executeUpdate();
			if(i>0) {
				System.out.println("books uploaded successfuly");
			}else {
				System.out.println("no book found");
			}
		} catch (Exception e) {
			System.out.println("Exception occured");
			e.printStackTrace();
		}
	}
	
	public Book fetchbookbyID(int id) throws SQLException {
		String sql="Select * from book where id =?";
		con=getDbConnection();
		Book book = null;
		pstmt=con.prepareStatement(sql);
		pstmt.setInt(1, id);
		ResultSet rs=pstmt.executeQuery();
		while(rs.next())
		{
			int idb=rs.getInt("id");
			String name=rs.getString("name");
			String author=rs.getString("author");
			double price=rs.getDouble("price");
			book = new Book(idb,name,author,price);
		}
		return book;

	}
	}

	
	
