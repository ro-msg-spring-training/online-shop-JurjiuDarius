package ro.msg.training.shop.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.msg.training.shop.entity.Product;
import ro.msg.training.shop.entity.ProductCategory;
import ro.msg.training.shop.entity.Supplier;
import ro.msg.training.shop.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
	
	private final ProductRepository productRepository;
	
	private final SupplierService supplierService;
	
	private final ProductCategoryService productCategoryService;
	
	public List<Product> getProducts() {
		Iterable<Product> productIterable = productRepository.findAll();
		ArrayList<Product> products = new ArrayList<>();
		productIterable.forEach(products::add);
		return products;
	}
	
	public Product getProductById(int id) throws RuntimeException {
		Optional<Product> product = productRepository.findById(id);
		if (product.isEmpty()) {
			throw new RuntimeException("Product not found");
		}
		return product.get();
	}
	
	public Product createProduct(Product product) {
		setSupplierAndCategory(product);
		productRepository.save(product);
		return product;
	}
	
	public void deleteProduct(Product product) {
		productRepository.deleteById(product.getId());
	}
	
	private void setSupplierAndCategory(Product product) {
		Supplier supplier = supplierService.getSupplierById(product.getSupplier().getId());
		ProductCategory productCategory = productCategoryService.getProductCategoryById(product.getProductCategory().getId());
		product.setSupplier(supplier);
		product.setProductCategory(productCategory);
	}
	
}
