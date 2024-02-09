package sit.example.int204springapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sit.example.int204springapi.models.CustomerTest;

import java.util.Optional;


public interface CustomerTestRepository extends JpaRepository<CustomerTest, Long> {
}
