package com.example.rest_service.repository;

import com.example.rest_service.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // 這裡不需要顯示地實作 JpaRepository 的方法，Spring Data JPA 自動處理
}