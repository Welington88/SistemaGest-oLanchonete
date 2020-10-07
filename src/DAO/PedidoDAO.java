package DAO;

import Utilitarios.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author welingtonmarquezini
 */
public class PedidoDAO {
    public void pesquisaItens(String pesquisa, List<String> listaDeItens){
        try {
            String SQLPesquisa = "SELECT * FROM `cardapio` WHERE `car_descricao` Like '%" + pesquisa + "%';";
            PreparedStatement ps = Conexao.getConnection().prepareStatement(SQLPesquisa);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {// percorre ate o final da lista da pesquisa no banco de dados                
                listaDeItens.add(rs.getString("car_descricao"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, 
              "Erro ao consultar Banco de Dados" + ex, "Erro", 0,new ImageIcon("imagens/ico_sair.png"));//mensagem de erro
        }
    }
    
    public double valorDoItem(String pesquisa){
        try {
            String SQLPesquisa = "SELECT * FROM `cardapio` WHERE `car_descricao`=?;";
            PreparedStatement ps = Conexao.getConnection().prepareStatement(SQLPesquisa);
            ps.setString(1,pesquisa);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {// se pesquisa encontrou algo
                return rs.getDouble("car_valor");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, 
              "Erro ao consultar Banco de Dados" + ex, "Erro", 0,new ImageIcon("imagens/ico_sair.png"));//mensagem de erro
        }
        return 0;
    }
    
    public int valorDoCodigo(String pesquisa){
        try {
            String SQLPesquisa = "SELECT * FROM `cardapio` WHERE `car_descricao`=?;";
            PreparedStatement ps = Conexao.getConnection().prepareStatement(SQLPesquisa);
            ps.setString(1,pesquisa);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {// se pesquisa encontrou algo
                return rs.getInt("car_cod");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, 
              "Erro ao consultar Banco de Dados" + ex, "Erro", 0,new ImageIcon("imagens/ico_sair.png"));//mensagem de erro
        }
        return 0;
    }
    
    public void CadastrarPedido(String CodigoCliente, 
                                String CodigoFuncionario,
                                String Total){
        try {
            Date data = new Date();
            SimpleDateFormat formatoData = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");
            String SQLInsert = 
            "INSERT INTO `pedidos`(`ped_data`,`ped_hora`,`ped_total`,`ped_cli_cod`,`ped-fun-cod`,`ped-ent-cod`,`ped_status`) VALUES (?,?,?,?,?,?,?);";
            PreparedStatement st;
            st = Conexao.getConnection().prepareStatement(SQLInsert);
            st.setString(1,formatoData.format(data));
            st.setString(2,formatoHora.format(data));
            st.setString(3,CodigoCliente);
            st.setString(4,CodigoFuncionario);
            st.setString(5,"0");
            st.setString(6,Total);
            st.setString(7,"Pedido Aberto");
            st.execute();
            Conexao.getConnection().commit();
            JOptionPane.showMessageDialog(null, 
              "Dados Salvo com sucesso!!!", "Salvo", 1,new ImageIcon("imagens/ok.png"));//salvo com sucesso
        } catch (SQLException ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }
}
