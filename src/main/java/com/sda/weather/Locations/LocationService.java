package com.sda.weather.Locations;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class LocationService {

    private final LocationRepository locationRepository;
    private final ObjectMapper objectMapper;

    Location createLocation(String city, String country, String region, Float latitude, Float longitude) {
        validateLocation(city, country, region, latitude, longitude);
        Location location = setLocations(city, country, region, latitude, longitude);
        return locationRepository.save(location);
    }

    private Location setLocations(String city, String country, String region, Float latitude, Float longitude) {

        Location location = new Location();
        location.setCity(city);
        location.setCountry(country);
        location.setRegion(region);
        location.setLongitude(longitude);
        location.setLatitude(latitude);
        return location;
    }

    private void validateLocation(String city, String country, String region, float latitude, float longitude) {
        if (city == null || city.isBlank()) {
            throw new IllegalArgumentException("Please provide city name");
        }
        if (country == null || country.isBlank()) {
            throw new IllegalArgumentException("Please provide country name");
        }

        if (latitude > 90 || latitude < -90) {
            throw new IllegalArgumentException("Wrong latitude");
        }
        if (longitude > 180 || longitude < -180) {
            throw new IllegalArgumentException("Wrong longitude");
        }
    }
}
