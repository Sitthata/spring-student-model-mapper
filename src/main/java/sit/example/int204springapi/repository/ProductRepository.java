package sit.example.int204springapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sit.example.int204springapi.models.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, String> {
    List<Product> findByBuyPriceBetweenAndProductNameContains(Double lower, Double upper, String productName);
    List<Product> findByBuyPriceBetween(Double lower, Double upper);
    List<Product> findByProductNameContains(String productName);
    List<Product> findByProductLine(String productLine);
}
