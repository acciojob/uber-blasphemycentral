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


}