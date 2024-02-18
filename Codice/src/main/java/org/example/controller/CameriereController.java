package org.example.controller;



import org.example.exception.DAOException;

import org.example.model.dao.ComandaProcedureDAO;
import org.example.model.dao.ConnectionFactory;

import org.example.model.domain.Comanda;
import org.example.model.domain.ComandaResult;
import org.example.model.domain.Role;
import org.example.view.CameriereView;

import java.io.IOException;
import java.sql.SQLException;

public class CameriereController  implements Controller{
    public String procedureCode;
    @Override
    public void start() throws IOException {
        try {
            ConnectionFactory.changeRole(Role.CAMERIERE);
        } catch(SQLException e) {
            throw new RuntimeException(e);
        }

        while(true) {
            int choice;
            try {
                choice = CameriereView.showMenu();
            } catch(IOException e) {
                throw new RuntimeException(e);
            }

            switch(choice) {
                case 1 -> prendiComanda();
                case 2 -> visualizzaComandePronte();
                case 3 -> visualizzaTavoli();
                case 4 -> System.exit(0);
                default -> throw new RuntimeException("Invalid choice");
            }
        }
    }

    public void visualizzaTavoli() throws IOException {
        procedureCode ="C2";
        int cameriere= CameriereView.visualizzaTavoliAssegnati();
        try{
            new ComandaProcedureDAO().execute(procedureCode,cameriere);
        } catch (DAOException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void visualizzaComandePronte() throws IOException {
        procedureCode = "C3";
        Comanda comanda;
        int cameriere = CameriereView.visualizzaComandePronte();
        try {
            comanda = new ComandaProcedureDAO().execute(procedureCode, cameriere);
        } catch (DAOException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void prendiComanda() throws IOException {
        procedureCode = "C1";
        Comanda comanda;
        ComandaResult comandaView = CameriereView.prendiComanda();
        try{
            new ComandaProcedureDAO().execute(procedureCode, comandaView);
        } catch (DAOException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
