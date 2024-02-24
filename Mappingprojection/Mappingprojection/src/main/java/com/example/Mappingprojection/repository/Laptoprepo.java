package com.example.Mappingprojection.repository;

import com.example.Mappingprojection.model.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Laptoprepo extends JpaRepository<Laptop, Integer> {
}
