package Controller;

import Beans.ClienteBeans;
import DAO.ClienteDAO;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * Controller  controlar as acoes vinda da view
 * @author welingtonmarquezini
 */
public class ClienteController {//controla as acoes do do sistema
    
    ClienteDAO clienteDAO;

    public ClienteController() {
        clienteDAO = new ClienteDAO();
    }
    
    public boolean verificarDados(ClienteBeans cliente){
        if(cliente.getNome().equals("")) {
            JOptionPane.showMessageDialog(null, 
              "Preencha o campo Nome", "Erro", 0,
                new ImageIcon("imagens/ico_sair.png"));//mensagem de erro
            return false;
        }else if(cliente.getBairro().equals("")) {
            JOptionPane.showMessageDialog(null, 
              "Preencha o campo Bairro", "Erro", 0,
                new ImageIcon("imagens/ico_sair.png"));//mensagem de erro
            return false;
        }else if(cliente.getRua().equals("")) {
            JOptionPane.showMessageDialog(null, 
              "Preencha o campo Rua", "Erro", 0,
                new ImageIcon("imagens/ico_sair.png"));//mensagem de erro
            return false;
        }else if(cliente.getTelefone().equals("(  )      -    ")) {
            JOptionPane.showMessageDialog(null, 
              "Preencha o campo Telefone", "Erro", 0,
                new ImageIcon("imagens/ico_sair.png"));//mensagem de erro
            return false;
        }else {//caso estiver tudo preenchido
            clienteDAO.cadastroCliente(cliente);
            return true;
        }
    }
    public String controleDeCódigo () {
        return clienteDAO.proximoCliente();
    }
    
    public void controlePesquisa(String pesquisa, DefaultTableModel modeloTabela){
        clienteDAO.buscaCliente(pesquisa, modeloTabela);
    }
    //sobrecarga
    public void controlePesquisa(String pesquisa, List<String> lista){
        clienteDAO.buscaCliente(pesquisa, lista);
    }
    
    public ClienteBeans controlePreencherCampos(int codigo){
        return clienteDAO.preencherCampos(codigo);
    }
    
    public boolean verificarDadosEditar(ClienteBeans cliente){
        if(cliente.getNome().equals("")) {
            JOptionPane.showMessageDialog(null, 
              "Preencha o campo Nome", "Erro", 0,
                new ImageIcon("imagens/ico_sair.png"));//mensagem de erro
            return false;
        }else if(cliente.getBairro().equals("")) {
            JOptionPane.showMessageDialog(null, 
              "Preencha o campo Bairro", "Erro", 0,
                new ImageIcon("imagens/ico_sair.png"));//mensagem de erro
            return false;
        }else if(cliente.getRua().equals("")) {
            JOptionPane.showMessageDialog(null, 
              "Preencha o campo Rua", "Erro", 0,
                new ImageIcon("imagens/ico_sair.png"));//mensagem de erro
            return false;
        }else if(cliente.getTelefone().equals("(  )      -    ")) {
            JOptionPane.showMessageDialog(null, 
              "Preencha o campo Telefone", "Erro", 0,
                new ImageIcon("imagens/ico_sair.png"));//mensagem de erro
            return false;
        }else {//caso estiver tudo preenchido
            clienteDAO.editarCliente(cliente);
            return true;
        }
    }
}
