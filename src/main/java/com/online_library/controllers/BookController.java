package com.online_library.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.online_library.request_command.BookFilterRequest;
import com.online_library.response_command.BookResponse;
import com.online_library.services.BookService;

@RestController
@RequestMapping("/api-v1/books")
public class BookController {

	private final BookService bookService;

	public BookController(BookService bookService) {
		this.bookService = bookService;
	}

	@GetMapping
	public ResponseEntity<List<BookResponse>> getBooks(@ModelAttribute BookFilterRequest request) {

		List<BookResponse> response = bookService.getAllBooks(request);

		return ResponseEntity.ok(response);
	}
}
