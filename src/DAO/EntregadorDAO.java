package DAO;//Objeto de acesso dados (acrônimo do inglês Data Access Object-DAO

import Beans.EntregadorBeans;
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
public class EntregadorDAO {
    CorretorDatas corretorDatas = new CorretorDatas();
    public EntregadorDAO() {//construtor
    }
    
    public void cadastroEntregador(EntregadorBeans ent){
        try {
            String SQLInsertion = 
            "INSERT INTO `entregador`(`ent_nome`, `ent_status`, `ent_data_cad`) VALUES (?,?,now());";
            PreparedStatement st = Conexao.getConnection().prepareStatement(SQLInsertion);
            st.setString(1, ent.getNome());
            st.setString(2, ent.getStatus());
            
            st.execute();
            Conexao.getConnection().commit();// verifica se tudo está salvo correto.
            JOptionPane.showMessageDialog(null, 
              "Dados Salvo com sucesso!!!", "Salvo", 1,new ImageIcon("imagens/ok.png"));//mensagem de erro
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, 
              "Erro ao Inserir no Banco de Dados" + ex, "Erro", 0,new ImageIcon("imagens/ico_sair.png"));//mensagem de erro
        }
                
    }
    
    public static String  proximoEntregador(){
        String SQLSelection = "select * from `entregador` order by `ent_cod` desc limit 1";
        try {
            PreparedStatement st = Conexao.getConnection().prepareStatement(SQLSelection);
            ResultSet Rs = st.executeQuery();
            if (Rs.next()) {//pq ele efetuou a busca
                return (Integer.parseInt(Rs.getString("fun_cod"))+1) + "";
            }else{
                return "1";
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Consultar no Banco de Dados",
                    "Erro", 0,new ImageIcon("imagens/ico_sair.png"));//mensagem de erro
            return "0";
        }
    }
    public void buscaEntregador(String pesquisa, DefaultTableModel modeloTabela) {
        try {
            String SQLSelection = "SELECT * FROM `entregador` WHERE `ent_nome` like '%" + pesquisa + "%';";
            PreparedStatement st = Conexao.getConnection().prepareStatement(SQLSelection);
            ResultSet Rs = st.executeQuery();
            while(Rs.next()){//percorre até ultima linha encontrada
                modeloTabela.addRow(new Object[]{
                    Rs.getString("ent_cod"),
                    Rs.getString("ent_nome"),
                    CorretorDatas.ConverterParaJava(Rs.getString("ent_data_cad"))
                });
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Consultar no Banco de Dados" + ex,
                    "Erro", 0,new ImageIcon("imagens/ico_sair.png"));//mensagem de erro
        }

    }
    //-----------------------------------------------------------------------------------------------
    public EntregadorBeans preencherCampos(int Codigo){
        EntregadorBeans entregadorBeans = new EntregadorBeans();
        try {
            String SQLSelection = "SELECT * FROM `entregador` WHERE `ent_cod`=?;";
            PreparedStatement st = Conexao.getConnection().prepareStatement(SQLSelection);
            st.setInt(1, Codigo);//coloco código do cliente e fazer consultar SQL
            ResultSet Rs = st.executeQuery();
            if(Rs.next()){//percorre até ultima linha encontrada
                entregadorBeans.setCodigo(Rs.getInt("ent_cod"));
                entregadorBeans.setNome(Rs.getString("ent_nome"));
                entregadorBeans.setDataCad(CorretorDatas.ConverterParaJava(Rs.getString("ent_data_cad")));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Consultar no Banco de Dados" + ex,
                    "Erro", 0,new ImageIcon("imagens/ico_sair.png"));//mensagem de erro
        }
        return entregadorBeans;
    }
    //-----------------------------------------------------------------------------------------------
    public void editarEntregador(EntregadorBeans ent) {
        
        try {
            String SQLInsertion = 
                "UPDATE `entregador` SET `ent_nome`=? WHERE `ent_cod`=?";
            PreparedStatement st = Conexao.getConnection().prepareStatement(SQLInsertion);
            st.setString(1, ent.getNome());
            st.setInt(2, ent.getCodigo());
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
