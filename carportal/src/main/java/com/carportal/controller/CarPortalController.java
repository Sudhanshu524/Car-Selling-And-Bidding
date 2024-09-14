package com.carportal.controller;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.carportal.entity.Cars;
import com.carportal.entity.CarsBidding;
import com.carportal.entity.User;
import com.carportal.security.ApplicationUserDetail;
import com.carportal.service.BidService;
import com.carportal.service.CarsService;
import com.carportal.service.UserService;

@Controller
public class CarPortalController {
	
	@Autowired
	UserService userService;
	@Autowired
	CarsService carsService;
	@Autowired
	BidService bidService;
	
	//Index and Register
	@GetMapping(value = "/")
	public String index(@ModelAttribute("register")User user) {
		return "index";
	}
	
	@PostMapping(value = "/register")
	public String register(@ModelAttribute("register")User user, Model model, @RequestParam String username){
		String unameRegister = userService.register(username);
		System.out.println(unameRegister);
		if (unameRegister.equals("0")) {
			userService.addUser(user);
			System.out.println(user);
			model.addAttribute("okError", "Regsitartion Success. Now login please");
			return "login";
		} else {
			model.addAttribute("ExistUname", "*Username already registered*");
			System.out.println("Username already registered");
			return "index";
		}
	}
	
	//Login
	@GetMapping(value = "/login")
	public String login(Model model, String error) {
		if(error != null) {
            System.out.println(error);
            model.addAttribute("loginError", "Your username or password is wrong");
        }
		return "login";
	}
	
	
	//Home
	@GetMapping(value = "/cars")
	public ModelAndView viewCars(@ModelAttribute("searchCars")Cars cars, @AuthenticationPrincipal ApplicationUserDetail appUserDet, HttpSession ses) {
		List<Cars> allCars = carsService.listAllCars();
		
		String username = appUserDet.getUsername();
		User us= userService.login(username);
		ses.setAttribute("userId", us.getUserId());
		ses.setAttribute("role", us.getRole());
		ses.setAttribute("fullName", us.getFullName());
		ses.setAttribute("uname", us.getUsername());
		ses.setAttribute("pass", us.getPassword());
		/* ses.setAttribute("photos", cars.getPhotos()); */
//		model.addAttribute("listCars", allCars);
		return new ModelAndView("viewCars", "listCars", allCars);
	}
	
	//Search
	@PostMapping(value = "/searchCars")
	public String searchCars(@ModelAttribute("searchCars")Cars cars, Model model) {
		String searchCars= cars.getCarMake();
		List<Cars> lc = carsService.searchCars(searchCars);
		model.addAttribute("listCars", lc);
		return "viewCars";
	}
	
	//Car Details
	@GetMapping(value = "/carDetails")
	public ModelAndView detailsCars(@RequestParam int carId, @ModelAttribute("carBid")CarsBidding carsBid, Model model) {
		Cars detailCar=carsService.carDetails(carId);
		System.out.println("Car Details Here");
		List<CarsBidding> bidCars=bidService.listCarBid(carId);
		System.out.println(bidCars);
		model.addAttribute("carBidding", bidCars);
		return new ModelAndView("carDetails", "carDet", detailCar) ;
	}
	
	//Bid Cars
	@PostMapping(value = "/bidCars")
	public String bidCars(@ModelAttribute("carBid")CarsBidding carBid) {
		System.out.println("Bidding kagak?");
		bidService.addBid(carBid);
		System.out.println("Bid added");
		return "redirect:/cars";
	}
	
	//Add Cars
	@GetMapping(value = "/addCars")
	public String addCar(@ModelAttribute("addCars")Cars cars) {
		return "addCars";
	}
	
	@PostMapping(value = "/addCars")
	public String carAdded(@ModelAttribute("addCars")Cars cars, Model model, @RequestParam("fileImage") MultipartFile multipartFile, Principal principal) throws IOException {
		
		String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
		
		cars.setPhotos(fileName);
		
		carsService.addCars(cars);
		
		
		String uploadDir = "./src/main/resources/static/images/car-photo/" + cars.getCarId();
		
		Path uploadPath = Paths.get(uploadDir);

		if (!Files.exists(uploadPath)) {
			Files.createDirectories(uploadPath);
		}

		try (InputStream inputStream = multipartFile.getInputStream()) {
			Path filePath = uploadPath.resolve(fileName);
			System.out.println(filePath.toFile().getAbsolutePath());
			Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			throw new IOException("Could not save uploaded file: " + fileName);

		}

		cars.setPhotoImagePath("/images/car-photo/" + cars.getCarId() + "/" + cars.getPhotos());
		model.addAttribute("CarAdded", "Success!!! Car is added");
		
	
		System.out.println(cars);
		return "addCars";
	}
	
	//Update Car / Edit Cars
	@GetMapping(value = "/updateCars/{carId}")
	public String updateCars(@PathVariable int carId, Model model) {
		Cars carInfo = carsService.carsInfo(carId);
		model.addAttribute("addCars", carInfo);
		System.out.println(carInfo);
		return "addCars";
	}
	
	//Delete Cars
	@GetMapping(value = "/deleteCars/{carId}")
	public String deleteCars(@PathVariable int carId) {
		carsService.deleteCars(carId);
		return "redirect:/cars";
	}
	
	//Delete Users
	@GetMapping(value = "/deleteUsers")
	public String deleteUsers(@RequestParam int userId) {
		userService.deleteUser(userId);
		return "redirect:/cars";
	}
	
	//View All User
	@GetMapping(value = "/allUser")
	public String allUser(@ModelAttribute("searchUser")User user, Model model) {
		List<User> allUser = userService.listAllUser();
		model.addAttribute("listUsers", allUser);
		return "allUser";
	}
	
	//Search User
	@GetMapping(value = "/searchUser")
	public String searchUser(@ModelAttribute("searchUser")User user, Model model) {
		String searchUser= user.getFullName();
		List<User> lu = userService.searchUser(searchUser);
		model.addAttribute("listUsers", lu);
		return "allUser";
	}
	
	//Update Profile
	@GetMapping(value = "/updateProfile")
	public String updateUser(@RequestParam int userId, Model model) {
		User userInfo = userService.usersInfo(userId);
		model.addAttribute("update", userInfo);
		System.out.println("View and Update User");
		return "updateProfile";
	}
	
	@PostMapping(value = "/profileUpdated")
	public String userUpdated(@ModelAttribute("update")User user) {
		userService.updateUser(user);
		return "redirect:/cars";
	}
	
	//View Profile
	@GetMapping(value = "/profile")
	public String Profile() {
		return "profile";
	}
	
	//About Us
	@GetMapping(value = "/aboutUs")
	public String aboutUs() {
		return "aboutUs";
	}
	
	//Contact Us
	@GetMapping(value = "/contactUs")
	public String contactUs() {
		return "contactUs";
	}
	
	@GetMapping(value = "/AccessDenied")
	public String accessDenied() {
		return "accessDenied";
	}
	
	/*
	 * @PostMapping("/uploadImage") public String
	 * uploadImage(@RequestParam("imageFile") MultipartFile imageFile) { String
	 * returnValue =""; carsService.saveImage(imageFile);
	 * 
	 * return returnValue; }
	 */
}
