package ro.msg.training.shop.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.msg.training.shop.entity.ProductCategory;
import ro.msg.training.shop.repository.ProductCategoryRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ProductCategoryService {
	
	private final ProductCategoryRepository productCategoryRepository;
	
	public ProductCategory getProductCategoryById(int id) {
		Optional<ProductCategory> productCategoryOptional = productCategoryRepository.findById(id);
		if (productCategoryOptional.isEmpty()) {
			throw new RuntimeException("ProductCategory does not exist");
		}
		return productCategoryOptional.get();
	}
	
	public List<ProductCategory> getProductCategorys() {
		ArrayList<ProductCategory> productCategorys = new ArrayList<>();
		Iterable<ProductCategory> productCategoryIterable = productCategoryRepository.findAll();
		productCategoryIterable.forEach(productCategorys::add);
		return productCategorys;
	}
	
	public ProductCategory createProductCategory(ProductCategory productCategory) {
		return productCategoryRepository.save(productCategory);
	}
	
	public void deleteProductCategory(int id) {
		productCategoryRepository.deleteById(id);
	}
	
}
