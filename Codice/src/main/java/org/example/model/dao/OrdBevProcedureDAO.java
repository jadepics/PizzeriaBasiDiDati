package org.example.model.dao;

import org.example.exception.DAOException;
import org.example.model.domain.BevandeOrd;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrdBevProcedureDAO implements GenericProcedureDAO<BevandeOrd>{
    @Override
    public BevandeOrd execute(Object... params) throws DAOException, SQLException {
        BevandeOrd bevandeOrd = null;
        String procedureCode = (String) params[0];
        switch (procedureCode) {
            case ("B1"):
                try {
                    Connection conn = ConnectionFactory.getConnection();
                    CallableStatement cs = conn.prepareCall("{call VisualizzaBevandeDaPreparare()}");
                    ResultSet rs = cs.executeQuery();
                    List<BevandeOrd> bevandeDaPrep = new ArrayList<>();
                    while (rs.next()) {
                        bevandeOrd = new BevandeOrd( rs.getString(1),rs.getInt(2));
                        bevandeDaPrep.add(bevandeOrd);
                    }
                    stampaBevande(bevandeDaPrep);
                    break;
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            case("P2"):
                int idTavolo = (int) params[1];
                String nomeBevanda = (String) params[2];
                int quantità = (int) params[3];
                try{
                    Connection conn = ConnectionFactory.getConnection();
                    CallableStatement cs = conn.prepareCall("{call segnaBevandaPronta(?,?,?)}");
                    cs.setInt(1,idTavolo);
                    cs.setString(2,nomeBevanda);
                    cs.setInt(3,quantità);
                    cs.executeQuery();
                    System.out.println("Stato comanda aggiornato");
                    break;
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
        }
        return null;
    }

    private void stampaBevande(List<BevandeOrd> bevandeDaPrep) {
        System.out.println("-----------------------------------------------------------------------------------------------------------------");
        System.out.printf("| %-10s | %-10s |\n",
                "Quantità", "Nome");
        System.out.println("-----------------------------------------------------------------------------------------------------------------");

        for (BevandeOrd bevandeOrd : bevandeDaPrep) {
            System.out.printf("| %-10s | %-10s |\n",
                    bevandeOrd.getNomeBevanda() != null ? bevandeOrd.getNomeBevanda() : "null",
                    bevandeOrd.getQuantita() != 0 ? String.valueOf(bevandeOrd.getQuantita()) : "null");
        }
    }
}

