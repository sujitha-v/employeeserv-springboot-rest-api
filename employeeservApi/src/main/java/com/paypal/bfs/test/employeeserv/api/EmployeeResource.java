package com.paypal.bfs.test.employeeserv.api;

import com.paypal.bfs.test.employeeserv.model.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Interface for employee resource operations.
 */
public interface EmployeeResource {

    /**
     * Retrieves the {@link Employee} resource by id.
     *
     * @param id employee id.
     * @return {@link Employee} resource.
     */
    @RequestMapping("/v1/bfs/employees/{id}")
    public ResponseEntity<Employee> employeeGetById(@PathVariable("id") Long id) throws Exception;

    // creates a new employee resource.
    
    @RequestMapping("/v1/bfs/employees")
    Employee create(Employee employee) throws Exception;
}
