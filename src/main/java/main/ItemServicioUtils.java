package main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemServicioUtils {
	
	public ItemServicio getItemServicio(String nombre, Connection conn) throws Exception {
		try {
		PreparedStatement statement = conn.prepareStatement("SELECT * FROM Servicios WHERE nombre=?");
		statement.setString(1, nombre);
		ResultSet results = statement.executeQuery();
		ItemServicio itemServicio = null;

		if (results.next()) {
			itemServicio = toItemServicio(results);
		}
		return itemServicio;

		}catch(Exception e) {
			throw new Exception(e);
		}
	}
	
	public void createItemServicio(ItemServicio itemServicio, Connection conn) throws Exception {
		try {
		PreparedStatement statement = conn.prepareStatement("INSERT INTO Servicios (nombre, montoBase, activo, soporte) VALUES (?, ?, ?, ?)");
		statement.setString(1, itemServicio.getNombre());
		statement.setDouble(2, itemServicio.getMontoBase());
		statement.setBoolean(3, itemServicio.isActivo());
		statement.setBoolean(4, itemServicio.isSoporte());
		statement.executeQuery();
		} catch (Exception e) {
			throw new Exception(e);
		}
	}

	public void deleteItemServicio(ItemServicio itemServicio, Connection conn) throws Exception {
		try {
		PreparedStatement statement = conn.prepareStatement("DELETE FROM servicios WHERE nombre = ?");
		statement.setString(1, itemServicio.getNombre());
		statement.executeUpdate();
		}catch (Exception e) {
			throw new Exception(e);
		}
	}
	
	public int updateItemServicio(ItemServicio itemServicio, Connection conn) throws Exception {
		try {
			PreparedStatement statement = conn.prepareStatement("UPDATE servicios SET montoBase = ?, activo = ?, soporte = ? WHERE nombre = ?");
			statement.setDouble(1, itemServicio.getMontoBase());
			statement.setBoolean(2, itemServicio.isActivo());
			statement.setBoolean(3, itemServicio.isSoporte());
			statement.setString(4, itemServicio.getNombre());
			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new Exception(e);
		}
	}

	private ItemServicio toItemServicio(ResultSet resultados) throws SQLException {
		return new ItemServicio(resultados.getString(1), resultados.getDouble(2),resultados.getBoolean(3), resultados.getBoolean(4));
	}


}
