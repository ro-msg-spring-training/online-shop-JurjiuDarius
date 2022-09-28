package ro.msg.training.shop.dto;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ro.msg.training.shop.entity.Product;
import ro.msg.training.shop.entity.ProductCategory;
import ro.msg.training.shop.entity.Supplier;
import ro.msg.training.shop.repository.ProductCategoryRepository;
import ro.msg.training.shop.repository.ProductRepository;
import ro.msg.training.shop.repository.SupplierRepository;


public class ProductDTOMapper {
    public static ProductReadDTO toDto(Product product) {
        ProductReadDTO dto = new ProductReadDTO(product.getName(), product.getDescription(), product.getPrice(),
                product.getWeight(), product.getSupplier().getName(), product.getImageUrl(),
                product.getProductCategory().getId(), product.getProductCategory().getName(), product.getProductCategory().getDescription());

        return dto;
    }

    public static Product toProduct(ProductWriteDTO dto) {
        Product product = new Product();
        product.setId(dto.getId());
        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getPrice());
        product.setWeight(dto.getWeight());
        product.setImageUrl(dto.getImageUrl());
        Supplier supplier = new Supplier();
        supplier.setId(dto.getSupplierId());
        ProductCategory productCategory = new ProductCategory();
        productCategory.setId(dto.getProductCategoryId());
        product.setSupplier(supplier);
        product.setProductCategory(productCategory);
        return product;
    }

}
