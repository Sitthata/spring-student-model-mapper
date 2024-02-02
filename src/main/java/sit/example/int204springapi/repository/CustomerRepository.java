package sit.example.int204springapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sit.example.int204springapi.models.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
