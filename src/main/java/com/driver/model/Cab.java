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

    boolean Available;

    @OneToOne(mappedBy = "cab", cascade = CascadeType.ALL)
    Driver driver;

    public boolean getAvailable()
    {
        return Available;
    }

    public void setAvailable(boolean available)
    {
        Available = available;
    }
}