package Controller;

import Beans.EntregadorBeans;
import DAO.EntregadorDAO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * Controller  controlar as acoes vinda da view
 * @author welingtonmarquezini
 */
public class EntregadorController {//controla as acoes do do sistema
    
    EntregadorDAO entregadorDAO;

    public EntregadorController() {
        entregadorDAO = new EntregadorDAO();
    }
    
    public boolean verificarDados(EntregadorBeans ent){
        if(ent.getNome().equals("")) {
            JOptionPane.showMessageDialog(null, 
              "Preencha o campo Nome Entregador", "Erro", 0,
                new ImageIcon("imagens/ico_sair.png"));//mensagem de erro
            return false;
        }else if(ent.getStatus().equals("")) {
            JOptionPane.showMessageDialog(null, 
              "Preencha o campo Status", "Erro", 0,
                new ImageIcon("imagens/ico_sair.png"));//mensagem de erro
            return false;
        }else {//caso estiver tudo preenchido
            entregadorDAO.cadastroEntregador(ent);
            return true;
        }
    }
    public String controleDeCódigo () {
        return EntregadorDAO.proximoEntregador();
    }
    
    public void controlePesquisa(String pesquisa, DefaultTableModel modeloTabela){
        entregadorDAO.buscaEntregador(pesquisa, modeloTabela);
    }
    public EntregadorBeans controlePreencherCampos(int codigo){
        return entregadorDAO.preencherCampos(codigo);
    }
    
    public boolean verificarDadosEditar(EntregadorBeans ent){
        if(ent.getNome().equals("")) {
            JOptionPane.showMessageDialog(null, 
              "Preencha o campo Nome Funcionario", "Erro", 0,
                new ImageIcon("imagens/ico_sair.png"));//mensagem de erro
            return false;
        }else if(ent.getStatus().equals("")) {
            JOptionPane.showMessageDialog(null, 
              "Preencha o campo Status", "Erro", 0,
                new ImageIcon("imagens/ico_sair.png"));//mensagem de erro
            return false;
        }else {//caso estiver tudo preenchido
            entregadorDAO.editarEntregador(ent);
            return true;
        }
    }
}