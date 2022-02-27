package com.sda.weather.Locations;

import lombok.Data;

@Data
public class LocationDTO {

    private Long id;

    private String city;

    private String country;

    private String region;

    private Float latitude;

    private Float longitude;
}
