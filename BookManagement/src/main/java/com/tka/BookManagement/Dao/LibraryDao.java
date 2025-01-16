package com.tka.BookManagement.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.tka.BookManagement.Entity.Book;
import com.tka.BookManagement.Entity.Library;

public class LibraryDao {
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

	public void addLibrary(Library library) {
		// TODO Auto-generated method stub
			String sql = "insert into library values(?,?)";  

			try {
				con=getDbConnection();;
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1,library.getLid() );
				pstmt.setString(2, library.getName());
				pstmt.executeUpdate();
				
				System.err.println("Data inserted successfully");
			} catch (SQLException e) {
				System.out.println("Exception occured");
				e.printStackTrace();
			}
		}
	}


