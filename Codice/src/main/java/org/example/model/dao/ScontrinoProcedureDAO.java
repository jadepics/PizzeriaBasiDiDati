package org.example.model.dao;

import org.example.exception.DAOException;
import org.example.model.domain.Cameriere;
import org.example.model.domain.Scontrino;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ScontrinoProcedureDAO implements GenericProcedureDAO<Scontrino> {

    @Override
    public Scontrino execute(Object... params) throws DAOException, SQLException {
        Scontrino scontrino = null;
        List<Scontrino> scontrini;
        String procedureCode = (String) params[0];
        switch (procedureCode) {
             case ("M4"):
                 String data = (String) params[1];

                try {
                    Connection conn = ConnectionFactory.getConnection();
                    CallableStatement cs = conn.prepareCall("{call CalcolaMediaEntrateGiornaliere(?)}");
                    cs.setDate(1, Date.valueOf(data));

                    ResultSet rs = cs.executeQuery();

                    while (rs.next()) {
                        Float entrataGiornaliera = rs.getFloat(1);
                        System.out.println("Entrate giornaliere: ");
                        System.out.println(entrataGiornaliera);
                    }
                    break;
                } catch (SQLException e) {
                    throw new DAOException("Association error: " + e.getMessage());


                }
                case ("M5"):
                int mese = (int) params[1];
                try{
                    Connection conn = ConnectionFactory.getConnection();
                    CallableStatement cs = conn.prepareCall("{call CalcolaMediaEntrateMensili(?)}");
                    cs.setInt(1, mese);

                    ResultSet rs = cs.executeQuery();

                    while (rs.next()) {
                        Float entrataMensile = rs.getFloat(1);
                        System.out.println("Entrate mensili: ");
                        System.out.println(entrataMensile);
                    }
                    break;
                }catch(SQLException e) {
                    throw new DAOException("Association error: " + e.getMessage());
                }

            case("M13"):
                int idTavolo = (int) params[1];

                try {
                    Connection conn = ConnectionFactory.getConnection();
                    CallableStatement cs = conn.prepareCall("{call segnaTavoloPagato(?)}");
                    cs.setInt(1, idTavolo); // Imposta il parametro di input
                    cs.execute();
                    System.out.println("Scontrino salvato come pagato");
                    break;
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }

        }
        return scontrino;
    }
        public static void stampaScontrini (List < Scontrino > scontrini) {
            System.out.println("------------------------------------------------------------------------------------------------------");
            System.out.printf("| %-10s | %-10s | %-20s | %-10s |\n",
                    "IdScontrino", "Totale",  "Tavolo", "Data Emissione");
            System.out.println("------------------------------------------------------------------------------------------------------");
            for (Scontrino scontrino : scontrini) {
                System.out.printf("| %-10s | %-10s | %-20s | %-10s | %-10s | %-10s | %-10s |\n",
                        scontrino.getIdScontrino() != 0 ? String.valueOf(scontrino.getIdScontrino()) : "null",
                        scontrino.getTotale() != 0 ? String.valueOf(scontrino.getTotale()) : "null",
                        scontrino.getComanda_Tavolo_() != 0 ? String.valueOf(scontrino.getComanda_Tavolo_()) : "null",
                        scontrino.getData_emissione() != null ? scontrino.getData_emissione().toString() : "null");
        }
            System.out.println("-----------------------------------------------------------------------------------------------------");
        }
    }

