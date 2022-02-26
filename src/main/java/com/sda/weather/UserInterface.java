package com.sda.weather;

import java.util.Random;
import java.util.Scanner;

public class UserInterface {

    public void run() {
        System.out.println("Cyber pogodynka :");
        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.println("Podaj co chcesz zrobić: ");
            System.out.println("1. Dodaj lokalizacje \n2. Wyswietl aktualne dane lokalizacji\n3. Pobierz wartosci " +
                    "pogodowe");

            int option = scanner.nextInt();

            switch (option){
                case 0:
                    return;
                case 1:
                    return;
            }
        }
    }
}
