package org.example.model.dao;

import org.example.exception.DAOException;
import org.example.model.domain.Pizza;
import org.example.model.domain.PizzaOrd;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrdPizzeProcedureDAO implements GenericProcedureDAO<PizzaOrd> {
    @Override
    public PizzaOrd execute(Object... params) throws DAOException, SQLException {
        PizzaOrd pizzaOrd = null;
        String procedureCode = (String) params[0];
        switch (procedureCode) {
            case ("P1"):
                try {
                    Connection conn = ConnectionFactory.getConnection();
                    CallableStatement cs = conn.prepareCall("{call VisualizzaPizzeDaPreparare()}");
                    ResultSet rs = cs.executeQuery();
                    List<PizzaOrd> pizzeDaPrep = new ArrayList<>();
                    while (rs.next()) {
                        pizzaOrd = new PizzaOrd(rs.getString(1),rs.getInt(2) );
                        pizzeDaPrep.add(pizzaOrd);
                    }
                    stampaPizze(pizzeDaPrep);
                    break;
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            case("P2"):
                int idTavolo = (int) params[1];
                String nomePizza = (String) params[2];
                int quantità = (int) params[3];
                try{
                    Connection conn = ConnectionFactory.getConnection();
                    CallableStatement cs = conn.prepareCall("{call segnaPizzaPronta(?,?,?)}");
                    cs.setInt(1,idTavolo);
                    cs.setString(2,nomePizza);
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

    private void stampaPizze(List<PizzaOrd> pizzeDaPrep) {
        System.out.println("-----------------------------------------------------------------------------------------------------------------");
        System.out.printf("| %-10s | %-10s |\n",
                "Quantità", "Nome");
        System.out.println("-----------------------------------------------------------------------------------------------------------------");

        for (PizzaOrd pizzaOrd : pizzeDaPrep) {
            System.out.printf("| %-10s | %-10s |\n",
                    pizzaOrd.getNomePizza() != null ? pizzaOrd.getNomePizza() : "null",
                    pizzaOrd.getQuantita() != 0 ? String.valueOf(pizzaOrd.getQuantita()) : "null");
        }
    }
}
