package sit.example.int204springapi.controller;

import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sit.example.int204springapi.models.Product;
import sit.example.int204springapi.service.ProductService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/products")
public class ProductController {
    private final ProductService productService;

    @GetMapping("")
    public ResponseEntity<List<Product>> getByBuyPriceAndProductName(@RequestParam(defaultValue = "0") Double lower,
                                                                     @RequestParam(defaultValue = "999999") Double upper,
                                                                     @RequestParam(defaultValue = "") String productName,
                                                                     @RequestParam(defaultValue = "") String sortBy,
                                                                     @RequestParam(defaultValue = "ASC") String sortDirection,
                                                                     @RequestParam(defaultValue = "-1") int page,
                                                                     @RequestParam(defaultValue = "-1") int size) {
        return ResponseEntity.ok(productService.findByBuyPriceAndProductName(lower, upper, productName, sortBy, sortDirection, page, size));
    }

    @GetMapping("/product-line/{productLine}")
    public ResponseEntity<List<Product>> getByProductLine(@PathVariable String productLine) {
        return ResponseEntity.ok(productService.findByProductLine(productLine));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getById(@PathVariable String id) {
        return ResponseEntity.ok(productService.findById(id));
    }

    @PostMapping("")
    public ResponseEntity<Product> post(@RequestBody Product product) {
        return ResponseEntity.ok(productService.createProduct(product));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> put(@RequestBody Product product, @PathVariable String id) {
        return ResponseEntity.ok(productService.updateProduct(product, id));
    }
}
