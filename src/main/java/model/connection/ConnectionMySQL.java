package model.connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionMySQL {
	public static String status = "Não conectou...";
	
	public ConnectionMySQL() {}
	
	public static Connection getConnectionMySQL() throws SQLException {
		Connection connection = null;
		try {
			String driverName = "com.mysql.jdbc.Driver";

			Class.forName(driverName);
			
			String serverName = "localhost";    

	        String mydatabase ="cadastros";        

	        String url = "jdbc:mysql://" + serverName + "/" + mydatabase;

	        String username = "root";        

	        String password = "";      

	        connection = DriverManager.getConnection(url, username, password);
	        
	        if (connection != null) {
	            status = ("STATUS--->Conectado com sucesso!");
	        } else {
	            status = ("STATUS--->Não foi possivel realizar conexão");
	        }
	        return connection;
		} catch (ClassNotFoundException e) {
			System.out.println("O driver expecificado nao foi encontrado.");

            return null;
		}
	}
	
	public static String statusConection() {
        return status;
    }
	
	public static boolean FecharConexao() {
        try {
        	ConnectionMySQL.getConnectionMySQL().close();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
	
	public static java.sql.Connection ReiniciarConexao() throws SQLException {
        FecharConexao();
        return ConnectionMySQL.getConnectionMySQL();

    }
	
}

