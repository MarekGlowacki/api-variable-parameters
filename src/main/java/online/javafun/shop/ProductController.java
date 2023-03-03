package online.javafun.shop;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/products")
class ProductController {
    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping
    List<Product> getProducts(@RequestParam(required = false) String name) {
        if (name == null) {
            return productRepository.findAll();
        } else {
            return productRepository.findAllByName(name);
        }
    }

    @GetMapping("/{id}")
    ResponseEntity<Product> getProductById(@PathVariable Integer id) {
        return productRepository.findById(id)
                .map(ResponseEntity::ok)
                .ore
    }

    @GetMapping("/{id}/producer")
    ResponseEntity<Producer> getProducerByProductId(@PathVariable Integer id) {
        return productRepository.findById(id)
                .map(producer -> ResponseEntity.ok(producer))
    }

    @GetMapping("/example")
    @ResponseStatus(HttpStatus.CREATED)
    void example() {

    }
}