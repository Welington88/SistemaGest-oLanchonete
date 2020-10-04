package DAO;

import Beans.ClienteBeans;
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
 *
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
    
    public static String  proximoCliente(){
        String SQLSelection = "select * from funcionarios order by fun_cod desc limit 1";
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
            String SQLSelection = "SELECT * FROM funcionarios WHERE fun_cod like '%" + pesquisa + "%';";
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
    public ClienteBeans preenhcerCampos(int Codigo){
        ClienteBeans clienteBeans = new ClienteBeans();
        try {
            String SQLSelection = "SELECT * FROM funcionarios WHERE fun_cod=?;";
            PreparedStatement st = Conexao.getConnection().prepareStatement(SQLSelection);
            st.setInt(1, Codigo);//coloco código do cliente e fazer consultar SQL
            ResultSet Rs = st.executeQuery();
            if(Rs.next()){//percorre até ultima linha encontrada
                clienteBeans.setCodigo(Rs.getInt("cli_cod"));
                clienteBeans.setNome(Rs.getString("cli_nome"));
                clienteBeans.setRua(Rs.getString("cli_rua"));
                clienteBeans.setBairro(Rs.getString("cli_bairro"));
                clienteBeans.setTelefone(Rs.getString("cli_telefone"));
                clienteBeans.setDataCad(CorretorDatas.ConverterParaJava(Rs.getString("cli_data_cad")));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Consultar no Banco de Dados" + ex,
                    "Erro", 0,new ImageIcon("imagens/ico_sair.png"));//mensagem de erro
        }
        return clienteBeans;
    }
    //-----------------------------------------------------------------------------------------------
    public void editarCliente(ClienteBeans cliente) {
        
        try {
            String SQLInsertion = 
                "UPDATE `clientes` SET `cli_nome`=?,`cli_rua`=?,`cli_bairro`=?,`cli_telefone`=? WHERE `cli_cod`=?";
            PreparedStatement st = Conexao.getConnection().prepareStatement(SQLInsertion);
            st.setString(1, cliente.getNome());
            st.setString(2, cliente.getRua());
            st.setString(3, cliente.getBairro());
            st.setString(4, cliente.getTelefone());
            st.setInt(5, cliente.getCodigo());
            
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
