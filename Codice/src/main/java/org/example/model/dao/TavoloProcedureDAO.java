package org.example.model.dao;

import org.example.exception.DAOException;
import org.example.model.domain.Tavoli;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TavoloProcedureDAO implements GenericProcedureDAO<Tavoli> {

    @Override
    public Tavoli execute(Object... params) throws DAOException, SQLException {
        Tavoli tavolo = null;
        String procedureCode = (String) params[0];
        switch (procedureCode){
            case("M3"):
                try{
                    Connection conn = ConnectionFactory.getConnection();
                    CallableStatement cs = conn.prepareCall("{call TavoliDisponibili()}");
                    ResultSet rs = cs.executeQuery();
                    List<Tavoli> tavoli = new ArrayList<>();
                    while(rs.next()){
                        tavolo = new Tavoli(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getInt(4));
                        tavoli.add(tavolo);
                    }
                    stampaListaTavoli(tavoli);
                    break;
                }catch(SQLException e) {
                    throw new DAOException("Association error: " + e.getMessage());
                }
            case("M2"):
                int idTavolo = (int) params[1];
                try {
                    Connection conn = ConnectionFactory.getConnection();
                    CallableStatement cs = conn.prepareCall("{call GeneraScontrino(?,?)}");
                    cs.setInt(1, idTavolo); // Imposta il parametro di input
                    cs.registerOutParameter(2, Types.DECIMAL); // Registra il parametro di output
                    cs.execute();

// Ottieni il valore del parametro di output
                    BigDecimal totale = cs.getBigDecimal(2);

                    System.out.println("Totale scontrino: ");
                    System.out.println(totale);

                } catch (SQLException e) {
                    throw new DAOException("Association error: " + e.getMessage());
                }

        }
        return null;
    }
    static void stampaListaTavoli(List<Tavoli> tavoli){
        System.out.println("------------------------------------------------------------");
        System.out.printf("| %-10s | %-14s | %-8s | %-10s |\n",
                "Numero", "Posti", "Occupazione", "Cameriere");
        System.out.println("------------------------------------------------------------");

        for (Tavoli tavolo : tavoli) {
            System.out.printf("| %-10s | %-14s | %-8s | %-10s |\n",
                    tavolo.getNumero() != 0 ? String.valueOf(tavolo.getNumero()) : "null",
                    tavolo.getN_posti() != 0 ? tavolo.getN_posti() : "null",
                    tavolo.getOccupazione() != 0 ? String.valueOf(tavolo.getOccupazione()) : "null",
                    tavolo.getCameriere() != 0 ? tavolo.getCameriere() : "null");
        }

        System.out.println("------------------------------------------------------------");
    }
}
