package net.mhwc.ems.mapper;

import net.mhwc.ems.dto.EmployeeDTO;
import net.mhwc.ems.entity.Employee;

public class EmployeeMapper {
    public static EmployeeDTO mapToEmployeeDTO(Employee employee) {

        return new EmployeeDTO(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail()

        );

    }
    public static Employee mapToEmployee(EmployeeDTO employeedDTO) {

        return new Employee(
                employeedDTO.getId(),
                employeedDTO.getFirstName(),
                employeedDTO.getLastName(),
                employeedDTO.getEmail()
        );
    }
}
