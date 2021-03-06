package DAO;

import Beans.PedidoBeans;
import Utilitarios.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
              "Erro ao consultar Banco de Dados", "Erro", 0,new ImageIcon(getClass().getResource("/Icones/ico_sair.png")));//mensagem de erro
        }
    }
    
    public String codigoDoPedido(){
        String Cod = "0";
        try {
            String SQLSelection = "SELECT `ped_cod` FROM `pedidos` ORDER BY `ped_cod` desc limit 1";
            PreparedStatement ps = Conexao.getConnection().prepareStatement(SQLSelection);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                Cod = rs.getString("ped_cod");
                //JOptionPane.showMessageDialog(null,"Pedido Nº" + Cod, "Pedido", 1,new ImageIcon("imagens/ok.png"));//salvo com sucesso
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, 
              "Erro ao consultar Banco de Dados", "Erro", 0,new ImageIcon(getClass().getResource("/Icones/ico_sair.png")));//mensagem de erro
        }
        return Cod;
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
              "Erro ao consultar Banco de Dados", "Erro", 0,new ImageIcon(getClass().getResource("/Icones/ico_sair.png")));//mensagem de erro
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
              "Erro ao consultar Banco de Dados", "Erro", 0,new ImageIcon(getClass().getResource("/Icones/ico_sair.png")));//mensagem de erro
        }
        return 0;
    }
    
    public void CadastrarPedido(String CodigoCliente, 
                                String CodigoFuncionario,
                                String CodigoEntregador,
                                String formaPGTO,
                                String Total, int TamanhoTabela, PedidoBeans pedidoBeans){
        try {
            Date data = new Date();
            SimpleDateFormat formatoData = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");
            String SQLInsert = 
            "INSERT INTO `pedidos`(`ped_data`,`ped_hora`,`ped_total`,`ped_cli_cod`,`ped-fun-cod`,`ped-ent-cod`,`ped_status`,`ped_forma_pgto`) VALUES (?,?,?,?,?,?,?,?);";
            PreparedStatement st;
            st = Conexao.getConnection().prepareStatement(SQLInsert);
            st.setString(1,formatoData.format(data));
            st.setString(2,formatoHora.format(data));
            st.setString(3,Total.replace(',', '.'));
            st.setString(4,CodigoCliente);
            st.setString(5,CodigoFuncionario);
            st.setString(6,CodigoEntregador);
            st.setString(7,"Pedido Aberto");
            st.setString(8, formaPGTO);
            st.execute();
            //cadastrar estoque
            CadastraItens(CodigoCliente, CodigoFuncionario, codigoDoPedido(), 
                    CodigoEntregador,TamanhoTabela, pedidoBeans);
            codigoDoPedido();
            Conexao.getConnection().commit();
            JOptionPane.showMessageDialog(null, 
              "Dados Salvo com sucesso!!!", "Salvo", 1,new ImageIcon(getClass().getResource("/Icones/ok.png")));//salvo com sucesso
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, 
              "Erro ao Inserir no Banco de Dados", "Erro", 0,new ImageIcon(getClass().getResource("/Icones/ico_sair.png")));//mensagem de erro
        }
            
    }
    
    public void CadastraItens(String codigoCliente, String codigoFuncionario, 
            String codigoPedido, String codigoEntregador,int tamanhoTabela, PedidoBeans pedidoBeans){
        for (int i = 0; i < tamanhoTabela; i++) {
            try {
                String SQLInserir =
                        "INSERT INTO `item`(`item_ent_cod`, `item_fun_cod`, `item_cli_cod`, `item_ped_cod`, `item_car_cod`, `item_quantidade`) VALUES (?,?,?,?,?,?);";
                PreparedStatement st = Conexao.getConnection().prepareStatement(SQLInserir);
                st.setString(1, codigoEntregador);
                st.setString(2, codigoFuncionario);
                st.setString(3, codigoCliente);
                st.setString(4, codigoPedido);
                st.setInt(5, pedidoBeans.getCodCadapio(i));
                st.setInt(6, pedidoBeans.getQuantidade(i));
                st.execute();
            } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, 
                     "Erro ao Inserir no Banco de Dados", "Erro", 0,new ImageIcon(getClass().getResource("/Icones/ico_sair.png")));//mensagem de erro
            }
        }
    }
}
