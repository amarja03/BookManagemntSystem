package com.tka.BookManagement.Controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tka.BookManagement.Entity.Library;
import com.tka.BookManagement.Services.LibraryService;

@RestController
 @RequestMapping("/library")
public class LibraryController {
	LibraryService libraryService = new LibraryService();
	@PostMapping("/addlibrary")
	public void addLibrary(@RequestBody Library library) {
		libraryService.addLibrary(library);
	}

}
