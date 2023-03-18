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
}