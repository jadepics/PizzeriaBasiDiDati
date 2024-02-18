package org.example.view;

import org.example.model.domain.BevandeOrd;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BaristaView {
    public static int showMenuBarista() throws IOException {
        System.out.println("*********************************");
        System.out.println("*    BARISTA DASHBOARD    *");
        System.out.println("*********************************\n");
        System.out.println("*** What should I do for you? ***\n");
        System.out.println("1) bevande da preparare");
        System.out.println("2) segna bevanda pronta");
        System.out.println("3) quit");


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


    public static BevandeOrd bevandaPronta() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("inserisci la bevanda che hai preparato: ");
        String bevanda = (reader.readLine());
        System.out.print("inserisci il tavolo: ");
        int idTavolo = Integer.parseInt((reader.readLine()));
        System.out.print("inserisci la quantità: ");
        int quantità = Integer.parseInt((reader.readLine()));
        BevandeOrd bevandeOrd = new BevandeOrd(idTavolo,quantità, bevanda);

        return bevandeOrd;
    }

}
