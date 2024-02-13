package org.example.model.domain;

public class PizzaOrd {
    final String nomePizza;
    final Integer quantita;
    final Integer pizza_pronta;

    public PizzaOrd(String nomePizza, Integer quantita, Integer pizza_pronta) {
        this.nomePizza = nomePizza;
        this.quantita = quantita;
        this.pizza_pronta = pizza_pronta;
    }
}
