package view;

import javax.swing.*;

import dao.PessoaDAO;
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
        JFrame frame = new JFrame("Cadastro de Cliente");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));

        panel.add(new JLabel("Nome:"));
        final JTextField nomeField = new JTextField();
        panel.add(nomeField);

        panel.add(new JLabel("Sobrenome:"));
        final JTextField sobrenomeField = new JTextField();
        panel.add(sobrenomeField);

        panel.add(new JLabel("Data de Nascimento:"));
        final JTextField dataNascimentoField = new JTextField();
        panel.add(dataNascimentoField);

        panel.add(new JLabel("Sexo:"));
        final JComboBox<String> sexoComboBox = new JComboBox<>(new String[]{"Masculino", "Feminino"});
        panel.add(sexoComboBox);

        JButton cadastrarButton = new JButton("Cadastrar");
        cadastrarButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
                String nome = nomeField.getText();
                String sobrenome = sobrenomeField.getText();
                String dataNascimento = dataNascimentoField.getText();
                String sexo = (String) sexoComboBox.getSelectedItem();

                try {
                    Connection connection = ConnectionMySQL.getConnectionMySQL();
                    String query = "INSERT INTO pessoas (nome, sobrenome, nascimento, sexo) VALUES (?, ?, ?, ?)";
                    PreparedStatement preparedStatement = connection.prepareStatement(query);
                    preparedStatement.setString(1, nome);
                    preparedStatement.setString(2, sobrenome);
                    preparedStatement.setString(3, dataNascimento);
                    preparedStatement.setString(4, sexo);

                    preparedStatement.executeUpdate();

                    preparedStatement.close();
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
        });
        panel.add(cadastrarButton);

        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }
}
