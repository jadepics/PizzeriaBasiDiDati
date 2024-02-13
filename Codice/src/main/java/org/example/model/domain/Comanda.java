package org.example.model.domain;

import java.util.Date;
import java.util.List;

public class Comanda {
    final Date Data_ora;
    final String IdTavolo;
    final List<Pizza> pizze;
    final List<Bevande> bevande;
    final Integer Stato;


    public Comanda(Date data_ora, String idTavolo, List<Pizza> pizze, List<Bevande> bevande, Integer Stato) {
        Data_ora = data_ora;
        IdTavolo = idTavolo;
        this.pizze = pizze;
        this.bevande = bevande;
        this.Stato = Stato;
    }
}
