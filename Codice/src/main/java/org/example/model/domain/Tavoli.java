package org.example.model.domain;

import java.util.ArrayList;
import java.util.List;

public class Tavoli {
    int numero;
    int N_posti;
    int Occupazione;
    int Cameriere;

    public Tavoli(int numero, int n_posti, int occupazione, int cameriere) {
        this.numero = numero;
        N_posti = n_posti;
        Occupazione = occupazione;
        Cameriere = cameriere;
    }


List<Tavoli> tavoliList =new ArrayList<>();

    public Tavoli(int anInt) {
        this.numero = anInt;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getN_posti() {
        return N_posti;
    }

    public void setN_posti(int n_posti) {
        N_posti = n_posti;
    }

    public int getOccupazione() {
        return Occupazione;
    }

    public void setOccupazione(int occupazione) {
        Occupazione = occupazione;
    }

    public int getCameriere() {
        return Cameriere;
    }

    public void setCameriere(int cameriere) {
        Cameriere = cameriere;
    }


}
