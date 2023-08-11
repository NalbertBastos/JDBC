package view;

import javax.swing.*;

import dao.PessoaDAO;
import entities.Pessoa;
import model.connection.ConnectionMySQL;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CadastroClienteGUI {
    public static void main(String[] args) throws SQLException {
    	final PessoaDAO po = new PessoaDAO();
    	final Pessoa p = new Pessoa();
        JFrame frame = new JFrame("Cadastro de Cliente");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));

        panel.add(new JLabel("Nome:")).getInputMethodRequests();
        final JTextField nomeField = new JTextField();
        panel.add(nomeField);

        panel.add(new JLabel("Sobrenome:")).getInputMethodRequests();
        final JTextField sobrenomeField = new JTextField();
        panel.add(sobrenomeField);

        panel.add(new JLabel("Data de Nascimento:"));
        final JTextField dataNascimentoField = new JTextField();
        panel.add(dataNascimentoField);

        panel.add(new JLabel("Sexo:")).getInputMethodRequests();
        final JComboBox<String> sexoComboBox = new JComboBox<>(new String[]{"Masculino", "Feminino"});
        panel.add(sexoComboBox);

        JButton cadastrarButton = new JButton("Cadastrar");
        cadastrarButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
                String nome = nomeField.getText();
                String sobrenome = sobrenomeField.getText();
                String dataNascimento = dataNascimentoField.getText();
                String sexo = (String) sexoComboBox.getSelectedItem();
                
                if (nome.isEmpty() || sobrenome.isEmpty() || dataNascimento.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios.");
                } else {
                	try {
                		p.setNome(nome);
                		p.setSobrenome(sobrenome);
                		p.setNascimento(dataNascimento);
                		p.setSexo(sexo);
                		po.addPeople(p);
                		
                        ConnectionMySQL.FecharConexao();

                        JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
                        System.out.println("Sucesso");
                        System.out.println("***************************************");
                		System.out.println("***************************************");
                		System.out.println("***************************************");
                        po.selectPeolple();
                        System.out.println("***************************************");
                		System.out.println("***************************************");
                		System.out.println("***************************************");
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Erro ao cadastrar cliente.");
                    }
                }
                }

                
        });
        panel.add(cadastrarButton);

        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }
}
