package com.carportal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.carportal.repository.BidRepository;
import com.carportal.entity.Cars;
import com.carportal.repository.CarsRepository;

@Service
public class CarsService {
	
	@Autowired
	CarsRepository carsRepo;
	

	public String addCars(Cars cars) {
		Cars response = carsRepo.save(cars);
		if (response == null) {
			return "Cars Not Added";
		}
		return "Car Added";
	}
	
	public List<Cars> listAllCars(){
		List<Cars> allCars = carsRepo.findAll();
		return allCars;
	}
	
	public Cars getId(int carId) {
		return carsRepo.findById(carId).get();	
	}
	
	public Cars carDetails(Integer carId){
		Optional<Cars> carDetail = carsRepo.findById(carId);
		Cars detCar = carDetail.get();
		return detCar;
	}
	
	public List<Cars> searchCars(String searchCars){
		return carsRepo.findCarsContain(searchCars);
	}
	
	public void deleteCars(Integer carId) {
		carsRepo.deleteById(carId);
	}
	
	public Cars carsInfo(Integer carId) {
		Optional<Cars> carInfo = carsRepo.findById(carId);
		Cars infoCars = carInfo.get();
		return infoCars;
	}
	
	
}
