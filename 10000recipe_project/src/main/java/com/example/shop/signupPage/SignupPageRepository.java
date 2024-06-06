package com.example.shop.signupPage;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SignupPageRepository extends JpaRepository<SignupPage, Long> {
    SignupPage findByUsername(String username);
}
