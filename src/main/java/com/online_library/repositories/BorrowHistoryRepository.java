package com.online_library.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.online_library.entites.BorrowHistory;

public interface BorrowHistoryRepository extends JpaRepository<BorrowHistory, Long> {

}
