package org.example.model.domain;

public class Bevande {
    String name;
    Float prezzo;

    public Bevande(String name, Float prezzo) {
        this.name =name;
        this.prezzo=prezzo;
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
