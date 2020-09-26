/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Beans.ClienteBeans;
import Utilitarios.Conexao;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author welingtonmarquezini
 */
public class ClienteDAO {
    
    public ClienteDAO() {//construtor
        
    }
    
    public void cadastroCliente(ClienteBeans cliente){
        try {
            String SQLInsertion = 
  "INSERT INTO `clientes`(`cli_nome`, `cli_rua`, `cli_bairro`, `cli_telefone`, `cli_data_cad`) VALUES (?,?,?,?,now());";
            PreparedStatement st = Conexao.getConnection().prepareStatement(SQLInsertion);
            st.setString(1, cliente.getNome());
            st.setString(2, cliente.getRua());
            st.setString(3, cliente.getBairro());
            st.setString(4, cliente.getTelefone());
            
            st.execute();
            Conexao.getConnection().commit();// verifica se tudo está salvo correto.
            JOptionPane.showMessageDialog(null, 
              "Dados Salvo com sucesso!!!", "Salvo", 1,new ImageIcon("imagens/ok.png"));//mensagem de erro
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, 
              "Erro ao Inserir no Banco de Dados" + ex, "Erro", 0,new ImageIcon("imagens/ico_sair.png"));//mensagem de erro
        }
                
    }
    
    public String  proximoCliente(){
        String SQLSelection = "select * from clientes order by cli_cod desc limit 1";
        try {
            PreparedStatement st = Conexao.getConnection().prepareStatement(SQLSelection);
            ResultSet Rs = st.executeQuery();
            if (Rs.next()) {//pq ele efetuou a busca
                return Integer.parseInt(Rs.getString("cli_cod")) + "";
            }else{
                return "1";
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Consultar no Banco de Dados",
                    "Erro", 0,new ImageIcon("imagens/ico_sair.png"));//mensagem de erro
            return "0";
        }
    }
}
