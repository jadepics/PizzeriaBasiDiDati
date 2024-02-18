package org.example.model.dao;

import org.example.exception.DAOException;
import org.example.model.domain.Bevande;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BevandeProcedureDAO implements GenericProcedureDAO<Bevande> {

    public String procedureCode;
    @Override
    public Bevande execute(Object... params) throws DAOException {
        Bevande bevande = null;
        String procedureCode= (String) params[0];
        switch (procedureCode){
            case ("M7"):
                bevande = (Bevande) params [1];
                String nome = bevande.getName();
                float prezzo = bevande.getPrezzo();
                try {
                    Connection conn = ConnectionFactory.getConnection();
                    CallableStatement cs = conn.prepareCall("{call AddBevandaMenu(?, ?)}");
                    cs.setString(1, nome);
                    cs.setFloat(2, prezzo);
                    ResultSet rs = cs.executeQuery();
                    break;

                } catch (SQLException e) {
                    throw new DAOException("Association error: " + e.getMessage());
                }
        }
        return bevande;
    }
}
