package com.sda.weather;

import java.sql.SQLOutput;
import java.util.Random;
import java.util.Scanner;

public class UserInterface {

    public void run() {
        System.out.println("Cyber pogodynka :");
        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.println("Podaj co chcesz zrobić: ");
            System.out.println("0. Wyjdz z aplikacji\n1. Dodaj nowa lokalizacja");

            int option = scanner.nextInt();

            switch (option){
                case 1:
                    createEntry();
                    break;
                case 0:
                    return;

            }

        }
    }

    private void createEntry(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Kraj: ");
        String country = scanner.nextLine();
        System.out.println("Miasto: ");
        String city = scanner.nextLine();
        System.out.println("Region: ");
        String region = scanner.next();
        System.out.println("Szerokosc geograficzna: ");
        float latitude = scanner.nextFloat();
        System.out.println("Dlugosc Geograficzna: ");
        float longitude = scanner.nextFloat();

        String request = String.format("{\"City \":\"%s\",\"Country \":\"%s\",\"Region\":\"%s\",\"Latitude\":\"%s\"" +
                "Longitude\":\"%s\"", city, country, region, latitude, longitude);
        System.out.println("Dodano pogodę dla " + request);

    }
}
