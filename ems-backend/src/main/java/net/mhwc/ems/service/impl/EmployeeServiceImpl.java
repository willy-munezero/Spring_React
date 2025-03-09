package net.mhwc.ems.service.impl;

import lombok.AllArgsConstructor;
import net.mhwc.ems.dto.EmployeeDTO;
import net.mhwc.ems.entity.Employee;
import net.mhwc.ems.exception.ResourceNotFoundException;
import net.mhwc.ems.mapper.EmployeeMapper;
import net.mhwc.ems.repository.EmployeeRepository;
import net.mhwc.ems.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {

        Employee employee = EmployeeMapper.mapToEmployee(employeeDTO);
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDTO(savedEmployee);
    }

    @Override
    public EmployeeDTO getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee with ID " + employeeId + " not found."));
        return EmployeeMapper.mapToEmployeeDTO(employee);
    }


    @Override
    public List<EmployeeDTO> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();


        return employees.stream().map((employee) ->EmployeeMapper.mapToEmployeeDTO(employee)).collect(Collectors.toList());
    }

    @Override
    public EmployeeDTO updateEmployee(Long employeeId, EmployeeDTO UpdateDTO) {

        Employee employee = employeeRepository.findById(employeeId).orElseThrow(() -> new ResourceNotFoundException("Employee is not exists with given id: " +employeeId));

        employee.setFirstName(UpdateDTO.getFirstName());
        employee.setLastName(UpdateDTO.getLastName());
        employee.setEmail(UpdateDTO.getEmail());

        Employee updatedEmployee = employeeRepository.save(employee);

        return EmployeeMapper.mapToEmployeeDTO(updatedEmployee);
    }

    @Override
    public void deleteEmployee(Long employeeId) {

        Employee employee = employeeRepository.findById(employeeId).orElseThrow(() ->
                new ResourceNotFoundException("Employee id doestn't exist with a given: " +employeeId)
                );

        employeeRepository.deleteById(employeeId);
    }
}
