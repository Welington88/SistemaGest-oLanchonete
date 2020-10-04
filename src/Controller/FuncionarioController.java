package Controller;

import Beans.ClienteBeans;
import Beans.FuncionarioBeans;
import DAO.ClienteDAO;
import DAO.FuncionarioDAO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * Controller  controlar as acoes vinda da view
 * @author welingtonmarquezini
 */
public class FuncionarioController {//controla as acoes do do sistema
    
    FuncionarioDAO funcioarioDAO;

    public FuncionarioController() {
        funcioarioDAO = new FuncionarioDAO();
    }
    
    public boolean verificarDados(FuncionarioBeans func){
        if(func.getNome().equals("")) {
            JOptionPane.showMessageDialog(null, 
              "Preencha o campo Nome Funcionario", "Erro", 0,
                new ImageIcon("imagens/ico_sair.png"));//mensagem de erro
            return false;
        }else if(func.getCargo().equals("") || func.getCargo().equals("Selecione um Cargo")) {
            JOptionPane.showMessageDialog(null, 
              "Selecione o uma Cargo no campo Cargo", "Erro", 0,
                new ImageIcon("imagens/ico_sair.png"));//mensagem de erro
            return false;
        }else {//caso estiver tudo preenchido
            funcioarioDAO.cadastroFuncionario(func);
            return true;
        }
    }
    public String controleDeCódigo () {
        return ClienteDAO.proximoCliente();
    }
    
    public void controlePesquisa(String pesquisa, DefaultTableModel modeloTabela){
        funcioarioDAO.buscaFuncionario(pesquisa, modeloTabela);
    }
    public FuncionarioBeans controlePreencherCampos(int codigo){
        return funcioarioDAO.preencherCampos(codigo);
    }
    
    public boolean verificarDadosEditar(FuncionarioBeans func){
        if(func.getNome().equals("")) {
            JOptionPane.showMessageDialog(null, 
              "Preencha o campo Nome Funcionario", "Erro", 0,
                new ImageIcon("imagens/ico_sair.png"));//mensagem de erro
            return false;
        }else if(func.getCargo().equals("") || func.getCargo().equals("Selecione um Cargo")) {
            JOptionPane.showMessageDialog(null, 
              "Selecione o uma Cargo no campo Cargo", "Erro", 0,
                new ImageIcon("imagens/ico_sair.png"));//mensagem de erro
            return false;
        }else {//caso estiver tudo preenchido
            funcioarioDAO.editarFuncionario(func);
            return true;
        }
    }
}