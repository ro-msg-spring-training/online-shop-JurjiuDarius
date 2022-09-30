package ro.msg.training.shop.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.msg.training.shop.entity.Supplier;
import ro.msg.training.shop.repository.SupplierRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class SupplierService {
	
	private final SupplierRepository supplierRepository;
	
	public Supplier getSupplierById(int id) {
		Optional<Supplier> supplierOptional = supplierRepository.findById(id);
		if (supplierOptional.isEmpty()) {
			throw new RuntimeException("Supplier does not exist");
		}
		return supplierOptional.get();
	}
	
	public List<Supplier> getSuppliers() {
		ArrayList<Supplier> suppliers = new ArrayList<>();
		Iterable<Supplier> supplierIterable = supplierRepository.findAll();
		supplierIterable.forEach(suppliers::add);
		return suppliers;
	}
	
	public Supplier createSupplier(Supplier supplier) {
		return supplierRepository.save(supplier);
	}
	
	public void deleteSupplier(int id) {
		supplierRepository.deleteById(id);
	}
	
}
