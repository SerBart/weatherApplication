package com.sda.weather;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sda.weather.Locations.LocationController;
import com.sda.weather.Locations.LocationHibernateRepository;
import com.sda.weather.Locations.LocationRepository;
import com.sda.weather.Locations.LocationService;
import lombok.RequiredArgsConstructor;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

@RequiredArgsConstructor
public class Application {

    public static void main(String[] args) {
        System.out.println("Michal tu byl");

        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure()
                .build();

        SessionFactory sessionFactory = new MetadataSources(registry)
                .buildMetadata()
                .buildSessionFactory();

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        LocationRepository locationRepository = new LocationHibernateRepository(sessionFactory);
        LocationService locationService = new LocationService(locationRepository, objectMapper);
        LocationController locationController = new LocationController(locationService, objectMapper);
        UserInterface userInterface = new UserInterface(locationController);
        userInterface.run();
    }
}
