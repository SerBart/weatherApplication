package com.sda.weather;

import java.util.Scanner;

public class UserInterface {

    public void run() {
        System.out.println("Cyber pogodynka :");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Podaj co chcesz zrobić: ");
            System.out.println("1. Hehe");
            System.out.println("0. Wyjdz z aplikacji");

            int option = scanner.nextInt();

            switch (option) {
                case 0:
                    return;
            }
        }
    }
}
