package sit.example.int204springapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sit.example.int204springapi.models.CustomerTest;
import sit.example.int204springapi.repository.CustomerTestRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerTestService {
    private final CustomerTestRepository customerTestRepository;

    public List<CustomerTest> insertCustomers(List<CustomerTest> customers) {
        return customerTestRepository.saveAll(customers);
    }

    public List<CustomerTest> findAll() {
        return customerTestRepository.findAll();
    }
}
