package org.example.view;

import org.example.model.domain.Bevande;
import org.example.model.domain.Cliente;
import org.example.model.domain.Pizza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManagerView {

    public static int showMenu() throws IOException {
        System.out.println("*********************************");
        System.out.println("*    Manager Menù   *");
        System.out.println("*********************************\n");
        System.out.println("*** Cosa vuoi fare? ***\n");
        System.out.println("1) Registra nuovo cliente");     //ok
        System.out.println("2) Genera Scontrino Tavolo");//ok
        System.out.println("3) Visualizza Tavoli Liberi");
        System.out.println("4) Visualizza statistiche giornaliere");
        System.out.println("5) Visualizza statistiche mensili");
        System.out.println("6) Aggiungi pizza nel menù");   //ok
        System.out.println("7) Aggiungi bevanda nel menù"); //ok
        System.out.println("8) Quit");


        Scanner input = new Scanner(System.in);
        int choice = 0;
        while (true) {
            System.out.print("Please enter your choice: ");
            choice = input.nextInt();
            if (choice >= 1 && choice <= 8) {
                break;
            }
            System.out.println("Invalid option");
        }

        return choice;
    }

    public static Cliente registraCliente() throws IOException {        //ok todo che torni il tavolo assegnato
        Cliente cliente;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("nome cliente: ");
        String nome = reader.readLine();
        System.out.print("cognome cliente: ");
        String cognome = reader.readLine();
        System.out.print("numero persone portate: ");
        int numPersone = Integer.parseInt(reader.readLine());
        String input = reader.readLine();

        cliente = new Cliente(nome, cognome, numPersone, 0);
        return cliente;
    }
    public static Pizza aggiuntaPizza() throws IOException {
        Pizza pizza;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("nome della nuova pizza: ");
        String nome = reader.readLine();
        System.out.print("prezzo: ");
        Float prezzo = Float.parseFloat(reader.readLine());

        pizza = new Pizza(nome, prezzo);

        return pizza;
    }
    public static Bevande aggiuntaBevanda() throws IOException {
        Bevande bevanda;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("nome della nuova bevanda: ");
        String nome = reader.readLine();
        System.out.print("prezzo: ");
        Float prezzo = Float.parseFloat(reader.readLine());

        bevanda = new Bevande(nome, prezzo);

        return bevanda;
    }
    public static int generaScontrino() throws IOException {    //per generare scontrino inserisce numero
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("numero tavolo: ");
        int tavolo = Integer.parseInt(reader.readLine());

        return tavolo;
    }

    public static int cercaScontrinoPerMese() throws IOException {      //ok
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("mese (inserire il numero): ");
        int mese = Integer.parseInt(reader.readLine());

        return mese;
    }
    public static String cercaScontrinoPerGiorno() throws IOException {     //ok
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Data (YYYY-MM-DD): ");
        String giorno = (reader.readLine());


        return giorno;
    }


}

