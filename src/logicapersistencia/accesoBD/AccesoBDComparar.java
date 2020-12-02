package logicapersistencia.accesoBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccesoBDComparar {

	AccesoBD a = new AccesoBD();

	

	public boolean existeArrendatario(String idArrendatario) throws SQLException {
		Connection con = a.conectarBD();

		ConsultasComparar consultas = new ConsultasComparar();
		String preguntar = consultas.existeArrendatario();

		PreparedStatement stmt;

		stmt = con.prepareStatement(preguntar);
		stmt.setString(1, idArrendatario);
		ResultSet rs = stmt.executeQuery();
		boolean existe = false;
		String resultado = "";
		while (rs.next()) {
			resultado = rs.getString("idArrendatario");

			int resultado2 = Integer.parseInt(resultado);
			int cedula2 = Integer.parseInt(idArrendatario);

			if (resultado2 == cedula2) {
				existe = true;
			}
		}
		rs.close();
		stmt.close();
		a.desconectarBD(con);
		return existe;

	}

	public boolean existeComprador(String idComprador) throws SQLException {
		Connection con = a.conectarBD();

		ConsultasComparar consultas = new ConsultasComparar();
		String preguntar = consultas.existeComprador();

		PreparedStatement stmt;

		stmt = con.prepareStatement(preguntar);
		stmt.setString(1, idComprador);
		ResultSet rs = stmt.executeQuery();
		boolean existe = false;
		String resultado = "";
		while (rs.next()) {
			resultado = rs.getString("idComprador");

			int resultado2 = Integer.parseInt(resultado);
			int cedula2 = Integer.parseInt(idComprador);

			if (resultado2 == cedula2) {
				existe = true;
			}
		}
		rs.close();
		stmt.close();
		a.desconectarBD(con);
		return existe;

	}

	public boolean existeFormaDePago(String formaDePago) throws SQLException {
		Connection con = a.conectarBD();

		ConsultasComparar consultas = new ConsultasComparar();
		String preguntar = consultas.existeFormaDePago();

		PreparedStatement stmt;

		stmt = con.prepareStatement(preguntar);
		stmt.setString(1, formaDePago);
		ResultSet rs = stmt.executeQuery();
		boolean existe = false;
		String resultado = "";
		while (rs.next()) {
			resultado = rs.getString("formaDePago");

			int resultado2 = Integer.parseInt(resultado);
			int cedula2 = Integer.parseInt(formaDePago);

			if (resultado2 == cedula2) {
				existe = true;
			}
		}
		rs.close();
		stmt.close();
		a.desconectarBD(con);
		return existe;

	}

	public boolean existeOperador(String idOperador) throws SQLException {
		Connection con = a.conectarBD();

		ConsultasComparar consultas = new ConsultasComparar();
		String preguntar = consultas.existeOperador();

		PreparedStatement stmt;

		stmt = con.prepareStatement(preguntar);
		stmt.setString(1, idOperador);
		ResultSet rs = stmt.executeQuery();
		boolean existe = false;
		String resultado = "";
		while (rs.next()) {
			resultado = rs.getString("idOperador");

			int resultado2 = Integer.parseInt(resultado);
			int cedula2 = Integer.parseInt(idOperador);

			if (resultado2 == cedula2) {
				existe = true;
			}
		}
		rs.close();
		stmt.close();
		a.desconectarBD(con);
		return existe;

	}

	public boolean existeTelefono(String idPersona) throws SQLException {
		Connection con = a.conectarBD();

		ConsultasComparar consultas = new ConsultasComparar();
		String preguntar = consultas.existeTelefono();

		PreparedStatement stmt;

		stmt = con.prepareStatement(preguntar);
		stmt.setString(1, idPersona);
		ResultSet rs = stmt.executeQuery();
		boolean existe = false;
		String resultado = "";
		while (rs.next()) {
			resultado = rs.getString("idPersona");

			int resultado2 = Integer.parseInt(resultado);
			int cedula2 = Integer.parseInt(idPersona);

			if (resultado2 == cedula2) {
				existe = true;
			}
		}
		rs.close();
		stmt.close();
		a.desconectarBD(con);
		return existe;

	}

	// ----------------------------- A PARTIR DE ACÁ YA ESTA TODO CONECTADO
	// -----------------------------//

	public boolean existeUsuario(String usuario, String clave) throws SQLException {
		Connection con = a.conectarBD();

		ConsultasComparar consultas = new ConsultasComparar();
		String preguntar = consultas.existeUsuario();

		PreparedStatement stmt;

		stmt = con.prepareStatement(preguntar);
		stmt.setString(1, usuario);
		stmt.setString(2, clave);
		ResultSet rs = stmt.executeQuery();
		boolean existe = false;
		while (rs.next()) {
			existe = true;
		}
		rs.close();
		stmt.close();
		a.desconectarBD(con);
		return existe;

	}

	// **********************************************************************************
	// ****************************************************************//

	public boolean existeCasa(int idCasa) throws SQLException {
		Connection con = a.conectarBD();

		ConsultasComparar consultas = new ConsultasComparar();
		String preguntar = consultas.existeCasa();

		PreparedStatement stmt;

		stmt = con.prepareStatement(preguntar);
		stmt.setInt(1, idCasa);
		ResultSet rs = stmt.executeQuery();
		boolean existe = false;
		String resultado = "";
		while (rs.next()) {
			resultado = rs.getString("idCasa");

			int resultado2 = Integer.parseInt(resultado);
			int cedula2 = idCasa;

			if (resultado2 == cedula2) {
				existe = true;
			}
		}
		rs.close();
		stmt.close();
		a.desconectarBD(con);
		return existe;

	}

	public boolean existeInmueble(int refInmueble) throws SQLException {
		Connection con = a.conectarBD();

		ConsultasComparar consultas = new ConsultasComparar();
		String preguntar = consultas.existeInmueble();

		PreparedStatement stmt;

		stmt = con.prepareStatement(preguntar);
		stmt.setInt(1, refInmueble);
		ResultSet rs = stmt.executeQuery();
		boolean existe = false;
		String resultado = "";
		while (rs.next()) {
			resultado = rs.getString("idInmueble");

			int resultado2 = Integer.parseInt(resultado);
			int resultInm2 = refInmueble;

			if (resultado2 == resultInm2) {
				existe = true;
			}
		}
		rs.close();
		stmt.close();
		a.desconectarBD(con);
		return existe;

	}

	public boolean existePersona(int idPersona) throws SQLException {
		Connection con = a.conectarBD();

		ConsultasComparar consultas = new ConsultasComparar();
		String preguntar = consultas.existePersona();

		PreparedStatement stmt;

		stmt = con.prepareStatement(preguntar);
		stmt.setInt(1, idPersona);
		ResultSet rs = stmt.executeQuery();
		boolean existe = false;
		String resultado = "";
		while (rs.next()) {
			resultado = rs.getString("idPersona");

			int resultado2 = Integer.parseInt(resultado);
			int cedula2 = idPersona;

			if (resultado2 == cedula2) {
				existe = true;
			}
		}
		rs.close();
		stmt.close();
		a.desconectarBD(con);
		return existe;

	}

	public boolean existePropietario(int idPropietario) throws SQLException {
		Connection con = a.conectarBD();

		ConsultasComparar consultas = new ConsultasComparar();
		String preguntar = consultas.existePropietario();

		PreparedStatement stmt;

		stmt = con.prepareStatement(preguntar);
		stmt.setInt(1, idPropietario);
		ResultSet rs = stmt.executeQuery();
		boolean existe = false;
		String resultado = "";
		while (rs.next()) {
			resultado = rs.getString("idPropietario");

			int resultado2 = Integer.parseInt(resultado);
			int cedula2 = idPropietario;

			if (resultado2 == cedula2) {
				existe = true;
			}
		}
		rs.close();
		stmt.close();
		a.desconectarBD(con);
		return existe;

	}

	public boolean existeApartamento(int idApartamento) throws SQLException {
		Connection con = a.conectarBD();

		ConsultasComparar consultas = new ConsultasComparar();
		String preguntar = consultas.existeApartamento();

		PreparedStatement stmt;

		stmt = con.prepareStatement(preguntar);
		stmt.setInt(1, idApartamento);
		ResultSet rs = stmt.executeQuery();
		boolean existe = false;
		String resultado = "";
		while (rs.next()) {
			resultado = rs.getString("idApartamento");

			int resultado2 = Integer.parseInt(resultado);
			int cedula2 = idApartamento;

			if (resultado2 == cedula2) {
				existe = true;
			}
		}
		rs.close();
		stmt.close();
		a.desconectarBD(con);
		return existe;

	}

	public boolean existeTerreno(int idTerreno) throws SQLException {
		Connection con = a.conectarBD();

		ConsultasComparar consultas = new ConsultasComparar();
		String preguntar = consultas.existeTerreno();

		PreparedStatement stmt;

		stmt = con.prepareStatement(preguntar);
		stmt.setInt(1, idTerreno);
		ResultSet rs = stmt.executeQuery();
		boolean existe = false;
		String resultado = "";
		while (rs.next()) {
			resultado = rs.getString("idTerreno");

			int resultado2 = Integer.parseInt(resultado);
			int cedula2 = idTerreno;

			if (resultado2 == cedula2) {
				existe = true;
			}
		}
		rs.close();
		stmt.close();
		a.desconectarBD(con);
		return existe;

	}
	
	public boolean existeAlquiler(int idAlquiler) throws SQLException {
		Connection con = a.conectarBD();

		ConsultasComparar consultas = new ConsultasComparar();
		String preguntar = consultas.existeAlquiler();

		PreparedStatement stmt;

		stmt = con.prepareStatement(preguntar);
		stmt.setInt(1, idAlquiler);
		ResultSet rs = stmt.executeQuery();
		boolean existe = false;
		String resultado = "";
		while (rs.next()) {
			resultado = rs.getString("idAlquiler");

			int resultado2 = Integer.parseInt(resultado);
			
			if (resultado2 == idAlquiler) {
				existe = true;
			}
		}
		rs.close();
		stmt.close();
		a.desconectarBD(con);
		return existe;

	}

	
	public boolean existeVenta(int idVenta) throws SQLException {
		Connection con = a.conectarBD();

		ConsultasComparar consultas = new ConsultasComparar();
		String preguntar = consultas.existeVenta();

		PreparedStatement stmt;

		stmt = con.prepareStatement(preguntar);
		stmt.setInt(1, idVenta);
		ResultSet rs = stmt.executeQuery();
		boolean existe = false;
		String resultado = "";
		while (rs.next()) {
			resultado = rs.getString("idVenta");

			int resultado2 = Integer.parseInt(resultado);
			
			if (resultado2 == idVenta) {
				existe = true;
			}
		}
		rs.close();
		stmt.close();
		a.desconectarBD(con);
		return existe;

	}

}
