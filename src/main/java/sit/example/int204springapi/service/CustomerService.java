package sit.example.int204springapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import sit.example.int204springapi.models.Customer;
import sit.example.int204springapi.models.Order;
import sit.example.int204springapi.repository.CustomerRepository;
import sit.example.int204springapi.repository.OrderRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final OrderRepository orderRepository;
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    public Customer findById(Integer id) {
        return customerRepository.findById(id).orElseThrow(
                () -> new HttpClientErrorException(HttpStatus.NOT_FOUND, "Customer not found")
        );
    }

    public void addCustomer(Customer customer) {
        Integer id = customer.getId();
        if (id != null && customerRepository.existsById(id)) {
            throw new HttpClientErrorException(HttpStatus.CONFLICT, "Customer already exists");
        }
        customerRepository.save(customer);
    }

    public void updateCustomer(Integer id, Customer customer) {
        if (!customer.getId().equals(id)) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Customer ID not match");
        }
        customerRepository.findById(id).orElseThrow(
                () -> new HttpClientErrorException(HttpStatus.NOT_FOUND, "Customer not found")
        );

        customerRepository.save(customer);
    }

    public void deleteCustomer(Integer id) {
        Customer customer = customerRepository.findById(id).orElseThrow(
                () -> new HttpClientErrorException(HttpStatus.NOT_FOUND, "Customer not found")
        );
        customerRepository.delete(customer);
    }

    public List<Order> getOrders(Integer id) {
        return orderRepository.findAllByCustomerNumber(id);
    }
}
