/*
 *   JDBC  PROSTY SELECT  
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcExample1 {

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
        Statement st = null;
        ResultSet rs = null;

		try {

			connection = DriverManager.getConnection(
					"jdbc:postgresql://127.0.0.1:5433/kursowa", "postgres",
					"admin");
			
			st = connection.createStatement();
            rs = st.executeQuery("SELECT VERSION()");

            if (rs.next()) {
                System.out.println(rs.getString(1));
            }

		} catch (SQLException e) {

			System.out.println("Blad polaczenia do bazy danych");
			e.printStackTrace();
			return;

		} finally {
        try {
            if (rs != null) {
                rs.close();
            }
            if (st != null) {
                st.close();
            }
            if (connection != null) {
                connection.close();
            }

        } catch (SQLException ex) {
            System.out.println("Blad zamykania polaczenia");
			ex.printStackTrace();
			return;
        }
    }
	}

}