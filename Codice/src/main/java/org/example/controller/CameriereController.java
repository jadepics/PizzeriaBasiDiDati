package org.example.controller;



import org.example.exception.DAOException;

import org.example.model.dao.ConnectionFactory;

import org.example.model.domain.Role;
import org.example.view.CameriereView;

import java.io.IOException;
import java.sql.SQLException;

public class CameriereController  implements Controller{

    @Override
    public void start() {
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

    public void visualizzaTavoli() {
    }

    public void visualizzaComandePronte() {

    }

    public void prendiComanda() {
    }

}
