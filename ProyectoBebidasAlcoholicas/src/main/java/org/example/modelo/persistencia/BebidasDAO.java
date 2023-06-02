package org.example.modelo.persistencia;

import org.example.modelo.BebidasAlcoholicas;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class BebidasDAO implements InterfazDAO{
    public BebidasDAO() {
    }

    @Override
    public boolean insertar(Object obj) throws SQLException {
        String sqlInsert = "INSERT INTO bebidas (nombre,marca,precio,volumen,url) VALUES(?, ?, ?, ?, ?)";
        int rowCount = 0;
        PreparedStatement pstm = ConexionSingleton.getInstance("bebidasAlcoholicasDB.db").getConnection().prepareStatement(sqlInsert);
        pstm.setString(1, ((BebidasAlcoholicas) obj).getNombre());
        pstm.setString(2, ((BebidasAlcoholicas) obj).getMarca());
        pstm.setInt(3, ((BebidasAlcoholicas) obj).getPrecio());
        pstm.setInt(4, ((BebidasAlcoholicas) obj).getVolumen());
        pstm.setString(5, ((BebidasAlcoholicas) obj).getUrl());
        rowCount = pstm.executeUpdate();
        return rowCount > 0;
    }

    @Override
    public boolean update(Object obj) throws SQLException {
        String sqlUpdate = "UPDATE bebidas SET nombre = ?, marca = ?, precio = ?, volumen = ?, url = ? WHERE id = ? ;";
        int rowCount = 0;
        PreparedStatement pstm = ConexionSingleton.getInstance("bebidasAlcoholicasDB.db").getConnection().prepareStatement(sqlUpdate);
        pstm.setString(1, ((BebidasAlcoholicas) obj).getNombre());
        pstm.setString(2, ((BebidasAlcoholicas) obj).getMarca());
        pstm.setInt(3, ((BebidasAlcoholicas) obj).getPrecio());
        pstm.setInt(4, ((BebidasAlcoholicas) obj).getPrecio());
        pstm.setString(5, ((BebidasAlcoholicas) obj).getUrl());
        pstm.setInt(6, ((BebidasAlcoholicas) obj).getId());

        rowCount = pstm.executeUpdate();
        return rowCount > 0;
    }

    @Override
    public boolean delete(String id) throws SQLException {
        String sqlDelete = "DELETE FROM bebidas WHERE id = ? ;";
        int rowCount = 0;
        PreparedStatement pstm = ConexionSingleton.getInstance("librosbebidasAlcoholicasDB.db").getConnection().prepareStatement(sqlDelete);
        pstm.setInt(1, Integer.parseInt(id));
        rowCount = pstm.executeUpdate();
        return rowCount > 0;
    }

    @Override
    public ArrayList obtenerTodo() throws SQLException {
        String sql = "SELECT * FROM bebidas";
        ArrayList<BebidasAlcoholicas> resultado = new ArrayList<>();
        Statement stm = ConexionSingleton.getInstance("bebidasAlcoholicasDB.db").getConnection().createStatement();
        ResultSet rst = stm.executeQuery(sql);
        while (rst.next()) {
            resultado.add(new BebidasAlcoholicas(rst.getInt(1),rst.getString(2),rst.getString(3),rst.getInt(4),rst.getInt(5),rst.getString(6)));
        }
        return resultado;
    }

    @Override
    public Object buscarPorId(String id) throws SQLException {
        String sql = "SELECT * FROM bebidas WHERE id = ? ;";
        BebidasAlcoholicas bebida = null;
        PreparedStatement pstm = ConexionSingleton.getInstance("bebidasAlcoholicasDB.db").getConnection().prepareStatement(sql);
        pstm.setInt(1, Integer.parseInt(id));
        ResultSet rst = pstm.executeQuery();
        if (rst.next()) {
            bebida = new BebidasAlcoholicas(rst.getInt(1),rst.getString(2),rst.getString(3),rst.getInt(4),rst.getInt(5),rst.getString(6));
            return bebida;
        }
        return null;
    }
}
