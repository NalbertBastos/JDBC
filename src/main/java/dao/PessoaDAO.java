package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import entities.Pessoa;
import model.connection.ConnectionMySQL;

public class PessoaDAO {
	private Connection connection;
	static final String QUERY = "SELECT id, nome, sobrenome, nascimento,sexo FROM pessoas";
	
	public PessoaDAO() throws SQLException{
 		this.connection = ConnectionMySQL.getConnectionMySQL();
 	}
	
	public void addPeople(Pessoa pessoas) throws SQLException{
 		PreparedStatement stmt = this.connection.prepareStatement("insert into pessoas(nome, sobrenome,nascimento,sexo)values(?,?,?,?)");
 		stmt.setString(1, pessoas.getNome());
 		stmt.setString(2, pessoas.getSobrenome());
 		stmt.setString(3, pessoas.getNascimento());
 		stmt.setString(4, pessoas.getSexo());
 		stmt.execute();
 		stmt.close();	
 	}
	
	public void selectPeolple() throws SQLException {
		Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(QUERY);
		
		while(rs.next()){
			System.out.println("ID: " + rs.getInt("id"));
			System.out.println("Nome: " + rs.getString("nome"));
			System.out.println("Sobrenome: " + rs.getString("sobrenome"));
			System.out.println("Data de nascimento: " + rs.getString("nascimento"));
			System.out.println("Sexo: " + rs.getString("sexo"));
		}
	}
	
	public void updatePeopleYear(String nas, int id)throws SQLException{
		PreparedStatement stmt = this.connection.prepareStatement("UPDATE pessoas set nascimento = ? where id = ? ");
		stmt.setString(1, nas);
		stmt.setInt(2, id);
		stmt.execute();
 		stmt.close();
	}
	
	public void updatePeolpleName(String nome, int id) throws SQLException{
		PreparedStatement stmt = this.connection.prepareStatement("UPDATE pessoas set nome = ? where id = ? ");
		stmt.setString(1, nome);
		stmt.setInt(2, id);
		stmt.execute();
 		stmt.close();
	}
    public void updatePeolpleLastName(String lname, int id) throws SQLException{
    	PreparedStatement stmt = this.connection.prepareStatement("UPDATE pessoas set sobrenome = ? where id = ? ");
		stmt.setString(1, lname);
		stmt.setInt(2, id);
		stmt.execute();
 		stmt.close();
		
	}
    public void updatePeolpleSexo(String sexo, int id) throws SQLException{
    	PreparedStatement stmt = this.connection.prepareStatement("UPDATE pessoas set sobrenome = ? where id = ? ");
		stmt.setString(1, sexo);
		stmt.setInt(2, id);
		stmt.execute();
 		stmt.close();
	}
	
	public void deletePeople(int id)throws SQLException{
		PreparedStatement stmt = this.connection.prepareStatement("DELETE from pessoas where id = ? ");
		stmt.setInt(1, id);
		stmt.execute();
 		stmt.close();
		
	}

}
