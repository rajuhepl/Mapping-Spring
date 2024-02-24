package com.example.Mappingprojection.repository;

import com.example.Mappingprojection.model.System;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Systemrepo extends JpaRepository<System, Integer> {
}
