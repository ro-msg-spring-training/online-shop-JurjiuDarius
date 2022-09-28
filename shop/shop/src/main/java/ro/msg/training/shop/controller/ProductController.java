package ro.msg.training.shop.controller;

import org.springframework.web.bind.annotation.*;
import ro.msg.training.shop.dto.ProductDTOMapper;
import ro.msg.training.shop.dto.ProductReadDTO;
import ro.msg.training.shop.dto.ProductWriteDTO;
import ro.msg.training.shop.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping()
    public List<ProductReadDTO> allProducts() {
        return productService.allProducts();
    }

    @GetMapping("/hello")
    public String helloWorld() {
        return "Hello World!";
    }

    @GetMapping("/{id}")
    public ProductReadDTO findById(@PathVariable("id") int id) {
        try {
            return productService.findById(id);
        } catch (Exception e) {
            return new ProductReadDTO();
        }
    }

    @PostMapping()
    public ProductReadDTO createProduct(@RequestBody ProductWriteDTO productWriteDTO) {
        try {
            return productService.save(ProductDTOMapper.toProduct(productWriteDTO));
        } catch (RuntimeException e) {
            return new ProductReadDTO();
        }
    }

    @PutMapping()
    public ProductReadDTO updateProduct(@RequestBody ProductWriteDTO productWriteDTO) {
        try {
            return productService.updateProduct(ProductDTOMapper.toProduct(productWriteDTO));
        } catch (RuntimeException e) {
            return new ProductReadDTO();
        }
    }

    @DeleteMapping()
    public void deleteProduct(@RequestBody ProductWriteDTO productWriteDTO) {
        productService.deleteProduct(ProductDTOMapper.toProduct(productWriteDTO));
    }

}
