package com.carportal.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CarList")
public class Cars {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int carId;
	private String carModel;
	private String carMake;
	private String registrationYear;
	private String price;
	private String description;
	
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="user_id")
    private User userCars;
    
    @Column(nullable = true, length = 64)
	private String photos;

    @Column(nullable = true, length = 64)
	private String photoImagePath;
	
	public Cars() {
		super();
	}

	public Cars(int carId, String carModel, String carMake, String registrationYear, String price, String description, String photos,String photoImagePath,
			User userCars) {
		super();
		this.carId = carId;
		this.carModel = carModel;
		this.carMake = carMake;
		this.registrationYear = registrationYear;
		this.price = price;
		this.description = description;
		this.photos = photos;
		this.photoImagePath = photoImagePath;
		this.userCars = userCars;
	}

	public int getCarId() {
		return carId;
	}

	public void setCarId(int carId) {
		this.carId = carId;
	}

	public String getCarModel() {
		return carModel;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}

	public String getCarMake() {
		return carMake;
	}

	public void setCarMake(String carMake) {
		this.carMake = carMake;
	}

	public String getRegistrationYear() {
		return registrationYear;
	}

	public void setRegistrationYear(String registrationYear) {
		this.registrationYear = registrationYear;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getPhotos() {
		return photos;
	}

	public void setPhotos(String photos) {
		this.photos = photos;
	}

	public String getPhotoImagePath() {
		return photoImagePath;
	}

	public void setPhotoImagePath(String photoImagePath) {
		this.photoImagePath = photoImagePath;
	}


	public User getUserCars() {
		return userCars;
	}

	public void setUserCars(User userCars) {
		this.userCars = userCars;
	}

	@Override
	public String toString() {
		return "Cars [carId=" + carId + ", carModel=" + carModel + ", carMake=" + carMake + ", registrationYear="
				+ registrationYear + ", price=" + price + ", description=" + description + ", userCars=" + userCars
				+ "] + \n";
	}
	
	
}
