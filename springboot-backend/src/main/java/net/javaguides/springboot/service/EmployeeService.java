package net.javaguides.springboot.service;

import net.javaguides.springboot.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);

    EmployeeDto getEmployeeById(long employeeId);
    List<EmployeeDto> getAllEmployee();
    EmployeeDto updateEmployee(long employeeId, EmployeeDto updatedEmployee);
    void deleteEmployee(long employeeId);
}
