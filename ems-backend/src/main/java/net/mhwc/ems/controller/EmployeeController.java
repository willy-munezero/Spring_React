package net.mhwc.ems.controller;

import lombok.AllArgsConstructor;
import net.mhwc.ems.dto.EmployeeDTO;
import net.mhwc.ems.entity.Employee;
import net.mhwc.ems.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@AllArgsConstructor
@CrossOrigin("*")
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    //build ADD EMPLOYEE REST API
  @PostMapping
    public ResponseEntity<EmployeeDTO> createEmployee(@RequestBody EmployeeDTO employeeDTO){
        EmployeeDTO savedEmployee = employeeService.createEmployee(employeeDTO);

        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable("id") Long employeeId){
        EmployeeDTO employeeDTO = employeeService.getEmployeeById(employeeId);
        return ResponseEntity.ok(employeeDTO);
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees(){

        List<EmployeeDTO> employees = employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }

    @PutMapping("{id}")
    public ResponseEntity<EmployeeDTO> updateEmployee(@PathVariable("id") Long employeeId,
                                                      @RequestBody EmployeeDTO updatedEmployeee){
        EmployeeDTO employeeDTO = employeeService.updateEmployee(employeeId, updatedEmployeee);

        return ResponseEntity.ok(employeeDTO);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeId){

        employeeService.deleteEmployee(employeeId);
        return ResponseEntity.ok("Employee deleted successfully!!");
    }
}
