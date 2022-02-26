package com.sda.weather.entry;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class LocationController {
    private final LocationService locationService;
    private final ObjectMapper objectMapper;

    String createLocation(String data) {
        try {
            LocationDTO requestBody = objectMapper.readValue(data, LocationDTO.class);
            Location savedLocation = locationService.createLocation(requestBody.getCity(), requestBody.getCity(), // todo City, COUNTRY...
                    requestBody.getRegion(), requestBody.getLatitude(), requestBody.getLongitude());
            LocationDTO responseBody = mapToLocationDTO(savedLocation);
            return objectMapper.writeValueAsString(responseBody);
        } catch (Exception e) {
            return String.format("{\"message\":\"%s\"}", e.getMessage());
        }
    }

    private LocationDTO mapToLocationDTO(Location savedLocation) {
        LocationDTO responseBody = new LocationDTO();
        responseBody.setCity(savedLocation.getCity());
        responseBody.setCountry(savedLocation.getCountry());
        responseBody.setRegion(savedLocation.getRegion());
        responseBody.setLatitude(savedLocation.getLatitude());
        responseBody.setLongitude(savedLocation.getLongitude());
        return responseBody;
    }
}
