package DAO;//Objeto de acesso dados (acrônimo do inglês Data Access Object-DAO

import Beans.CardapioBeans;
import Utilitarios.Conexao;
import Utilitarios.CorretorDatas;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * DAO classe executar a conexa com BD
 * @author welingtonmarquezini
 */
public class CardapioDAO {
    CorretorDatas corretorDatas = new CorretorDatas();
    public CardapioDAO() {//construtor
    }
    
    public void inserir(CardapioBeans obj){
        try {
            String SQLInsertion = 
            "INSERT INTO `cardapio`(`car_descricao`, `car_tipo`, `car_valor`) VALUES (?,?,?);";
            PreparedStatement st = Conexao.getConnection().prepareStatement(SQLInsertion);
            st.setString(1, obj.getDescricao());
            st.setString(2, obj.getTipo());
            st.setDouble(3, obj.getValor());
            
            st.execute();
            Conexao.getConnection().commit();// verifica se tudo está salvo correto.
            JOptionPane.showMessageDialog(null, 
              "Dados Salvo com sucesso!!!", "Salvo", 1,new ImageIcon("imagens/ok.png"));//mensagem de erro
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, 
              "Erro ao Inserir no Banco de Dados" + ex, "Erro", 0,new ImageIcon("imagens/ico_sair.png"));//mensagem de erro
        }
                
    }
    
    public static String  proximoNumero(){
        String SQLSelection = "select * from `cardapio` order by `car_cod` desc limit 1";
        try {
            PreparedStatement st = Conexao.getConnection().prepareStatement(SQLSelection);
            ResultSet Rs = st.executeQuery();
            if (Rs.next()) {//pq ele efetuou a busca
                return (Integer.parseInt(Rs.getString("car_cod"))+1) + "";
            }else{
                return "1";
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Consultar no Banco de Dados",
                    "Erro", 0,new ImageIcon("imagens/ico_sair.png"));//mensagem de erro
            return "0";
        }
    }
    public void buscar(String pesquisa, DefaultTableModel modeloTabela) {
        try {
            String SQLSelection = "SELECT * FROM `cardapio` WHERE `car_descricao` like '%" + pesquisa + "%';";
            PreparedStatement st = Conexao.getConnection().prepareStatement(SQLSelection);
            ResultSet Rs = st.executeQuery();
            while(Rs.next()){//percorre até ultima linha encontrada
                modeloTabela.addRow(new Object[]{
                    Rs.getString("car_cod"),
                    Rs.getString("car_descricao"),
                    Rs.getString("car_tipo"),
                    Rs.getString("car_valor")
                });
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Consultar no Banco de Dados" + ex,
                    "Erro", 0,new ImageIcon("imagens/ico_sair.png"));//mensagem de erro
        }

    }
    //-----------------------------------------------------------------------------------------------
    public CardapioBeans preencherCampos(int Codigo){
        CardapioBeans cardapioBeans = new CardapioBeans();
        try {
            String SQLSelection = "SELECT * FROM `cardapio` WHERE `car_cod`=?;";
            PreparedStatement st = Conexao.getConnection().prepareStatement(SQLSelection);
            st.setInt(1, Codigo);//coloco código do cliente e fazer consultar SQL
            ResultSet Rs = st.executeQuery();
            if(Rs.next()){//percorre até ultima linha encontrada
                cardapioBeans.setCodigo(Rs.getInt("car_cod"));
                cardapioBeans.setDescricao(Rs.getString("car_descricao"));
                cardapioBeans.setTipo(Rs.getString("car_tipo"));
                cardapioBeans.setValor(Rs.getDouble("car_valor"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Consultar no Banco de Dados" + ex,
                    "Erro", 0,new ImageIcon("imagens/ico_sair.png"));//mensagem de erro
        }
        return cardapioBeans;
    }
    //-----------------------------------------------------------------------------------------------
    public void editar(CardapioBeans obj) {
        
        try {
            String SQLInsertion = 
           "UPDATE `cardapio` SET `car_descricao`=?,`car_tipo`=?,`car_valor`=? WHERE `car_cod`=?";
            PreparedStatement st = Conexao.getConnection().prepareStatement(SQLInsertion);
            st.setString(1, obj.getDescricao());
            st.setString(2, obj.getTipo());
            st.setDouble(3, obj.getValor());
            st.setInt(4,obj.getCodigo());
            st.execute();
            Conexao.getConnection().commit();// verifica se tudo está salvo correto.
            JOptionPane.showMessageDialog(null, 
              "Dados Editados com sucesso!!!", "Salvo", 1,new ImageIcon("imagens/ok.png"));//mensagem de erro
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, 
              "Erro ao Inserir no Banco de Dados" + ex, "Erro", 0,new ImageIcon("imagens/ico_sair.png"));//mensagem de erro
        }
        
    }
}
