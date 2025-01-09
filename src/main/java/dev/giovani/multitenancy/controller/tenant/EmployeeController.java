package dev.giovani.multitenancy.controller.tenant;

import dev.giovani.multitenancy.domain.Employee;
import dev.giovani.multitenancy.repository.EmployeeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Transactional
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping(path = "/employee")
    public ResponseEntity<?> getEmployee() {
        return ResponseEntity.ok(employeeRepository.findAll());
    }

    @PostMapping(path = "/employee")
    public ResponseEntity<?> createEmployee(@RequestBody String name) {
        Employee newEmployee = new Employee();
        newEmployee.setName(name);
        employeeRepository.save(newEmployee);
        return ResponseEntity.ok(newEmployee);
    }
}
