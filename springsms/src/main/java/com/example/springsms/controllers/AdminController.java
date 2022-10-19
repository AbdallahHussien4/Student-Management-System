package com.example.springsms.controllers;

import com.example.springsms.dto.entities.Admin;
import com.example.springsms.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admins")
public class AdminController {

    private AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }


    @GetMapping("/")
    public List<Admin> getAllAdmins() {
        return adminService.findAll();
    }

    @GetMapping("/{adminId}")
    public Admin getAdmin(@PathVariable int adminId) {
        Admin admin = adminService.findById(adminId);
        if(admin == null) {
            throw new RuntimeException("Admin id not found - " + adminId);
        }
        return admin;
    }

    @PostMapping("/")
    public Admin addAdmin(@RequestBody Admin admin) {

        System.out.println("Hi");
        admin.setId(0);

        adminService.save(admin);

        return admin;
    }

    @PutMapping("/{adminId}")
    public Admin updateAdmin(@PathVariable int adminId, @RequestBody Admin admin) {
        Admin dbAdmin = adminService.findById(adminId);

        if(dbAdmin == null) {
            throw new RuntimeException("Admin id not found - " + adminId);
        }

        admin.setId(adminId);
        adminService.save(admin);
        return admin;
    }

    @DeleteMapping("/{adminId}")
    public String removeAdmin(@PathVariable int adminId) {
        Admin admin = adminService.findById(adminId);

        if(admin == null) {
            throw new RuntimeException("Admin id not found - " + adminId);
        }

        adminService.deleteById(adminId);

        return "Deleted Admin id - " + adminId;
    }
}
