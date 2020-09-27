package Controller;

import Beans.ClienteBeans;
import DAO.ClienteDAO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author welingtonmarquezini
 */
public class ClienteController {
    
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
        }else {
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
}
