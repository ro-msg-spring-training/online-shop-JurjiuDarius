package ro.msg.training.shop.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.msg.training.shop.entity.Location;
import ro.msg.training.shop.repository.LocationRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class LocationService {
	
	private final LocationRepository locationRepository;
	
	public Location getLocationById(int id) {
		Optional<Location> locationOptional = locationRepository.findById(id);
		if (locationOptional.isEmpty()) {
			throw new RuntimeException("Location does not exist");
		}
		return locationOptional.get();
	}
	
	public List<Location> getLocations() {
		ArrayList<Location> locations = new ArrayList<>();
		Iterable<Location> locationIterable = locationRepository.findAll();
		locationIterable.forEach(locations::add);
		return locations;
	}
	
	public Location createLocation(Location location) {
		return locationRepository.save(location);
	}
	
	public void deleteLocation(int id) {
		locationRepository.deleteById(id);
	}
	
}
