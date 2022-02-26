package com.sda.weather;

import com.sda.weather.entry.LocationController;

import java.util.Scanner;

public class UserInterface {

    private final LocationController locationController;

    public UserInterface(LocationController locationController) {
        this.locationController = locationController;

    }


    public void run() {
        System.out.println("Cyber pogodynka :");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Podaj co chcesz zrobić: ");
            System.out.println("0. Wyjdz z aplikacji\n1. Dodaj nowa lokalizacja");

            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    createEntry();
                    break;
                case 0:
                    return;
            }
        }
    }

    private void createEntry() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Kraj: ");
        String country = scanner.nextLine();
        System.out.println("Miasto: ");
        String city = scanner.nextLine();
        System.out.println("Region: ");
        String region = scanner.next();
        System.out.println("Szerokosc geograficzna: ");
        Float latitude = scanner.nextFloat();
        System.out.println("Dlugosc Geograficzna: ");
        Float longitude = scanner.nextFloat();

        String request = String.format("{\"city\":\"%s\",\"country\":\"%s\",\"region\":\"%s\",\"latitude\":\"%f\"" +
                "longitude\":\"%f\"", city, country, region, latitude, longitude);
        System.out.println("Dodano pogodę dla " + request);
        String response = locationController.createLocation(request);
        System.out.println("odpowiedz serwera" + response);

    }
}
