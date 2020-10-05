package Controller;

import Beans.FuncionarioBeans;
import DAO.FuncionarioDAO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * Controller  controlar as acoes vinda da view
 * @author welingtonmarquezini
 */
public class FuncionarioController {//controla as acoes do do sistema
    
    FuncionarioDAO funcionarioDAO;

    public FuncionarioController() {
        funcionarioDAO = new FuncionarioDAO();
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
            funcionarioDAO.cadastroFuncionario(func);
            return true;
        }
    }
    public String controleDeCódigo () {
        return FuncionarioDAO.proximoFuncionario();
    }
    
    public void controlePesquisa(String pesquisa, DefaultTableModel modeloTabela){
        funcionarioDAO.buscaFuncionario(pesquisa, modeloTabela);
    }
    public FuncionarioBeans controlePreencherCampos(int codigo){
        return funcionarioDAO.preencherCampos(codigo);
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
            funcionarioDAO.editarFuncionario(func);
            return true;
        }
    }
}
