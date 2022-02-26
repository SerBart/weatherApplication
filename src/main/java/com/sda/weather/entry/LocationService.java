package com.sda.weather.entry;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class LocationService {
    private final LocationRepository locationRepository;
    private final ObjectMapper objectMapper;

    Location createLocation(String city, String country, String region, float latitude, float longitude) {
        validateLocation(city, country, region, latitude, longitude);

        Location location = new Location();

        setLocations(city, country, region, latitude, longitude, location);

        return locationRepository.save(location);

    }

    private void setLocations(String city, String country, String region, float latitude, float longitude,
                              Location location) {
        location.setCity(city);
        location.setCountry(country);
        location.setRegion(region);
        location.getLongitude(longitude);
        location.setLatitude(latitude);
    }

    private void validateLocation(String city, String country, String region, float latitude, float longitude) {
        if (city == null) {
            throw new IllegalArgumentException("Please provide city name");
        }
        if (country == null) {
            throw new IllegalArgumentException("Please provide country name");
        }
        if (region == null) {
            throw new IllegalArgumentException("Please provide region name");
        }
        if (latitude > 90 || latitude < -90) {
            throw new IllegalArgumentException("Wrong latitude");
        }
        if (longitude > 180 || longitude < 180) {
            throw new IllegalArgumentException("Wrong longitude");
        }
    }
}
