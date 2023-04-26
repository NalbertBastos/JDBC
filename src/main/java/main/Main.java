package main;

import java.sql.SQLException;
import java.util.Scanner;

import dao.PessoaDAO;
import entities.Pessoa;

public class Main {

	public static void main(String[] args) throws SQLException {
		int escolha = 0;
		Scanner ler = new Scanner(System.in);
		
		PessoaDAO po = new PessoaDAO();
		
		Pessoa p = new Pessoa();
		
		
		/*System.out.println("Informe nome:");
		String nome = ler.next();
		p.setNome(nome);
		System.out.println("Informe sobrenome:");
		String sobrenome = ler.next();
		p.setSobrenome(sobrenome);
		System.out.println("Informe data de nascimento:");
		String nascimento = ler.next();
		p.setNascimento(nascimento);
		System.out.println("Informe sexo:");
		String sexo = ler.next();
		p.setSexo(sexo);
		
		po.addPeople(p);*/
		//po.updatePeopleYear();
		
		po.selectPeolple();
		//po.updatePeolpleLastName("Bastos dos Santos", 1);
		//po.deletePeople(7);
		System.out.println("***************************************");
		System.out.println("***************************************");
		System.out.println("***************************************");
		po.selectPeolple();
		System.out.println("***************************************");
		System.out.println("***************************************");
		System.out.println("***************************************");
		

	}
	
	
	

}
