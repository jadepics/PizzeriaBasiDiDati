package org.example.controller;

import org.example.exception.DAOException;
import org.example.model.dao.ConnectionFactory;
import org.example.model.dao.OrdBevProcedureDAO;

import org.example.model.domain.BevandeOrd;

import org.example.model.domain.Role;
import org.example.view.BaristaView;

import java.io.IOException;
import java.sql.SQLException;

public class BaristaController {
    public String procedureCode;

    public void start() throws IOException {
        try {
            ConnectionFactory.changeRole(Role.BARISTA);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        while (true) {
            int choice;
            try {
                choice = BaristaView.showMenuBarista();
            } catch(IOException e) {
                throw new RuntimeException(e);
            }

            switch (choice) {
                case 1 -> bevandeDaPreparare();
                case 2 -> bevandaPronta();
                case 3 -> System.exit(0);
                default -> throw new RuntimeException("Invalid choice");
            }
        }
    }

    public void bevandeDaPreparare(){
        procedureCode = "B1";
        try{
            new OrdBevProcedureDAO().execute(procedureCode);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void bevandaPronta()throws IOException {
        procedureCode= "B2";
        BevandeOrd bevandeOrd= BaristaView.bevandaPronta();
        int idTavolo= bevandeOrd.getTavolo_comanda();
        String nomeBevanda = bevandeOrd.getNomeBevanda();
        int Stato = bevandeOrd.getBevanda_pronta();
        try{
            new OrdBevProcedureDAO().execute(procedureCode,idTavolo,nomeBevanda,Stato);
        } catch (DAOException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    }

