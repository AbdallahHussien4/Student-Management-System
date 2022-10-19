package com.example.springsms.daos;


import com.example.springsms.dto.entities.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminDAO extends JpaRepository<Admin,Integer> {

}
