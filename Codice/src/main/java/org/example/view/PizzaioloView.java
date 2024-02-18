package org.example.view;

import org.example.model.domain.PizzaOrd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class PizzaioloView {

    public static int showMenuPizzaiolo() throws IOException {
        System.out.println("*********************************");
        System.out.println("*    PIZZAIOLO DASHBOARD    *");
        System.out.println("*********************************\n");
        System.out.println("*** What should I do for you? ***\n");
        System.out.println("1) pizze da preparare");
        System.out.println("2) segna pizza pronta");
        System.out.println("3) quit");


        Scanner input = new Scanner(System.in);
        int choice = 0;
        while (true) {
            System.out.print("Please enter your choice: ");
            choice = input.nextInt();
            if (choice >= 1 && choice <= 3) {
                break;
            }
            System.out.println("Invalid option");
        }

        return choice;
    }



    public static PizzaOrd pizzaPronta() throws IOException {         //scrivere che una pizza è stata preparata
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("inserisci la pizza che hai preparato: ");
        String pizza = (reader.readLine());
        System.out.print("inserisci il tavolo: ");
        int idTavolo = Integer.parseInt((reader.readLine()));
        System.out.print("inserisci la quantità: ");
        int quantità = Integer.parseInt((reader.readLine()));
        PizzaOrd pizzaOrd = new PizzaOrd(idTavolo,quantità, pizza);
        return pizzaOrd;
    }
}