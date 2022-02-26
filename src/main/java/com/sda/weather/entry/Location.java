package com.sda.weather.entry;


import lombok.Data;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@Entity
@Table(name = "Location") // todo prefer snake_case Location -> location
public class Location {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String country;

    private String region;

    private Float latitude; // todo nullable = false

    private Float longitude; // todo nullable = false

    public Float getLongitude(float longitude) { // todo remove it
        return this.longitude;
    }

    public void setLongitude(Float longitude) { // todo remove it
        this.longitude = longitude;
    }
}
