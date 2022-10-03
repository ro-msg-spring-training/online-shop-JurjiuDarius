package ro.msg.training.shop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ro.msg.training.shop.dto.mapper.ProductDTOMapper;
import ro.msg.training.shop.dto.product.ProductReadDTO;
import ro.msg.training.shop.dto.product.ProductWriteDTO;
import ro.msg.training.shop.service.ProductService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
	
	private final ProductService productService;
	
	@GetMapping()
	public List<ProductReadDTO> getProducts() {
		ArrayList<ProductReadDTO> products = new ArrayList<>();
		productService.getProducts().forEach(e -> products.add(ProductDTOMapper.toDto(e)));
		return products;
	}
	
	@GetMapping("/{id}")
	public ProductReadDTO getProductById(@PathVariable int id) {
		return ProductDTOMapper.toDto(productService.getProductById(id));
	}
	
	@PostMapping()
	public ProductReadDTO createProduct(@RequestBody ProductWriteDTO productWriteDTO) {
		return ProductDTOMapper.toDto(productService.createProduct(ProductDTOMapper.toProduct(productWriteDTO)));
	}
	
	@PutMapping()
	public ProductReadDTO updateProduct(@RequestBody ProductWriteDTO productWriteDTO) {
		return ProductDTOMapper.toDto(productService.createProduct(ProductDTOMapper.toProduct(productWriteDTO)));
	}
	
	@DeleteMapping()
	public void deleteProduct(@RequestBody ProductWriteDTO productWriteDTO) {
		productService.deleteProduct(ProductDTOMapper.toProduct(productWriteDTO));
	}
	
}
