package com.online_library.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.online_library.entites.Books;

public interface BookRepository extends JpaRepository<Books, Long>, JpaSpecificationExecutor<Books> {

}
