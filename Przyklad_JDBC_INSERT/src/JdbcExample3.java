/*
 *   JDBC  INSERT  
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class JdbcExample3 {

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
        ResultSet rs = null;
        PreparedStatement pst = null;

		try {

			connection = DriverManager.getConnection(
					"jdbc:postgresql://127.0.0.1:5433/kursowa", "postgres",
					"admin");
			
			String stm = "INSERT INTO kontrola.straznik(imie,nazwisko,stopien,pensja) VALUES(?, ?,?,?)";
            pst = connection.prepareStatement(stm);
            
            pst.setString(1, "Jan");                    
 	        pst.setString(2, "Jeziorañski");
 	        pst.setString(3, "Szeregowiec");
            pst.setDouble(4, 2300.32);   
 	        pst.executeUpdate();
			
			

		} catch (SQLException e) {

			System.out.println("Blad polaczenia do bazy danych");
			e.printStackTrace();
			return;

		} finally {
        try {
            if (rs != null) {
                rs.close();
            }
            if (pst != null) {
                pst.close();
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