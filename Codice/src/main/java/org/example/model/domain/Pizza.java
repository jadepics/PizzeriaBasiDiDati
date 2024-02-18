package org.example.model.domain;

public class Pizza {


    String name;
   Float prezzo;


    public Pizza(String name, Float prezzo) {
        this.name = name;
        this.prezzo = prezzo;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(Float prezzo) {
        this.prezzo = prezzo;
    }
}
