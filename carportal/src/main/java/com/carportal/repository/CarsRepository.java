package com.carportal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.carportal.entity.Cars;
import java.lang.String;

@Repository
public interface CarsRepository extends JpaRepository<Cars, Integer>{
	
	List<Cars> findByCarMake(String carmake);
	
	@Query(value = "SELECT * FROM car_list WHERE car_make LIKE %:search% OR car_model LIKE %:search% OR registration_year LIKE %:search%", nativeQuery = true)
	List<Cars> findCarsContain(@Param("search")String search);

}
