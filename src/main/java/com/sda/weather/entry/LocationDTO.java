package com.sda.weather.entry;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.IDENTITY;
@Data
public class LocationDTO {

    private Long id;

    private String city;

    private String country;

    private String region;

    private Float latitude;

    private Float longitude;


}
