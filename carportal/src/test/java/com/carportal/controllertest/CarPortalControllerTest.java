package com.carportal.controllertest;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import com.carportal.controller.CarPortalController;
import com.carportal.entity.Cars;
import com.carportal.service.BidService;
import com.carportal.service.CarsService;
import com.carportal.service.UserService;

@RunWith(MockitoJUnitRunner.class)
public class CarPortalControllerTest {
	
	@InjectMocks
	CarPortalController cpController;
	@Mock
	UserService uServie;
	@Mock
	CarsService cServie;
	@Mock
	BidService bServie;
	
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}


}
