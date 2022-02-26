package com.sda.weather;

public class Application {

    public static void main(String[] args) {
        // todo create a controller, service, repository
        UserInterface userInterface = new UserInterface();
        userInterface.run();
    }
}
