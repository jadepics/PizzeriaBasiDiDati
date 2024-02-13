package org.example.view;

import java.io.IOException;
import java.util.Scanner;

public class CameriereView {

    public static int showMenu() throws IOException {
        System.out.println("*********************************");
        System.out.println("*    Pizzeria Menù   *");
        System.out.println("*********************************\n");
        System.out.println("*** Cosa vuoi fare? ***\n");
        System.out.println("1) Prendi Comanda");
        System.out.println("2) Visualizza Comanda pronta");
        System.out.println("3) Visualizza Tavoli");
        System.out.println("4) Quit");


        Scanner input = new Scanner(System.in);
        int choice = 0;
        while (true) {
            System.out.print("Please enter your choice: ");
            choice = input.nextInt();
            if (choice >= 1 && choice <= 4) {
                break;
            }
            System.out.println("Invalid option");
        }

        return choice;
    }
}
