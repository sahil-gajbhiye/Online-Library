package com.online_library.specification;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import com.online_library.entites.Books;
import com.online_library.request_command.BookFilterRequest;

import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Predicate;

public class BookSpecification {

	public static Specification<Books> filterBooks(BookFilterRequest bookFilterRequest) {

		return (root, query, criteriaBuilder) -> {

			List<Predicate> predicates = new ArrayList<>();

			// Book Name
			if (bookFilterRequest.getBook_name() != null && !bookFilterRequest.getBook_name().isBlank()) {

				predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("book_name")),
						"%" + bookFilterRequest.getBook_name().toLowerCase() + "%"));
			}

			// Author
			if (bookFilterRequest.getBook_author() != null && !bookFilterRequest.getBook_author().isBlank()) {

				predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("book_author")),
						"%" + bookFilterRequest.getBook_author().toLowerCase() + "%"));
			}

			// Category
			if (bookFilterRequest.getCategory_id() != null && !bookFilterRequest.getCategory_id().isBlank()) {

				predicates.add(criteriaBuilder.equal(root.join("category_id"), bookFilterRequest.getCategory_id()));
			}

			// Status
			if (bookFilterRequest.getStatus() != null) {

				predicates.add(criteriaBuilder.equal(root.get("status"), bookFilterRequest.getStatus()));
			}

			return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
		};
	}
}
