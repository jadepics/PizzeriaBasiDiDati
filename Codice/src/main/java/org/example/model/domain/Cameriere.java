package org.example.model.domain;

public class Cameriere {
    int ID;

    public Cameriere(int idTavolo, int idCameriere) {
        this.ID= idCameriere;
        this.idTavolo= idTavolo;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdTavolo() {
        return idTavolo;
    }

    public void setIdTavolo(int idTavolo) {
        this.idTavolo = idTavolo;
    }

    String nome;
    int idTavolo;

}
