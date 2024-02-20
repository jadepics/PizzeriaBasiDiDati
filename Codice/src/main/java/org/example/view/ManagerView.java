package org.example.view;

import org.example.model.domain.*;

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
        System.out.println("8) Assegna cameriere a un tavolo");
        System.out.println("9) Inserisci tavolo");
        System.out.println("10) Elimina pizza dal menù");
        System.out.println("11) Elimina bevanda dal menù");
        System.out.println("12) Cancella cliente");
        System.out.println("13) Segna scontrino come pagato");
        System.out.println("14) Visualizza tavoli che devono pagare");
        System.out.println("15) Quit");


        Scanner input = new Scanner(System.in);
        int choice = 0;
        while (true) {
            System.out.print("Please enter your choice: ");
            choice = input.nextInt();
            if (choice >= 1 && choice <= 15) {
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

    public static int generaScontrino() throws IOException {    //per generare scontrino inserisce numero tavolo
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("numero tavolo: ");
        int tavolo = Integer.parseInt(reader.readLine());

        return tavolo;
    }

    public static int cercaScontrinoPerMese() throws IOException {      //ok statistiche mensili
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("mese (inserire il numero): ");
        int mese = Integer.parseInt(reader.readLine());

        return mese;
    }

    public static String cercaScontrinoPerGiorno() throws IOException {     //ok statistiche mensili
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Data (YYYY-MM-DD): ");
        String giorno = (reader.readLine());


        return giorno;
    }

    public static Cameriere assegnaCameriereaTavolo() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Inserisci numero Tavolo: ");
        int idTavolo = Integer.parseInt((reader.readLine()));
        System.out.print("Inserisci ID cameriere: ");
        int idCameriere = Integer.parseInt(reader.readLine());
        Cameriere cameriere = new Cameriere(idTavolo, idCameriere);
        return cameriere;
    }

    public static Tavoli aggiungiNuovoTavolo() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Inserisci posti disponibili: ");
        int posti = Integer.parseInt(reader.readLine());
        System.out.print("Inserisci ID cameriere: ");
        int idCameriere = Integer.parseInt(reader.readLine());

        Tavoli tavolo = new Tavoli(posti, idCameriere);
        return tavolo;
    }

    public static String eliminaPizza() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Inserisci il nome della pizza da eliminare: ");
        String pizza = reader.readLine();
        return pizza;
    }

    public static String eliminaBevanda() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Inserisci il nome della bevanda da eliminare: ");
        String bevanda = reader.readLine();
        return bevanda;
    }

    public static Cliente cancellaCliente() throws IOException {        //ok todo che torni il tavolo assegnato

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("nome cliente: ");
        String nome = reader.readLine();
        System.out.print("cognome cliente: ");
        String cognome = reader.readLine();
        Cliente cliente1 = new Cliente(nome, cognome);
        return cliente1;
        //segna scontrino come pagato
    }
    public static int segnaScontrinoPagato() throws IOException {    //per generare scontrino inserisce numero tavolo
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("numero tavolo: ");
        int tavolo = Integer.parseInt(reader.readLine());

        return tavolo;
    }

}

