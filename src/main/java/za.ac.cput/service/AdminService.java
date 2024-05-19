package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Admin;
import za.ac.cput.repository.AdminRepository;

import java.util.List;

/*
 *Admin:java
 *Admin: Service implementation Class
 * Author: Luke Duffell
 * Date: 19 May 2024
 */

@Service
public class AdminService implements IAdminService {
    private AdminRepository repository;

    @Autowired
    AdminService(AdminRepository repository) {this.repository = repository;}

    @Override
    public Admin create(Admin admin) {return repository.save(admin);}

    @Override
    public Admin read(String adminId) {return repository.findById(adminId).orElse(null);}

    @Override
    public Admin update(Admin admin) {return repository.save(admin);}

    @Override
    public List<Admin> getAll() {return repository.findAll();}
}
