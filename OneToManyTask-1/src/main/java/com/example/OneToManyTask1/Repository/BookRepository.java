package com.example.OneToManyTask1.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.OneToManyTask1.Entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
}