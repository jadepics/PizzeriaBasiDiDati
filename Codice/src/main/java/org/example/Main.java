package org.example;

import org.example.controller.ApplicationController;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        ApplicationController applicationController = new ApplicationController();
        applicationController.start();
    }
}