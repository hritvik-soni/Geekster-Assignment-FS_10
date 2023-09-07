package com.hritvik.EmployeeManagementSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import com.hritvik.EmployeeManagementSystem.model.Employee;
import com.hritvik.EmployeeManagementSystem.repository.EmployeeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeService {


    @Autowired
    EmployeeRepository employeeRepository;

    public ResponseEntity<String> createEmployee(Employee employee){
        employeeRepository.save(employee);
        return new ResponseEntity<>("Successfully created employee", HttpStatus.CREATED);
    }

    public List<Employee> allEmployees(){
        return employeeRepository.findAll();
    }



    public ResponseEntity<String> updateEmployee(int id,Employee employee){
        if(!employeeRepository.findById(id).isPresent()){
            return new ResponseEntity<>("employee record does not exist",HttpStatus.NOT_FOUND);
        }

        Employee employeeDetails = employeeRepository.findById(id).get();
        if(employee.getEmail()!=null){
            employeeDetails.setEmail(employee.getEmail());
        }
        if(employee.getSalary()!=0){
            employeeDetails.setSalary(employee.getSalary());
        }
        if(employee.getAddress()!=null){
            employeeDetails.setAddress(employee.getAddress());
        }
        if(employee.getJobRole()!=null){
            employeeDetails.setJobRole(employee.getJobRole());
        }
        if(employee.getFirstName()!=null){
            employeeDetails.setFirstName(employee.getFirstName());
        }
        if(employee.getLastName()!=null){
            employeeDetails.setLastName(employee.getLastName());
        }
        if(employee.getPhoneNumber()!=null){
            employeeDetails.setPhoneNumber(employee.getPhoneNumber());
        }

        employeeRepository.save(employeeDetails);

        return new ResponseEntity<>("successfully updated the employee details",HttpStatus.CREATED);
    }
}