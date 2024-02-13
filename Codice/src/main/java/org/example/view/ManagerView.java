package org.example.view;

import java.io.IOException;
import java.util.Scanner;

public class ManagerView {

    public static int showMenu() throws IOException {
        System.out.println("*********************************");
        System.out.println("*    Pizzeria Menù   *");
        System.out.println("*********************************\n");
        System.out.println("*** Cosa vuoi fare? ***\n");
        System.out.println("1) Assegna Tavolo nuovo cliente");
        System.out.println("2) Genera Scontrino Tavolo");
        System.out.println("3) Visualizza Tavoli Liberi");
        System.out.println("4) Visualizza statistiche giornaliere");
        System.out.println("5) Visualizza statistiche mensili");
        System.out.println("6) Quit");


        Scanner input = new Scanner(System.in);
        int choice = 0;
        while (true) {
            System.out.print("Please enter your choice: ");
            choice = input.nextInt();
            if (choice >= 1 && choice <= 6) {
                break;
            }
            System.out.println("Invalid option");
        }

        return choice;
    }
}


