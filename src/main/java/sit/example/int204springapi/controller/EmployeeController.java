package sit.example.int204springapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import sit.example.int204springapi.models.Employee;
import sit.example.int204springapi.repository.EmployeeRepository;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("api/v1/employees")
public class EmployeeController {
    private final EmployeeRepository repository;

    @GetMapping("")
    public ResponseEntity<List<Employee>> getAll() {
        return ResponseEntity.ok(repository.findAll());
    }

}
