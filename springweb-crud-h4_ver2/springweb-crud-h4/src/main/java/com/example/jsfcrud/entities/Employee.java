package com.example.jsfcrud.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
//@Data
public class Employee {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long EmployeeId;

  @NotBlank(message = "First Name should not be blank")
  private String firstName;

  @NotBlank(message = "Last Name should not be blank")
  private String lastName;

  @NotBlank(message = "Salary should not be blank")
  private String salary;


  public long getEmployeeId() {
    return EmployeeId;
  }

  public void setEmployeeId(long employeeId) {
    EmployeeId = employeeId;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getSalary() {
    return salary;
  }

  public void setSalary(String salary) {
    this.salary = salary;
  }
}
