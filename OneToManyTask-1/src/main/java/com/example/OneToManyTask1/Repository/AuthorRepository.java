package com.example.OneToManyTask1.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.OneToManyTask1.Entity.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}