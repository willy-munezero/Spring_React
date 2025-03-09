package net.mhwc.ems.service;

import net.mhwc.ems.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeService {

    EmployeeDTO createEmployee(EmployeeDTO employeeDTO);

    //find by ID
    EmployeeDTO getEmployeeById (Long employeeId);

    //get all employees
    List<EmployeeDTO> getAllEmployees();

    //update empoyee
    EmployeeDTO updateEmployee(Long employeeId, EmployeeDTO UpdateDTO);

    //delete employee
    void deleteEmployee(Long employeeId);

}
