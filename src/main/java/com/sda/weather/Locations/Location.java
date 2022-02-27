package com.sda.weather.Locations;


import lombok.Data;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@Entity
@Table(name = "location")
public class Location {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String country;

    private String region;

    @Column(nullable = false)
    private Float latitude;
    @Column(nullable = false)
    private Float longitude;


}
