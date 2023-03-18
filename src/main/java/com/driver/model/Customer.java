package com.driver.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int customerId;

    String mobile;

    String password;

    @OneToMany (mappedBy = "customer", cascade = CascadeType.ALL)
    List<TripBooking> tripBookingList = new ArrayList<>();

    public String getMobile()
    {
        return mobile;
    }

    public void setMobile(String mobile)
    {
        this.mobile = mobile;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public List<TripBooking> getTripBookingList()
    {
        return tripBookingList;
    }

    public void setTripBookingList(List<TripBooking> tripBookingList)
    {
        this.tripBookingList = tripBookingList;
    }
}