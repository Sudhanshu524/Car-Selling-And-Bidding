package com.carportal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carportal.entity.CarsBidding;
import com.carportal.repository.BidRepository;

@Service
public class BidService {
	
	@Autowired
	BidRepository bidRepo;
	
	public String addBid(CarsBidding carBid) {
		CarsBidding response = bidRepo.save(carBid);
		if (response == null) {
			return "Bid Not Added";
		}
		return "Bid Added";
	}
	
	public List<CarsBidding> listCarBid(int idCar){
		List<CarsBidding> allBid = bidRepo.viewBid(idCar);
		return allBid;
	}

}
