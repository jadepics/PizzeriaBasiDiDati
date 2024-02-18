package org.example.controller;

import org.example.exception.DAOException;
import org.example.model.dao.*;
import org.example.model.domain.*;
import org.example.view.ManagerView;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class ManagerController implements Controller {
    String procedureCode;
    String dataScontrino;
    String dataInsert;
    int mm;
    int yyyy;
    int tavolo;

    @Override
    public void start() throws IOException {
        try {
            ConnectionFactory.changeRole(Role.MANAGER);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        while (true) {
            int choice;
            try {
                choice = ManagerView.showMenu();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            switch (choice) {
                case 1-> registraCliente();
                case 2-> generaScontrino();
                case 3-> visualizzaTavoliLiberi();
                case 4-> visualizzaStatisticheGiornaliere();
                case 5-> visualizzaStatisticheMensili();
                case 6-> aggiuntaPizza();
                case 7 -> aggiuntaBevanda();
                case 8-> System.exit(0);
                default -> throw new RuntimeException("Invalid choice");
            }
        }
    }
    public void registraCliente() throws IOException {  //fatta
        procedureCode = "M1";
        Cliente cliente;
        Cliente cliente1 = ManagerView.registraCliente();
        try {
            cliente = new ClienteProcedureDAO().execute(procedureCode, cliente1);
        } catch(DAOException e) {
            throw new RuntimeException(e);
        }
    }
    public void visualizzaStatisticheGiornaliere() throws IOException { //fatta
        procedureCode = "M4";
        Scontrino scontrino;
        dataScontrino = ManagerView.cercaScontrinoPerGiorno();
                 try {
            scontrino = new ScontrinoProcedureDAO().execute(procedureCode, dataScontrino);
        } catch(DAOException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void visualizzaStatisticheMensili() throws IOException { //fatta
        procedureCode = "M5";
        Scontrino scontrino;
        mm = ManagerView.cercaScontrinoPerMese();
        try {
            scontrino = new ScontrinoProcedureDAO().execute(procedureCode, mm);
        } catch(DAOException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void generaScontrino() throws IOException{   //fatta
        procedureCode ="M2";
        Scontrino scontrino;
        int idTavolo = ManagerView.generaScontrino();
        try{
           new TavoloProcedureDAO().execute(procedureCode,idTavolo);
        } catch (DAOException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void visualizzaTavoliLiberi() throws IOException{    //fatta
        procedureCode ="M3";
        Tavoli tavolo;
        try {
            tavolo =new TavoloProcedureDAO().execute(procedureCode);
        } catch (DAOException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void aggiuntaPizza() throws IOException{     //fatta
        procedureCode="M6";
        Pizza pizza =ManagerView.aggiuntaPizza();
        try{
            pizza = new PizzaProcedureDAO().execute(procedureCode,pizza);
        } catch (DAOException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void aggiuntaBevanda() throws IOException{       //fatta
        procedureCode="M7";
        Bevande bevanda = ManagerView.aggiuntaBevanda();
        try{
            bevanda = new BevandeProcedureDAO().execute(procedureCode,bevanda);
        } catch (DAOException e) {
            throw new RuntimeException(e);
        }

    }
//todo gli elimina prodotti
}
