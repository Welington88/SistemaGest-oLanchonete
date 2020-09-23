/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Beans.ClienteBeans;
import Utilitarios.Conexao;
import java.sql.PreparedStatement;
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
            String SQLInsertion = "insert into clientes `cli_nome`, "
                    + "`cli_rua`, `clibairro`, `cli_telefone`, `cli_data_cad` "
                    + "VALUES (?,?,?,?,?)";
            PreparedStatement st = Conexao.getConnection().prepareStatement(SQLInsertion);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, 
              "Erro ao Inserir no Banco de Dados", "Erro", 0,new ImageIcon("imagens/excluir.jpg"));//mensagem de erro
        }
                
    };
}
