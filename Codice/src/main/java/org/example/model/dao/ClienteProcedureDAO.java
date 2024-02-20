package org.example.model.dao;

import org.example.exception.DAOException;
import org.example.model.domain.Cliente;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ClienteProcedureDAO implements GenericProcedureDAO<Cliente> {
    public String procedureCode;

    public Cliente execute(Object... params) throws DAOException {
        Cliente cliente = null;
        List<Cliente> listaClienti = new ArrayList<>();
        String procedureCode = (String) params[0];
        switch (procedureCode) {
            case ("M1"):
                cliente = (Cliente) params[1];
                String nomeCliente = cliente.getNomeCliente();
                String cognomeCliente = cliente.getCognomeCliente();
                int numeroPersone = cliente.getNumeroPersone();
                int tavolo = cliente.getTavolo();
                int id;
                try {
                    Connection conn = ConnectionFactory.getConnection();
                    CallableStatement cs = conn.prepareCall("{call NuovoCliente(?, ?, ?,?)}");
                    cs.setString(1, nomeCliente);
                    cs.setString(2, cognomeCliente);
                    cs.setInt(3, numeroPersone);
                    cs.registerOutParameter(4, Types.INTEGER);
                    cs.executeUpdate();
                    id = cs.getInt(4);
                    System.out.println("Inserito con successo, tavolo assegnato:" +id);
                    break;
                } catch (SQLException e) {
                    throw new DAOException("Association error: " + e.getMessage());
                }
            case ("M12"):
                cliente = (Cliente) params[1];
                nomeCliente = cliente.getNomeCliente();
                cognomeCliente = cliente.getCognomeCliente();
                try {
                    Connection conn = ConnectionFactory.getConnection();
                    CallableStatement cs = conn.prepareCall("{call CancellaCliente(?, ?)}");
                    cs.setString(1, nomeCliente);
                    cs.setString(2, cognomeCliente);
                    cs.executeQuery();
                    System.out.println("Cancellato con successo \n");
                    break;
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
        }
        return cliente;
    }
}

