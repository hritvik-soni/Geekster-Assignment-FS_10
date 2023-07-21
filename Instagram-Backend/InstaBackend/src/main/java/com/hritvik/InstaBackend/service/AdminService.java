package com.hritvik.InstaBackend.service;


import com.hritvik.InstaBackend.repository.IAdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    IAdminRepo adminRepo;
}
