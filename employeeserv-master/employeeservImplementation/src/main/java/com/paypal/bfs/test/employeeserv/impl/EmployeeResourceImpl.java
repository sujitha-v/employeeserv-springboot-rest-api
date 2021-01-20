package com.paypal.bfs.test.employeeserv.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.paypal.bfs.test.employeeserv.Repository.EmployeeRepository;
import com.paypal.bfs.test.employeeserv.api.EmployeeResource;
import com.paypal.bfs.test.employeeserv.model.Employee;
import com.paypal.bfs.test.exception.ResourceNotFoundException;

import lombok.extern.slf4j.Slf4j;

/**
 * Implementation class for employee resource.
 */
@RestController
@Slf4j
public class EmployeeResourceImpl implements EmployeeResource {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public ResponseEntity<Employee> employeeGetById(@PathVariable Long id) throws Exception {
      Optional<Employee> employee = employeeRepository.findById(id);
        if(employee.isPresent()) {
            return ResponseEntity.ok().body(employee.get());
        }
        else {
            throw new ResourceNotFoundException("Employee not present for id"+id);
        }
    	
    }

    @Override
    public Employee create(@RequestBody Employee employee) throws Exception {
        validateEmployee(employee);
        return employeeRepository.save(employee);
    }

    private void validateEmployee(Employee employee) throws Exception {
        if(employee.getFirstName()==null)
        {
            throw new Exception("First Name is Missing");
        }
        if(employee.getLastName()==null)
        {
            throw new Exception("Last Name is Missing");
        }
        if(employee.getDob()==null)
        {
            throw new Exception("DOB is Missing");
        }
        
    }
}
