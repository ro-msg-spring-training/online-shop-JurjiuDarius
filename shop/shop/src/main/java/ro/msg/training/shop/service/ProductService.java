package ro.msg.training.shop.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ro.msg.training.shop.dto.ProductDTOMapper;
import ro.msg.training.shop.dto.ProductReadDTO;
import ro.msg.training.shop.entity.Product;
import ro.msg.training.shop.entity.ProductCategory;
import ro.msg.training.shop.entity.Supplier;
import ro.msg.training.shop.repository.ProductCategoryRepository;
import ro.msg.training.shop.repository.ProductRepository;
import ro.msg.training.shop.repository.SupplierRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ProductService {

    private ProductRepository productRepository;
    private SupplierRepository supplierRepository;
    private ProductCategoryRepository productCategoryRepository;

    public ProductService(ProductRepository productRepository, SupplierRepository supplierRepository,
                          ProductCategoryRepository productCategoryRepository) {
        this.productRepository = productRepository;
        this.supplierRepository = supplierRepository;
        this.productCategoryRepository = productCategoryRepository;
    }


    public List<ProductReadDTO> allProducts() {
        log.info("Retrieving products from the database");
        Iterable<Product> products = productRepository.findAll();
        System.out.println(products.iterator().next().getName());
        log.info("Retrieved products from the database");
        List<ProductReadDTO> productReadDTOList = new ArrayList<>();
        products.forEach(e -> {
            productReadDTOList.add(ProductDTOMapper.toDto(e));
        });
        return productReadDTOList;
    }

    public ProductReadDTO findById(int id) throws RuntimeException {
        Optional<Product> product = productRepository.findById(id);
//        if (product.isEmpty()) {
//            throw
//                    new RuntimeException("The Product does not exist");
//        }
        return ProductDTOMapper.toDto(product.get());
    }

    public ProductReadDTO save(Product product) {

        setSupplierAndCategory(product);
        productRepository.save(product);
        return ProductDTOMapper.toDto(product);
    }

    public ProductReadDTO updateProduct(Product product) {
        setSupplierAndCategory(product);
        log.info("This is the id of the product that was updated" + Integer.toString(product.getId()));
        productRepository.save(product);
        return ProductDTOMapper.toDto(product);
    }

    private void setSupplierAndCategory(Product product) {
        Optional<Supplier> optionalSupplier = supplierRepository.findById(product.getSupplier().getId());
        if (optionalSupplier.isEmpty()) {
            throw new RuntimeException("Supplier does not exist");
        }
        Supplier supplier = optionalSupplier.get();
        Optional<ProductCategory> optionalProductCategory = productCategoryRepository.findById(product.getProductCategory().getId());
        if (optionalProductCategory.isEmpty()) {
            throw new RuntimeException("Product category does not exist");
        }
        ProductCategory productCategory = optionalProductCategory.get();
        product.setSupplier(supplier);
        product.setProductCategory(productCategory);
    }

    public void deleteProduct(Product product) {
        productRepository.deleteById(product.getId());
    }

}
