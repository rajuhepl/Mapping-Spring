package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.Person;

public interface Personrepo extends JpaRepository<Person, Integer> {

}
