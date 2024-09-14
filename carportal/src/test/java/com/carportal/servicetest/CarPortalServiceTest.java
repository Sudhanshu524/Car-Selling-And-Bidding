 package com.carportal.servicetest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.not;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.carportal.service.BidService;
import com.carportal.service.CarsService;
import com.carportal.service.UserService;
import com.fasterxml.jackson.databind.introspect.AnnotationCollector.NoAnnotations;
import com.carportal.entity.Cars;
import com.carportal.entity.CarsBidding;
import com.carportal.entity.User;
import com.carportal.repository.BidRepository;
import com.carportal.repository.CarsRepository;
import com.carportal.repository.UserRepository;

@RunWith(MockitoJUnitRunner.class)
public class CarPortalServiceTest {
	
	@InjectMocks
	UserService uService;
	@InjectMocks
	CarsService cService;
	@InjectMocks
	BidService bService;
	@Mock
	BCryptPasswordEncoder passwordencoder;
	@Mock
	UserRepository uRepo;
	@Mock
	CarsRepository cRepo;
	@Mock
	BidRepository bRepo;
	
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void register() {
		User user = new User();
		user.setUsername("Fellasio");
		user.setFullName("MaFellasCosina");
		user.setPassword("12345678");
		Mockito.when(uRepo.save(user)).thenReturn(user);
		String storeReponse = uService.addUser(user);
		Assert.assertEquals("User Added", storeReponse);
	}
	
	@Test
	public void postCar() {
		Cars cars = new Cars();
		cars.setCarMake("Toyota");
		cars.setCarModel("Avanza");
		cars.setRegistrationYear("2020");
		cars.setPrice("13500");
		cars.setDescription("Description");

		Mockito.when(cRepo.save(cars)).thenReturn(cars);
		String storeReponse = cService.addCars(cars);
		Assert.assertEquals("Car Added", storeReponse);
	}
	
	@Test
	public void bidCars() {
		CarsBidding carsBidding = new CarsBidding();
		carsBidding.setBidPrice("16000");
		Mockito.when(bRepo.save(carsBidding)).thenReturn(carsBidding);
		String storeReponse = bService.addBid(carsBidding);
		Assert.assertEquals("Bid Added", storeReponse);
	}
	
	@Test
	public void searchCar() {
		List<Cars> cars = cService.searchCars("Mazda");
		assertThat(cars).isNotEmpty();
	}
	
}
