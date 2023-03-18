package com.driver.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cab
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    int perKmRate;

    boolean available;

    @OneToOne(mappedBy = "cab", cascade = CascadeType.ALL)
    Driver driver;

    public int getPerKmRate()
    {
        return perKmRate;
    }

    public void setPerKmRate(int perKmRate)
    {
        this.perKmRate = perKmRate;
    }

    public boolean isAvailable()
    {
        return available;
    }

    public void setAvailable(boolean available)
    {
        this.available = available;
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