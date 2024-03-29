package sit.example.int204springapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import sit.example.int204springapi.exception.Impl.ErrorResponse;
import sit.example.int204springapi.exception.ItemNotFoundException;
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
//    @ExceptionHandler(ItemNotFoundException.class)
//    @ResponseStatus(code = HttpStatus.NOT_FOUND)
//    public ResponseEntity<ErrorResponse> handleItemNotFound(ItemNotFoundException ex, WebRequest request) {
//        ErrorResponse er = new ErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage(), request.getDescription(false));
//        er.addValidationError("id 1", "Message 1");
//        er.setStackTrace(ex.toString());
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(er);
//    }
}
