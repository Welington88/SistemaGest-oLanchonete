package Controller;

import DAO.PedidoDAO;
import GUI.PedidosForm;
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
    //----------------------------------------------------------------------
    public boolean verificarItens(String valor, String quant, String codigo, String item){
        
        try {
            int n = Integer.parseInt(quant);
            if(n==0){
                JOptionPane.showMessageDialog(null, 
                "Preencha um Número maior que zero em quantidade", "Erro", 0,  
                new ImageIcon("imagens/ico_sair.png"));//mensagem de erro
                PedidosForm.txt_quant.setText("1");
                PedidosForm.txt_quant.grabFocus();
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, 
              "Preencha um Número inteiro", "Erro", 0,
                new ImageIcon("imagens/ico_sair.png"));//mensagem de erro
                PedidosForm.txt_quant.setText("1");
                PedidosForm.txt_quant.grabFocus();
        }
        //----------------------------------------------------------------------
        if(item.equals("")) {
            JOptionPane.showMessageDialog(null, 
              "Preencha o campo Item", "Erro", 0,
                new ImageIcon("imagens/ico_sair.png"));//mensagem de erro
            return false;
        }else if(codigo.equals("")) {
            JOptionPane.showMessageDialog(null, 
              "Preencha o campo código", "Erro", 0,
                new ImageIcon("imagens/ico_sair.png"));//mensagem de erro
            return false;
        }else if(valor.equals("")) {
            JOptionPane.showMessageDialog(null, 
              "Preencha o campo Valor", "Erro", 0,
                new ImageIcon("imagens/ico_sair.png"));//mensagem de erro
            return false;
        } else if(quant.equals("")) {//quando quant for null retorno false
            return false;
        }else {//caso estiver tudo preenchido
            return true;
        }
         
    }
    //----------------------------------------------------------------------
    public void controleDePedido(String CodigoCliente, 
                                String CodigoFuncionario,
                                String Total){
        pedidoDAO.CadastrarPedido(CodigoCliente, CodigoFuncionario, Total);
    }
}
