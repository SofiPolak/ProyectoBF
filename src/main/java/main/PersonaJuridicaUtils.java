package main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class PersonaJuridicaUtils {
	
	public PersonaJuridica getPersonaJuridica(int cuit, Connection conn) throws Exception {
		try {
		PreparedStatement statement = conn.prepareStatement("SELECT * FROM PersonasJuridicas WHERE cuit=?");
		statement.setInt(1, cuit);
		ResultSet results = statement.executeQuery();
		PersonaJuridica personaJuridica = null;

		if (results.next()) {
			personaJuridica = toPersonaJuridica(results);
		}
		return personaJuridica;

		}catch(Exception e) {
			throw new Exception(e);
		}
	}
	
	public void createPersonaJuridica(PersonaJuridica personaJuridica, Connection conn) throws Exception {
		try {
		PreparedStatement statement = conn.prepareStatement("INSERT INTO PersonasJuridicas (dni, nombre, apellido, razonSocial, fecha, cuit) VALUES (?, ?, ?, ?, ?, ?)");
		statement.setString(2, personaJuridica.getNombrePersona());
		statement.setString(3, personaJuridica.getApellidoPersona());
		statement.setInt(1, personaJuridica.getDniPersona());
		statement.setString(4, personaJuridica.getRazonSocial());
		// problema 
	//	statement.setDate(5, personaJuridica.getFechaInicioAct());
		statement.setInt(6, personaJuridica.getCuit());
		statement.executeQuery();
		} catch (Exception e) {
			throw new Exception(e);
		}
	}

	public void deletePersonaJuridica(PersonaJuridica personaJuridica, Connection conn) throws Exception {
		try {
		PreparedStatement statement = conn.prepareStatement("DELETE FROM personasJuridicas WHERE cuit = ?");
		statement.setInt(1, personaJuridica.getCuit());
		statement.executeUpdate();
		}catch (Exception e) {
			throw new Exception(e);
		}
	}
	
	public int updatePersonaJuridica(PersonaJuridica personaJuridica, Connection conn) throws Exception {
		try {
			PreparedStatement statement = conn.prepareStatement("UPDATE personasJuridicas SET nombre = ?, apellido = ?, razonSocial = ?, fecha = ? WHERE cuit = ?");
			statement.setString(1, personaJuridica.getNombrePersona());
			statement.setString(2, personaJuridica.getApellidoPersona());
			statement.setString(3, personaJuridica.getRazonSocial());
			//problema
			//statement.setDate(4, personaJuridica.getFechaInicioAct());
			statement.setInt(5, personaJuridica.getDniPersona());
			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new Exception(e);
		}
	}

	private PersonaJuridica toPersonaJuridica(ResultSet resultados) throws SQLException {
		return new PersonaJuridica(resultados.getString(3), resultados.getString(2),resultados.getInt(1), resultados.getString(4), resultados.getDate(5), resultados.getInt(6));
	}

}
