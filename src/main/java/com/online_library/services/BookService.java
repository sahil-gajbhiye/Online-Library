package com.online_library.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.online_library.entites.Books;
import com.online_library.repositories.BookRepository;
import com.online_library.request_command.BookFilterRequest;
import com.online_library.response_command.BookResponse;
import com.online_library.specification.BookSpecification;

@Service
public class BookService {

	private final BookRepository bookRepository;

	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	public List<BookResponse> getAllBooks(BookFilterRequest request) {

		List<Books> books = bookRepository.findAll(BookSpecification.filterBooks(request));

		return books.stream().map(this::convertToResponse).collect(Collectors.toList());
	}

	/**
	 * Convert Entity to DTO
	 */
	private BookResponse convertToResponse(Books books) {

		BookResponse bookResponse = new BookResponse();

		bookResponse.setBook_id(String.valueOf(books.getBook_id()));
		bookResponse.setBook_name(books.getBook_name());
		bookResponse.setBook_author(books.getBook_author());
		bookResponse.setCategory_id(String.valueOf(books.getCategory_id()));
		bookResponse.setStatus(books.getStatus());
		bookResponse.setCurrent_user(books.getCurrent_user() == null ? "Available" : books.getCurrent_user());

		return bookResponse;
	}

}
