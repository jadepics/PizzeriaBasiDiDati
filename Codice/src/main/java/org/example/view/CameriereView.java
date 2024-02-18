package org.example.view;

import org.example.model.domain.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

import static java.sql.Types.NULL;

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

    public static ComandaResult prendiComanda() throws IOException {
        Comanda comanda;
        BevandeOrd  bevandeOrd;
        PizzaOrd pizzaOrd;
        ComandaResult comandaResult = null;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Numero Tavolo: ");
        int idTavolo = Integer.parseInt((reader.readLine()));
        System.out.print("Nome Pizza: ");
        String pizza = (reader.readLine());
        System.out.print("quantità pizza: ");
        int quantita = Integer.parseInt((reader.readLine()));
        System.out.print("Nome Bevanda: ");
        String bevanda = (reader.readLine());
        System.out.print("quantità bevanda: ");
        int quantitaBev = Integer.parseInt((reader.readLine()));
        comanda= new Comanda(null, idTavolo, 0);
        bevandeOrd= new BevandeOrd(quantitaBev, bevanda);
        pizzaOrd= new PizzaOrd(quantita, pizza);
        comandaResult= new ComandaResult(comanda, bevandeOrd, pizzaOrd);

        return comandaResult;
    }


    public static int visualizzaTavoliAssegnati() throws IOException {
        int idCameriere;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Inserisci il tuo ID: ");
        idCameriere = Integer.parseInt((reader.readLine()));

        return idCameriere;
    }

    public static int visualizzaComandePronte() throws IOException {
        int idCameriere;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Inserisci il tuo ID: ");
        idCameriere = Integer.parseInt((reader.readLine()));

        return idCameriere;
    }
}
