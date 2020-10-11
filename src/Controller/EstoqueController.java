package Controller;

import Beans.EstoqueBeans;
import DAO.EstoqueDAO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 * Controller  controlar as acoes vinda da view
 * @author welingtonmarquezini
 */
public class EstoqueController {//controla as acoes do do sistema
    
    EstoqueDAO estoqueDAO;
    

    public EstoqueController() {
        estoqueDAO = new EstoqueDAO();
    }
    //------------------------------------------------------------------------
    public boolean verificarDados(EstoqueBeans obj){
        if(obj.getNfe().equals("")) {
            JOptionPane.showMessageDialog(null, 
              "Preencha o campo NFE", "Erro", 0,
                new ImageIcon("imagens/ico_sair.png"));//mensagem de erro
            return false;
        }else if(obj.getQuantidade() <= 0 ) {
            JOptionPane.showMessageDialog(null, 
              "Campo Quantidade tem ser maior que Zero", "Erro", 0,
                new ImageIcon("imagens/ico_sair.png"));//mensagem de erro
            return false;
        }else if(obj.getValor() <= 0) {
            JOptionPane.showMessageDialog(null, 
              "Preencha o campo Valor com valor acima de 0", "Erro", 0,
                new ImageIcon("imagens/ico_sair.png"));//mensagem de erro
            return false;
        }else {//caso estiver tudo preenchido
            estoqueDAO.inserir(obj);
            return true;
        }
    }
}
