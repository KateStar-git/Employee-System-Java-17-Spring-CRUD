package com.example.jsfcrud.repositories;
import com.example.jsfcrud.entities.Employee;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

import static org.springframework.data.domain.Sort.Order.by;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
    List<Employee> findAllByOrderByLastNameAsc();

}
