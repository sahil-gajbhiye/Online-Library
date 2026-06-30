package com.online_library.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.online_library.entites.Users;

public interface UserRepository extends JpaRepository<Users, Long> {

}
