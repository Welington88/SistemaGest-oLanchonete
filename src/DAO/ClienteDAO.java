package DAO;//Objeto de acesso dados (acrônimo do inglês Data Access Object-DAO

import Beans.ClienteBeans;
import Utilitarios.Conexao;
import Utilitarios.CorretorDatas;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * DAO classe executar a conexa com BD
 * @author welingtonmarquezini
 */
public class ClienteDAO {
    CorretorDatas corretorDatas = new CorretorDatas();
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
              "Dados Salvo com sucesso!!!", "Salvo", 1,
              new ImageIcon(getClass().getResource("/Icones/ok.png")));//salvo com sucesso
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, 
              "Erro ao Inserir no Banco de Dados", "Erro", 0,new ImageIcon(getClass().getResource("/Icones/ico_sair.png")));//mensagem de erro
        }
                
    }
    
    public String  proximoCliente(){
        String SQLSelection = "select * from clientes order by cli_cod desc limit 1";
        try {
            PreparedStatement st = Conexao.getConnection().prepareStatement(SQLSelection);
            ResultSet Rs = st.executeQuery();
            if (Rs.next()) {//pq ele efetuou a busca
                return (Integer.parseInt(Rs.getString("cli_cod"))+1) + "";
            }else{
                return "1";
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Consultar no Banco de Dados",
                    "Erro", 0,new ImageIcon(getClass().getResource("/Icones/ico_sair.png")));//mensagem de erro
            return "0";
        }
    }
    //-----------------------------------------------------------------------------------------------
    public void buscaCliente(String pesquisa, DefaultTableModel modeloTabela) {
        try {
            String SQLSelection = "SELECT * FROM `clientes` WHERE `cli_nome` like '%" + pesquisa + "%';";
            PreparedStatement st = Conexao.getConnection().prepareStatement(SQLSelection);
            ResultSet Rs = st.executeQuery();
            while(Rs.next()){//percorre até ultima linha encontrada
                modeloTabela.addRow(new Object[]{
                    Rs.getString("cli_cod"),
                    Rs.getString("cli_nome"),
                    Rs.getString("cli_rua"),
                    Rs.getString("cli_bairro"),
                    Rs.getString("cli_telefone")
                });
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Consultar no Banco de Dados",
                    "Erro", 0,new ImageIcon(getClass().getResource("/Icones/ico_sair.png")));//mensagem de erro
        }

    }
    //-----------------------------------------------------------------------------------------------
    public ClienteBeans preencherCampos(int Codigo){
        ClienteBeans clienteBeans = new ClienteBeans();
        try {
            String SQLSelection = "SELECT * FROM `clientes` WHERE cli_cod=?;";
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
            JOptionPane.showMessageDialog(null, "Erro ao Consultar no Banco de Dados",
                    "Erro", 0,new ImageIcon(getClass().getResource("/Icones/ico_sair.png")));//mensagem de erro
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
              "Dados Editados com sucesso!!!", "Salvo", 1,new ImageIcon(getClass().getResource("/Icones/ok.png")));//mensagem de erro
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, 
              "Erro ao Inserir no Banco de Dados", "Erro", 0,new ImageIcon(getClass().getResource("/Icones/ico_sair.png")));//mensagem de erro
        }
        
    }
    //-----------------------------------------------------------------------------------------------
    public void buscaCliente(String pesquisa, List<String> lista) {
        try {
            String SQLSelection = "SELECT * FROM `clientes` WHERE `cli_nome` like '%" + pesquisa + "%';";
            PreparedStatement st = Conexao.getConnection().prepareStatement(SQLSelection);
            ResultSet Rs = st.executeQuery();
            while(Rs.next()){//percorre até ultima linha encontrada
                lista.add(
                    Rs.getString("cli_cod") + " - " +
                    Rs.getString("cli_nome") + " - " +
                    Rs.getString("cli_telefone")
                 );
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Consultar no Banco de Dados",
                    "Erro", 0,new ImageIcon(getClass().getResource("/Icones/ico_sair.png")));//mensagem de erro
        }

    }
}
