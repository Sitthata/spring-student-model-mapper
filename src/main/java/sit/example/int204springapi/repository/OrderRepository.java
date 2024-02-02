package sit.example.int204springapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sit.example.int204springapi.models.Order;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    List<Order> findAllByCustomerNumber(Integer customerNumber);
}
