package com.online_library.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.online_library.entites.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
