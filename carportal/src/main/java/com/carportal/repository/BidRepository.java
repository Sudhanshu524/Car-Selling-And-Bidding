package com.carportal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.carportal.entity.CarsBidding;

@Repository
public interface BidRepository extends JpaRepository<CarsBidding, Integer> {
	
	@Query(value = "SELECT * FROM car_bidding WHERE car_id = :idCar ORDER BY bid_price DESC", nativeQuery = true)
	List<CarsBidding> viewBid(@Param("idCar")int idCar);

}
