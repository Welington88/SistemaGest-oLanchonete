package DAO;

import Beans.FuncionarioBeans;
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
public class FuncionarioDAO {
    CorretorDatas corretorDatas = new CorretorDatas();
    public FuncionarioDAO() {//construtor
    }
    
    public void cadastroCliente(FuncionarioBeans func){
        try {
            String SQLInsertion = 
            "INSERT INTO `funcionarios`(`fun_nome`, `fun_cargo`, `fun_data_cad`) VALUES (?,?,now());";
            PreparedStatement st = Conexao.getConnection().prepareStatement(SQLInsertion);
            st.setString(1, func.getNome());
            st.setString(2, func.getCargo());
            
            st.execute();
            Conexao.getConnection().commit();// verifica se tudo está salvo correto.
            JOptionPane.showMessageDialog(null, 
              "Dados Salvo com sucesso!!!", "Salvo", 1,new ImageIcon("imagens/ok.png"));//mensagem de erro
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, 
              "Erro ao Inserir no Banco de Dados" + ex, "Erro", 0,new ImageIcon("imagens/ico_sair.png"));//mensagem de erro
        }
                
    }
    
    public static String  proximoFuncionario(){
        String SQLSelection = "select * from `funcionarios` order by `fun_cod` desc limit 1";
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
    public void buscaCliente(String pesquisa, DefaultTableModel modeloTabela) {
        try {
            String SQLSelection = "SELECT * FROM `funcionarios` WHERE `fun_cod` like '%" + pesquisa + "%';";
            PreparedStatement st = Conexao.getConnection().prepareStatement(SQLSelection);
            ResultSet Rs = st.executeQuery();
            while(Rs.next()){//percorre até ultima linha encontrada
                modeloTabela.addRow(new Object[]{
                    Rs.getString("fun_cod"),
                    Rs.getString("fun_nome"),
                    Rs.getString("fun_cargo")
                });
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Consultar no Banco de Dados" + ex,
                    "Erro", 0,new ImageIcon("imagens/ico_sair.png"));//mensagem de erro
        }

    }
    //-----------------------------------------------------------------------------------------------
    public FuncionarioBeans preencherCampos(int Codigo){
        FuncionarioBeans funcionarioBeans = new FuncionarioBeans();
        try {
            String SQLSelection = "SELECT * FROM `funcionarios` WHERE `fun_cod`=?;";
            PreparedStatement st = Conexao.getConnection().prepareStatement(SQLSelection);
            st.setInt(1, Codigo);//coloco código do cliente e fazer consultar SQL
            ResultSet Rs = st.executeQuery();
            if(Rs.next()){//percorre até ultima linha encontrada
                funcionarioBeans.setCodigo(Rs.getInt("fun_cod"));
                funcionarioBeans.setNome(Rs.getString("fun_nome"));
                funcionarioBeans.setCargo(Rs.getString("fun_Cargo"));
                funcionarioBeans.setDataCad(CorretorDatas.ConverterParaJava(Rs.getString("fun_data_cad")));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Consultar no Banco de Dados" + ex,
                    "Erro", 0,new ImageIcon("imagens/ico_sair.png"));//mensagem de erro
        }
        return funcionarioBeans;
    }
    //-----------------------------------------------------------------------------------------------
    public void editarCliente(FuncionarioBeans funcionario) {
        
        try {
            String SQLInsertion = 
                "UPDATE `funcionarios` SET ,`fun_nome`=?,`fun_cargo`=? WHERE `fun_cod`=?";
            PreparedStatement st = Conexao.getConnection().prepareStatement(SQLInsertion);
            st.setString(1, funcionario.getNome());
            st.setString(2, funcionario.getCargo());
            st.setInt(3, funcionario.getCodigo());
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
