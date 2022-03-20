package main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonaUtils {
	
	public Persona getPersona(int dni, Connection conn) throws Exception {
		try {
		PreparedStatement statement = conn.prepareStatement("SELECT * FROM Personas WHERE dni=?");
		statement.setInt(1, dni);
		ResultSet results = statement.executeQuery();
		Persona persona = null;

		if (results.next()) {
			persona = toPersona(results);
		}
		return persona;
//		if(results.next()) {
//			String name = results.getString(2);
//			String apellido = results.getString(3);
//			return "La persona es "+name+" "+apellido;
//		}
		}catch(Exception e) {
			throw new Exception(e);
		}
		//return "no encontre nada";
	}
	
	public void createPersona(Persona persona, Connection conn) throws Exception {
		try {
		PreparedStatement statement = conn.prepareStatement("INSERT INTO Personas (dni, nombre, apellido) VALUES (?, ?, ?)");
		statement.setString(2, persona.getNombrePersona());
		statement.setString(3, persona.getApellidoPersona());
		statement.setInt(1, persona.getDniPersona());
		statement.executeQuery();
		} catch (Exception e) {
			throw new Exception(e);
		}
	}

	public void deletePersona(Persona persona, Connection conn) throws Exception {
		try {
		PreparedStatement statement = conn.prepareStatement("DELETE FROM personas WHERE dni = ?");
		statement.setInt(1, persona.getDniPersona());
		statement.executeUpdate();
		}catch (Exception e) {
			throw new Exception(e);
		}
	}
	
	public int updatePersona(Persona persona, Connection conn) throws Exception {
		try {
			PreparedStatement statement = conn.prepareStatement("UPDATE personas SET nombre = ?, apellido = ? WHERE dni = ?");
			statement.setString(1, persona.getNombrePersona());
			statement.setString(2, persona.getApellidoPersona());
			statement.setInt(3, persona.getDniPersona());
			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new Exception(e);
		}
	}

	private Persona toPersona(ResultSet resultados) throws SQLException {
		return new Persona(resultados.getString(3), resultados.getString(2),resultados.getInt(1));
	}

}
