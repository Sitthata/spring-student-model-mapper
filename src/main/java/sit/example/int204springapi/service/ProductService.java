package sit.example.int204springapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import sit.example.int204springapi.models.Product;
import sit.example.int204springapi.repository.ProductRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository repository;

    public List<Product> findByBuyPriceAndProductName(Double lower, Double upper, String productName) {
        if (lower == null && upper == null && productName == null)
            return repository.findAll();
        return repository.findByBuyPriceBetweenAndProductNameContains(lower, upper, productName);
    }

    public List<Product> findByProductLine(String productLine) {
        return repository.findByProductLine(productLine);
    }

    public Product createProduct(Product product) {
        if (repository.existsById(product.getProductCode())) {
            throw new HttpClientErrorException(HttpStatus.CONFLICT, "Product code already exists");
        }
        return repository.save(product);
    }

    public Product findById(String id) {
        return repository.findById(id).orElseThrow(
                () -> new HttpClientErrorException(HttpStatus.NOT_FOUND, "Product not found")
        );
    }

    public Product updateProduct(Product product, String id) {
        if (!product.getProductCode().equals(id)) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Product code in path and body not match");
        }
        if (!repository.existsById(id)) {
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND, "Product not found");
        }
        return repository.save(product);
    }
}
