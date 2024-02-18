package org.example.model.domain;

import java.util.Date;

public class PizzaOrd {

     int quantita;
     int pizza_pronta;

    int tavolo_comanda;
    String data_comanda;
    String nomePizza;

    public PizzaOrd(int quantita, String nomePizza) {
        this.nomePizza=nomePizza;
        this.quantita=quantita;
    }

    public PizzaOrd(int idTavolo, int quantità, String pizza) {
        this.quantita = quantità;
        this.nomePizza=pizza;
        this.tavolo_comanda= idTavolo;
    }


    public int getQuantita() {
        return quantita;
    }

    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }

    public int getPizza_pronta() {
        return pizza_pronta;
    }

    public void setPizza_pronta(int pizza_pronta) {
        this.pizza_pronta = pizza_pronta;
    }

    public int getTavolo_comanda() {
        return tavolo_comanda;
    }

    public void setTavolo_comanda(int tavolo_comanda) {
        this.tavolo_comanda = tavolo_comanda;
    }

    public String getData_comanda() {
        return data_comanda;
    }

    public void setData_comanda(String data_comanda) {
        this.data_comanda = data_comanda;
    }

    public String getNomePizza() {
        return nomePizza;
    }

    public void setNomePizza(String nomePizza) {
        this.nomePizza = nomePizza;
    }


    public PizzaOrd(int quantita, int pizza_pronta, int tavolo_comanda, String data_comanda, String nomePizza) {
        this.quantita = quantita;
        this.pizza_pronta = pizza_pronta;
        this.tavolo_comanda = tavolo_comanda;
        this.data_comanda = data_comanda;
        this.nomePizza = nomePizza;
    }



    }

