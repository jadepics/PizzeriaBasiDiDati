package org.example.model.domain;

import java.util.Date;

public class Comanda {
    public String getData_ora() {
        return Data_ora;
    }

    public void setData_ora(String data_ora) {
        Data_ora = data_ora;
    }

    public int getIdTavolo() {
        return IdTavolo;
    }

    public void setIdTavolo(int idTavolo) {
        IdTavolo = idTavolo;
    }

    public Integer getStato() {
        return Stato;
    }

    public void setStato(Integer stato) {
        Stato = stato;
    }

    String Data_ora;
   int IdTavolo;

   Integer Stato;


    public Comanda(String data_ora, int idTavolo, Integer Stato) {
        Data_ora = data_ora;
        IdTavolo = idTavolo;
        this.Stato = Stato;
    }
}
