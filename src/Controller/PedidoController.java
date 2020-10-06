package Controller;

import DAO.PedidoDAO;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author welingtonmarquezini
 */
public class PedidoController {
    PedidoDAO pedidoDAO;

    public PedidoController() {
        pedidoDAO = new PedidoDAO();
    }
    
    public void controleItens(String pesquisa,List<String> listaItens){
        pedidoDAO.pesquisaItens(pesquisa, listaItens);
    }
    
    public double controleDeValor(String pesquisa){
        return pedidoDAO.valorDoItem(pesquisa);
    }
    
    public int controleDeCodigo(String pesquisa){
        return pedidoDAO.valorDoCodigo(pesquisa);
    }
    
    public boolean verificarItens(String valor, int Quant, String codigo, String item){
        
        if(valor.equals("")) {
            JOptionPane.showMessageDialog(null, 
              "Preencha o campo Valor", "Erro", 0,
                new ImageIcon("imagens/ico_sair.png"));//mensagem de erro
            return false;
        }else if(codigo.equals("")) {
            JOptionPane.showMessageDialog(null, 
              "Preencha o campo código", "Erro", 0,
                new ImageIcon("imagens/ico_sair.png"));//mensagem de erro
            return false;
        }else if(item.equals("")) {
            JOptionPane.showMessageDialog(null, 
              "Preencha o campo Item", "Erro", 0,
                new ImageIcon("imagens/ico_sair.png"));//mensagem de erro
            return false;
        }else {//caso estiver tudo preenchido
            
            return true;
        }
    }
}
