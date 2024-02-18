package org.example.controller;

import org.example.exception.DAOException;
import org.example.model.dao.ConnectionFactory;
import org.example.model.dao.OrdPizzeProcedureDAO;
import org.example.model.domain.Pizza;
import org.example.model.domain.PizzaOrd;
import org.example.model.domain.Role;
import org.example.view.PizzaioloView;

import java.io.IOException;
import java.sql.SQLException;


public class PizzaioloController implements Controller {
    public String procedureCode;

    public void start() throws IOException {
        try {
            ConnectionFactory.changeRole(Role.PIZZAIOLO);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        while (true) {
            int choice;
            try {
                choice = PizzaioloView.showMenuPizzaiolo();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            switch (choice) {
                case 1 -> pizzeDaPreparare();
                case 2 -> pizzaPronta();
                case 3 -> System.exit(0);
                default -> throw new RuntimeException("Invalid choice");
            }
        }
    }

    public void pizzeDaPreparare(){
        procedureCode = "P1";
        try{
            new OrdPizzeProcedureDAO().execute(procedureCode);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void pizzaPronta()throws IOException {
        procedureCode= "P2";
        PizzaOrd pizzaOrd= PizzaioloView.pizzaPronta();
        int idTavolo= pizzaOrd.getTavolo_comanda();
        String nomePizza = pizzaOrd.getNomePizza();
        int Stato = pizzaOrd.getPizza_pronta();
        try{
            new OrdPizzeProcedureDAO().execute(procedureCode,idTavolo,nomePizza,Stato);
        } catch (DAOException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
