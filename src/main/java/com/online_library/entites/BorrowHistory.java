package com.online_library.entites;

import java.time.LocalDateTime;

import com.online_library.enums.BorrowStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "borrow_history", schema = "online_library")
public class BorrowHistory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long borrow_id;

	@Column(name = "user_id", nullable = false)
	private Long user_id;

	@Column(name = "book_id", nullable = false)
	private Long book_id;

	@Column(name = "issue_date")
	private LocalDateTime issue_date;

	@Column(name = "due_date")
	private LocalDateTime due_date;

	@Column(name = "return_date")
	private LocalDateTime return_date;

	@Enumerated(EnumType.STRING)
	@Column(name = "status")
	private BorrowStatus status;

	public Long getBorrow_id() {
		return borrow_id;
	}

	public void setBorrow_id(Long borrow_id) {
		this.borrow_id = borrow_id;
	}

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public Long getBook_id() {
		return book_id;
	}

	public void setBook_id(Long book_id) {
		this.book_id = book_id;
	}

	public LocalDateTime getIssue_date() {
		return issue_date;
	}

	public void setIssue_date(LocalDateTime issue_date) {
		this.issue_date = issue_date;
	}

	public LocalDateTime getDue_date() {
		return due_date;
	}

	public void setDue_date(LocalDateTime due_date) {
		this.due_date = due_date;
	}

	public LocalDateTime getReturn_date() {
		return return_date;
	}

	public void setReturn_date(LocalDateTime return_date) {
		this.return_date = return_date;
	}

	public BorrowStatus getStatus() {
		return status;
	}

	public void setStatus(BorrowStatus status) {
		this.status = status;
	}

}
