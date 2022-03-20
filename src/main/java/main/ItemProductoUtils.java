package main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemProductoUtils {
	
	public ItemProducto getItemProducto(String nombre, Connection conn) throws Exception {
		try {
		PreparedStatement statement = conn.prepareStatement("SELECT * FROM Productos WHERE nombre=?");
		statement.setString(1, nombre);
		ResultSet results = statement.executeQuery();
		ItemProducto itemProducto = null;

		if (results.next()) {
			itemProducto = toItemProducto(results);
		}
		return itemProducto;

		}catch(Exception e) {
			throw new Exception(e);
		}
	}
	
	public void createItemProducto(ItemProducto itemProducto, Connection conn) throws Exception {
		try {
		PreparedStatement statement = conn.prepareStatement("INSERT INTO Productos (nombre, montoBase, garantia, anios) VALUES (?, ?, ?, ?)");
		statement.setString(1, itemProducto.getNombre());
		statement.setDouble(2, itemProducto.getMontoBase());
		statement.setBoolean(3, itemProducto.isGarantia());
		statement.setInt(4, itemProducto.getAniosGarantia());
		statement.executeQuery();
		} catch (Exception e) {
			throw new Exception(e);
		}
	}

	public void deleteItemProducto(ItemProducto itemProducto, Connection conn) throws Exception {
		try {
		PreparedStatement statement = conn.prepareStatement("DELETE FROM productos WHERE nombre = ?");
		statement.setString(1, itemProducto.getNombre());
		statement.executeUpdate();
		}catch (Exception e) {
			throw new Exception(e);
		}
	}
	
	public int updateItemProducto(ItemProducto itemProducto, Connection conn) throws Exception {
		try {
			PreparedStatement statement = conn.prepareStatement("UPDATE productos SET montoBase = ?, garantia = ?, aniosGarantia = ? WHERE nombre = ?");
			statement.setDouble(1, itemProducto.getMontoBase());
			statement.setBoolean(2, itemProducto.isGarantia());
			statement.setInt(3, itemProducto.getAniosGarantia());
			statement.setString(4, itemProducto.getNombre());
			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new Exception(e);
		}
	}

	private ItemProducto toItemProducto(ResultSet resultados) throws SQLException {
		return new ItemProducto(resultados.getString(1), resultados.getDouble(2),resultados.getBoolean(3), resultados.getInt(4));
	}

}
