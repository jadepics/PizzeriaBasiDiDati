package org.example.model.domain;

public class ComandaResult {
    private Comanda comanda;

    public void setComanda(Comanda comanda) {
        this.comanda = comanda;
    }

    public void setBevandeOrd(BevandeOrd bevandeOrd) {
        this.bevandeOrd = bevandeOrd;
    }

    public void setPizzaOrd(PizzaOrd pizzaOrd) {
        this.pizzaOrd = pizzaOrd;
    }

    private BevandeOrd bevandeOrd;
    private PizzaOrd pizzaOrd;

    public ComandaResult(Comanda comanda, BevandeOrd bevandeOrd, PizzaOrd pizzaOrd) {
        this.comanda = comanda;
        this.bevandeOrd = bevandeOrd;
        this.pizzaOrd = pizzaOrd;
    }

    public Comanda getComanda() {
        return comanda;
    }

    public BevandeOrd getBevandeOrd() {
        return bevandeOrd;
    }

    public PizzaOrd getPizzaOrd() {
        return pizzaOrd;
    }
}
