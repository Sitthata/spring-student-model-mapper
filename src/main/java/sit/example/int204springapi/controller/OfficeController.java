package sit.example.int204springapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sit.example.int204springapi.dto.OfficeDTO;
import sit.example.int204springapi.models.Employee;
import sit.example.int204springapi.models.Office;
import sit.example.int204springapi.service.OfficeService;

import java.util.List;

@Controller
@RequestMapping("api/v1/office")
@RequiredArgsConstructor
public class OfficeController {

    private final OfficeService officeService;
    @GetMapping("")
    public ResponseEntity<List<Office>> getAll() {
        return ResponseEntity.ok(officeService.getAllOffices());
    }

    @GetMapping("{id}")
    public ResponseEntity<Office> get(@PathVariable Integer id) {
        return ResponseEntity.ok(officeService.getById(id));
    }

    @GetMapping("{id}/employees")
    public ResponseEntity<List<Employee>> getEmployees(@PathVariable Integer id) {
        return ResponseEntity.ok(officeService.getEmployees(id));
    }

    @PostMapping("add-office")
    public ResponseEntity<String> add(@RequestBody Office office) {
        return ResponseEntity.ok(officeService.addNewOffice(office));
    }

    @DeleteMapping("remove-office/{id}")
    public ResponseEntity<String> remove(@PathVariable Integer id) {
        return ResponseEntity.ok(officeService.removeOffice(id));
    }

    @PutMapping
    public ResponseEntity<String> update(@RequestBody Office office) {
        return ResponseEntity.ok(officeService.updateOffice(office.getId(), office));
    }
}
