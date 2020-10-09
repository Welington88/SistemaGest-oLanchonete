/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Utilitarios.Conexao;
import Utilitarios.CorretorDatas;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author welingtonmarquezini
 */
public class TelaPedidoDAO {

    //contrutor
    public TelaPedidoDAO() {
    }
    
    //metodos
    public void MostrarPedidos(DefaultTableModel modelo){
    
         try {
            String SQLPesquisa = "SELECT * FROM `pedidos` order by `ped_hora` desc;";
            PreparedStatement ps = Conexao.getConnection().prepareStatement(SQLPesquisa);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {// se pesquisa encontrou algo
                modelo.addRow(new Object[] {
                    rs.getString("ped_cod"),
                    CorretorDatas.ConverterParaJava(rs.getString("ped_data")),
                    rs.getString("ped_hora"),
                    rs.getString("ped_status")
                });
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, 
              "Erro ao consultar Banco de Dados" + ex, "Erro", 0,new ImageIcon("imagens/ico_sair.png"));//mensagem de erro
        }
    }
    
    
    public void alterarPedido(String status,int num_pedido){
        try {
            String SQL = 
            "UPDATE `pedidos` SET `ped_status`=? WHERE `ped_cod`=?";
            PreparedStatement st;
            st = Conexao.getConnection().prepareStatement(SQL);
            st.setString(1,status);
            st.setInt(2,num_pedido);
            st.execute();
            Conexao.getConnection().commit();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, 
              "Erro ao Inserir no Banco de Dados" + ex, "Erro", 0,new ImageIcon("imagens/ico_sair.png"));//mensagem de erro
        }
            
    }
    
}
