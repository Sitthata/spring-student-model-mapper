package sit.example.int204springapi.controller.Test;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sit.example.int204springapi.models.CustomerTest;
import sit.example.int204springapi.service.CustomerTestService;

import java.util.List;

@RestController
@RequestMapping("api/v1/test/customer")
@RequiredArgsConstructor
public class CustomerTestController {

    private final CustomerTestService customerTestService;

    @PostMapping("")
    public ResponseEntity<List<CustomerTest>> createAll(@RequestBody List<CustomerTest> customerTests) {
        return ResponseEntity.ok(customerTestService.insertCustomers(customerTests));
    }

    @GetMapping("")
    public ResponseEntity<List<CustomerTest>> getAll() {
        return ResponseEntity.ok(customerTestService.findAll());
    }
}
