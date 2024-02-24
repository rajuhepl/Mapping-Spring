package com.example.Mappingprojection.repository;

import com.example.Mappingprojection.model.User;
import com.example.Mappingprojection.projection.Projection;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface Userrepo extends JpaRepository<User, Integer> {

//    SELECT u.user_id, u.user_name, u.user_email,l.laptop_id, l.lap_brandname, l.lap_model,s.system_id, s.sys_brandname, s.sys_model
//    FROM user u JOIN laptop l ON u.user_id = l.user_id
//    JOIN systemtable s ON u.user_id = s.user_id
//    WHERE u.is_active =1;

    @Query("SELECT u.id as id, u.name as name, u.email as email, l.laptop_id as laptop_id, l.brandname as lapBrandname, l.model as lapModel, s.system_id as system_id, s.brandname as brandname, s.model as model" +
            " FROM User u" +
            " JOIN Laptop l ON l.user.id = u.id" +
            " JOIN System s ON s.user.id = u.id" +
            " WHERE u.active = true")
    List<Projection> gettingdetails();

    @Query("SELECT u.id as id, u.name as name, u.email as email, l.laptop_id as laptop_id, l.brandname as lapBrandname, l.model as lapModel, s.system_id as system_id, s.brandname as brandname, s.model as model" +
            " FROM User u" +
            " JOIN Laptop l ON l.user.id = u.id" +
            " JOIN System s ON s.user.id = u.id")
    Page<Projection> findAllProjections(Pageable pageable);
}
