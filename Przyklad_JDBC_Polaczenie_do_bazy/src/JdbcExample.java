/*
 *   JDBC  Po³¹czenie do bazy
 */

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class JdbcExample {

	public static void main(String[] argv) {

		System.out.println("----Test polaczenia do bazy Postgres --------");

		try {

			Class.forName("org.postgresql.Driver");

		} catch (ClassNotFoundException e) {

			System.out.println("Nie znaleziono drivera Postgresa");
			e.printStackTrace();
			return;

		}

		System.out.println("PostgreSQL JDBC Driver zarejestrowany");

		Connection connection = null;

		try {

			connection = DriverManager.getConnection(
					"jdbc:postgresql://127.0.0.1:5433/kursowa", "postgres",
					"admin");

		} catch (SQLException e) {

			System.out.println("Blad polaczenia do bazy danych");
			e.printStackTrace();
			return;

		}

		if (connection != null) {
			System.out.println("==Tu mozna dodac operacje na DB==");
		} else {
			System.out.println("Polaczenie nieudane");
		}
	}

}