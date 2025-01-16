package com.tka.BookManagement.Services;

import com.tka.BookManagement.Dao.LibraryDao;
import com.tka.BookManagement.Entity.Library;

public class LibraryService {
	LibraryDao libraryDao = new LibraryDao();

	public void addLibrary(Library library) {
		// TODO Auto-generated method stub
		 libraryDao.addLibrary(library);
	}

}
