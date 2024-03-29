package sit.example.int204springapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sit.example.int204springapi.dto.CustomerDTO;
import sit.example.int204springapi.models.Customer;
import sit.example.int204springapi.models.Order;
import sit.example.int204springapi.service.CustomerService;

import java.util.List;

@RestController
@RequestMapping("api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService service;
    @GetMapping("")
    public ResponseEntity<List<CustomerDTO>> get() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("{id}/orders")
    public ResponseEntity<List<Order>> getOrders(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getOrders(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDTO> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping("")
    public ResponseEntity<Void> post(@RequestBody Customer customer) {
        service.addCustomer(customer);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.deleteCustomer(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> put(@PathVariable Integer id, @RequestBody Customer customer) {
        service.updateCustomer(id, customer);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
