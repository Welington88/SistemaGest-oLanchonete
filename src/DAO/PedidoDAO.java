package DAO;

import Utilitarios.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
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
    
}
