package com.driver.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TripBooking
{
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    int tripBookingId;

    String fromLocation;

    String toLocation;

    int distanceInKm;

    TripStatus tripStatus;

    int bill;

    @ManyToOne
    @JoinColumn
    Customer customer;

    @ManyToOne
    @JoinColumn
    Driver driver;

    public int getTripBookingId()
    {
        return tripBookingId;
    }

    public void setTripBookingId(int tripBookingId)
    {
        this.tripBookingId = tripBookingId;
    }

    public String getFromLocation()
    {
        return fromLocation;
    }

    public void setFromLocation(String fromLocation)
    {
        this.fromLocation = fromLocation;
    }

    public String getToLocation()
    {
        return toLocation;
    }

    public void setToLocation(String toLocation)
    {
        this.toLocation = toLocation;
    }

    public int getDistanceInKm()
    {
        return distanceInKm;
    }

    public void setDistanceInKm(int distanceInKm)
    {
        this.distanceInKm = distanceInKm;
    }

    public TripStatus getTripStatus()
    {
        return tripStatus;
    }

    public void setTripStatus(TripStatus tripStatus)
    {
        this.tripStatus = tripStatus;
    }

    public int getBill()
    {
        return bill;
    }

    public void setBill(int bill)
    {
        this.bill = bill;
    }

    public Customer getCustomer()
    {
        return customer;
    }

    public void setCustomer(Customer customer)
    {
        this.customer = customer;
    }

    public Driver getDriver()
    {
        return driver;
    }

    public void setDriver(Driver driver)
    {
        this.driver = driver;
    }
}