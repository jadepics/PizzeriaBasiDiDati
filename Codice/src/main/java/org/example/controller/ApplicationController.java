package org.example.controller;


import org.example.model.domain.Credentials;

import java.io.IOException;

public class ApplicationController implements Controller {
    Credentials cred;

    @Override
    public void start() throws IOException {
        LoginController loginController = new LoginController();
        loginController.start();
        cred = loginController.getCred();

        if(cred.getRole() == null) {
            throw new RuntimeException("Invalid credentials");
        }

        switch(cred.getRole()) {
            case CAMERIERE -> new CameriereController().start();
            case MANAGER -> new ManagerController().start();
            case PIZZAIOLO -> new PizzaioloController().start();
            case BARISTA -> new BaristaController().start();
            default -> throw new RuntimeException("Invalid credentials");
        }
    }
}
