package org.example.model.domain;


public class Cliente {

    String nomeCliente;
    String cognomeCliente;
    int numeroPersone;
    int tavolo;

    public Cliente(String nome, String cognome) {
        this.nomeCliente = nome;
        this.cognomeCliente = cognome;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getCognomeCliente() {
        return cognomeCliente;
    }

    public void setCognomeCliente(String cognomeCliente) {
        this.cognomeCliente = cognomeCliente;
    }

    public int getNumeroPersone() {
        return numeroPersone;
    }

    public void setNumeroPersone(int numeroPersone) {
        this.numeroPersone = numeroPersone;
    }

    public int getTavolo() {
        return tavolo;
    }

    public void setTavolo(int tavolo) {
        this.tavolo = tavolo;
    }

    public Cliente(String nomeCliente, String cognomeCliente, int numeroPersone, int tavolo) {

        this.nomeCliente = nomeCliente;
        this.cognomeCliente = cognomeCliente;
        this.numeroPersone = numeroPersone;
        this.tavolo = tavolo;
    }
}
