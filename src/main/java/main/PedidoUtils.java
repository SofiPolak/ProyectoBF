package main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PedidoUtils {
	
	public Pedido getPedido(int numero, Connection conn) throws Exception {
		try {
		PreparedStatement statement = conn.prepareStatement("SELECT * FROM pedidos WHERE numero=?");
		statement.setInt(1, numero);
		ResultSet results = statement.executeQuery();
		Pedido pedido = null;

		if (results.next()) {
			pedido = toPedido(results);
		}
		return pedido;

		}catch(Exception e) {
			throw new Exception(e);
		}
	}
	
	public int createPedido(Pedido pedido, Connection conn) throws Exception {
		try {
			PreparedStatement statement = conn.prepareStatement("INSERT INTO pedidos (numero, fecha) VALUES (?, ?) RETURNING numero");
			statement.setInt(1, pedido.getNumero());
			//problema
			//statement.setDate(2, pedido.getFecha());
			ResultSet result = statement.executeQuery();
			if(result.next()) {
				int numero = result.getInt(1);
				return numero;
			}
		} catch (Exception e) {
			throw new Exception(e);
		}
		return 0;
	}

	public void deletePedido(Pedido pedido, Connection conn) throws Exception {
		try {
		PreparedStatement statement = conn.prepareStatement("DELETE FROM Pedidos WHERE numero = ?");
		statement.setInt(1, pedido.getNumero());
		statement.executeUpdate();
		}catch (Exception e) {
			throw new Exception(e);
		}
	}
	// voy a actualizar el pedido? la lista nada mas
//	public int updatePedido(Pedido pedido, Connection conn) throws Exception {
//		try {
//			PreparedStatement statement = conn.prepareStatement("UPDATE servicios SET montoBase = ?, activo = ?, soporte = ? WHERE nombre = ?");
//			statement.setDouble(1, pedido.getMontoBase());
//			statement.setBoolean(2, pedido.isActivo());
//			statement.setBoolean(3, pedido.isSoporte());
//			statement.setString(4, pedido.getNombre());
//			int rows = statement.executeUpdate();
//
//			return rows;
//		} catch (Exception e) {
//			throw new Exception(e);
//		}
//	}

	private Pedido toPedido(ResultSet resultados) throws SQLException {
		// como traigo la lista de items
		return new Pedido(resultados.getInt(1), resultados.getDate(2));
	}


}
