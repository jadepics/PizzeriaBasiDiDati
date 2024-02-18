package org.example.model.domain;

import java.util.Date;

public class BevandeOrd {
    int quantita;

    public BevandeOrd(int quantita, String nomeBevanda) {
        this.quantita=quantita;
        this.nomeBevanda=nomeBevanda;
    }

    public BevandeOrd(int idTavolo, int quantità, String bevanda) {
        this.nomeBevanda = bevanda;
        this.tavolo_comanda = idTavolo;
        this.quantita=quantità;
    }

    public int getQuantita() {
        return quantita;
    }

    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }

    public int getBevanda_pronta() {
        return bevanda_pronta;
    }

    public void setBevanda_pronta(int bevanda_pronta) {
        this.bevanda_pronta = bevanda_pronta;
    }

    public int getTavolo_comanda() {
        return tavolo_comanda;
    }

    public void setTavolo_comanda(int tavolo_comanda) {
        this.tavolo_comanda = tavolo_comanda;
    }

    public Date getData_comanda() {
        return data_comanda;
    }

    public void setData_comanda(Date data_comanda) {
        this.data_comanda = data_comanda;
    }

    public static String getNomeBevanda() {
        return nomeBevanda;
    }

    public void setNomeBevanda(String nomeBevanda) {
        this.nomeBevanda = nomeBevanda;
    }

    public BevandeOrd(int quantita, int bevanda_pronta, int tavolo_comanda, Date data_comanda, String nomeBevanda) {
        this.quantita = quantita;
        this.bevanda_pronta = bevanda_pronta;
        this.tavolo_comanda = tavolo_comanda;
        this.data_comanda = data_comanda;
        this.nomeBevanda = nomeBevanda;
    }

    int bevanda_pronta;

    int tavolo_comanda;
    Date data_comanda;
    static String nomeBevanda;
}
