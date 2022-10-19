package com.example.springsms.services;

import com.example.springsms.daos.AdminDAO;
import com.example.springsms.dto.entities.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {
    private AdminDAO adminDAO;

    @Autowired
    public AdminService(AdminDAO adminDAO) {
        this.adminDAO = adminDAO;
    }

    public void save(Admin admin) {
        adminDAO.save(admin);
    }

    public void deleteById(int id) {
        adminDAO.deleteById(id);
    }

    public List<Admin> findAll() {
        return adminDAO.findAll();
    }

    public Admin findById(int id) {
        Optional<Admin> result = adminDAO.findById(id);
        return result.orElse(null);
    }
}
