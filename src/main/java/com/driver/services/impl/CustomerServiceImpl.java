package com.driver.services.impl;

import com.driver.model.TripBooking;
import com.driver.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.driver.model.Customer;
import com.driver.model.Driver;
import com.driver.repository.CustomerRepository;
import com.driver.repository.DriverRepository;
import com.driver.repository.TripBookingRepository;
import com.driver.model.TripStatus;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository2;

	@Autowired
	DriverRepository driverRepository2;

	@Autowired
	TripBookingRepository tripBookingRepository2;

	@Override
	public void register(Customer customer)
	{
		//Save the customer in database
		customerRepository2.save(customer);
	}

	@Override
	public void deleteCustomer(Integer customerId)
	{
		// Delete customer without using deleteById function
		customerRepository2.deleteById(customerId);
	}

	@Override
	public TripBooking bookTrip(int customerId, String fromLocation, String toLocation, int distanceInKm) throws Exception
	{
		//Book the driver with lowest driverId who is free (cab available variable is Boolean.TRUE).
		// If no driver is available, throw "No cab available!" exception
		//Avoid using SQL query
		Driver diver;
		List<Driver> list = driverRepository2.findAll();
		for(Driver driver : list)
		{
			if(driver.getCab().getAvailable())
			{
				TripBooking trip = new TripBooking();
				Customer customer = customerRepository2.findById(customerId).get();

				trip.setFromLocation(fromLocation);
				trip.setToLocation(toLocation);
				trip.setStatus(TripStatus.CONFIRMED);
				trip.setDistanceInKm(distanceInKm);
				trip.setDriver(driver);
				trip.setCustomer(customer);

				driver.getTripBookingList().add(trip);
				driver.getCab().setAvailable(false);

				customer.getTripBookingList().add(trip);

				driverRepository2.save(driver);
				customerRepository2.save(customer);

				return trip;
			}
		}
		throw new Exception("No cab available");
	}

	@Override
	public void cancelTrip(Integer tripId)
	{
		//Cancel the trip having given trip Id and update TripBooking attributes accordingly
		TripBooking trip = tripBookingRepository2.findById(tripId).get();
		trip.setStatus(TripStatus.CANCELED);
		trip.setBill(0);
		trip.getDriver().getCab().setAvailable(true);
		tripBookingRepository2.save(trip);
	}

	@Override
	public void completeTrip(Integer tripId)
	{
		//Complete the trip having given trip Id and update TripBooking attributes accordingly
		TripBooking trip = tripBookingRepository2.findById(tripId).get();
		trip.setStatus(TripStatus.COMPLETED);
		trip.setBill(trip.getDistanceInKm()*trip.getDriver().getCab().getPerKmRate());
		trip.getDriver().getCab().setAvailable(true);

		tripBookingRepository2.save(trip);
	}
}
