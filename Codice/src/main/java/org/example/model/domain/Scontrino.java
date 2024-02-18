package org.example.model.domain;

import java.util.Date;

public class Scontrino {
    int idScontrino;
    float Totale;

    public int getIdScontrino() {
        return idScontrino;
    }

    public void setIdScontrino(int idScontrino) {
        this.idScontrino = idScontrino;
    }

    public float getTotale() {
        return Totale;
    }

    public void setTotale(float totale) {
        Totale = totale;
    }

    public String getData_emissione() {
        return data_emissione;
    }

    public void setData_emissione(String data_emissione) {
        this.data_emissione = data_emissione;
    }

    public int getComanda_Tavolo_() {
        return comanda_Tavolo_;
    }

    public void setComanda_Tavolo_(int comanda_Tavolo_) {
        this.comanda_Tavolo_ = comanda_Tavolo_;
    }

    public int getIsPagato() {
        return isPagato;
    }

    public void setIsPagato(int isPagato) {
        this.isPagato = isPagato;
    }

    String data_emissione;
    int comanda_Tavolo_;
    int isPagato;

    public Scontrino(int idScontrino, float totale, String data_emissione, int comanda_Tavolo_, int isPagato) {
        this.idScontrino = idScontrino;
        Totale = totale;
        this.data_emissione = data_emissione;
        this.comanda_Tavolo_ = comanda_Tavolo_;
        this.isPagato = isPagato;
    }


}
