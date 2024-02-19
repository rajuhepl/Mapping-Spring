package com.example.demo.Frepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Fentity.Client;




@Repository
public interface clientrepo extends JpaRepository<Client, Integer>{

}
