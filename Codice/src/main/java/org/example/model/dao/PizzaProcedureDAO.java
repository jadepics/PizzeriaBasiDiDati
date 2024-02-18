package org.example.model.dao;

import org.example.exception.DAOException;
import org.example.model.domain.Pizza;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PizzaProcedureDAO implements GenericProcedureDAO<Pizza>{
    public String procedureCode;
    @Override
    public Pizza execute(Object... params) throws DAOException, SQLException {
        Pizza pizza =null;
        String procedureCode= (String) params[0];
        switch (procedureCode){
            case("M6"):
                pizza= (Pizza) params[1];
                String nome= pizza.getName();
                float prezzo = pizza.getPrezzo();
                try{
                    Connection conn = ConnectionFactory.getConnection();
                    CallableStatement cs = conn.prepareCall("{call AddPizzaMenu(?, ?)}");
                    cs.setString(1, nome);
                    cs.setFloat(2, prezzo);
                    ResultSet rs = cs.executeQuery();
                    break;
                }catch(SQLException e){
                    throw new DAOException("Association error: " + e.getMessage());
            }

        }
        return pizza;
    }
}
