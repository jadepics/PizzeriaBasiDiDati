package org.example.model.dao;

import org.example.exception.DAOException;
import org.example.model.domain.BevandeOrd;
import org.example.model.domain.Comanda;
import org.example.model.domain.ComandaResult;
import org.example.model.domain.PizzaOrd;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ComandaProcedureDAO implements GenericProcedureDAO<Comanda> {
    @Override
    public Comanda execute(Object... params) throws DAOException, SQLException {
        String procedureCode = (String) params[0];
        Comanda comanda = null;
        switch (procedureCode) {
            case ("C1"):
                ComandaResult comandaResult = (ComandaResult) params[1];
                comanda = comandaResult.getComanda();
                PizzaOrd pizzaOrd = comandaResult.getPizzaOrd();
                BevandeOrd bevandeOrd = comandaResult.getBevandeOrd();
                try {
                    Connection conn = ConnectionFactory.getConnection();
                    CallableStatement cs = conn.prepareCall("{call InserisciNuovaComanda(?,?,?,?,?)}");
                    cs.setInt(1, comanda.getIdTavolo());
                    cs.setString(2, pizzaOrd.getNomePizza());
                    cs.setInt(3, pizzaOrd.getQuantita());
                    cs.setString(4, BevandeOrd.getNomeBevanda());
                    cs.setInt(5, bevandeOrd.getQuantita());
                    ResultSet re = cs.executeQuery();
                    System.out.println("Comanda inviata");
                    break;
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            case ("C2"):
                int cameriereId = (int) params[1];
                try {
                    Connection conn = ConnectionFactory.getConnection();
                    CallableStatement cs = conn.prepareCall("{call visualizzaTavoliAssegnati(?)}");
                    cs.setInt(1, cameriereId);
                    ResultSet rs = cs.executeQuery();
                    System.out.println("|Tavoli:| \n");
                    while (rs.next()) {
                        System.out.println("|");
                        System.out.println(rs.getInt(1));
                        System.out.println("|\n");
                    }
                    break;
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            case ("C3"):
                cameriereId = (int) params[1];
                Comanda comanda1 = null;
                try {
                    Connection conn = ConnectionFactory.getConnection();
                    CallableStatement cs = conn.prepareCall("{call GetComandeCameriere(?)}");
                    cs.setInt(1, cameriereId);
                    ResultSet rs = cs.executeQuery();
                    List<Comanda> comandeList = new ArrayList<>();
                    while (rs.next()) {
                        String dataOra = rs.getString("Data_ora");
                        int tavolo = rs.getInt("Tavolo_");
                        int stato = rs.getInt("Stato");
                        comanda1 = new Comanda(dataOra, tavolo, stato);
                        comandeList.add(comanda1);
                    }
                    stampaComande(comandeList);
                    break;
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
        }

        return comanda;
    }

    private void stampaComande(List<Comanda> comandeList) {
        System.out.println("-----------------------------------------------------------------------------------------------------------------");
        System.out.printf("| %-10s | %-10s | %-8s | \n",
                "Data e ora", "Tavolo", "Stato");
        System.out.println("-----------------------------------------------------------------------------------------------------------------");
        for (Comanda comanda : comandeList) {
            System.out.printf("| %-10s | %-10s | %-8s |\n",
                    comanda.getData_ora() != null ? comanda.getData_ora() : "null",
                    comanda.getIdTavolo() != 0 ? comanda.getIdTavolo() : "null",
                    comanda.getStato() != null ? comanda.getStato() : "null");
        }
    }
}
