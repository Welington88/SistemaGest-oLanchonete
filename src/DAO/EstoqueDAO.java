package DAO;//Objeto de acesso dados (acrônimo do inglês Data Access Object-DAO

import Beans.EstoqueBeans;
import Utilitarios.Conexao;
import Utilitarios.CorretorDatas;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 * DAO classe executar a conexa com BD
 * @author welingtonmarquezini
 */
public class EstoqueDAO {
    CorretorDatas corretorDatas = new CorretorDatas();
    public EstoqueDAO() {//construtor
    }
    
    public void inserir(EstoqueBeans obj){
        try {
            String SQLInsertion = 
            "INSERT INTO `estoque`(`est_car_cod`, `est_nfe`, `est_valor`, `est_qtd`) VALUES (?,?,?,?);";
            PreparedStatement st = Conexao.getConnection().prepareStatement(SQLInsertion);
            st.setInt(1, obj.getCodigoProduto());
            st.setString(2, obj.getNfe());
            st.setInt(3, obj.getQuantidade());
            st.setFloat(4, obj.getValor());
            
            st.execute();
            Conexao.getConnection().commit();// verifica se tudo está salvo correto.
            JOptionPane.showMessageDialog(null, 
              "Dados Salvo com sucesso!!!", "Salvo", 1,new ImageIcon(getClass().getResource("/Icones/ok.png")));//mensagem de erro
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, 
              "Erro ao Inserir no Banco de Dados", "Erro", 0,new ImageIcon(getClass().getResource("/Icones/ico_sair.png")));//mensagem de erro
        }
                
    }
}
