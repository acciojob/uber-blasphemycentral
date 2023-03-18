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
public class Driver
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int driverId;

    String mobile;

    String password;

    @OneToOne
    @JoinColumn
    Cab cab;

    @OneToMany (mappedBy = "driver", cascade = CascadeType.ALL)
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

    public Cab getCab()
    {
        return cab;
    }

    public void setCab(Cab cab)
    {
        this.cab = cab;
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