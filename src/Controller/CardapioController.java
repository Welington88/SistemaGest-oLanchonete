package Controller;

import Beans.CardapioBeans;
import DAO.CardapioDAO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * Controller  controlar as acoes vinda da view
 * @author welingtonmarquezini
 */
public class CardapioController {//controla as acoes do do sistema
    
    CardapioDAO cardapioDAO;

    public CardapioController() {
        cardapioDAO = new CardapioDAO();
    }
    
    public boolean verificarDados(CardapioBeans obj){
        if(obj.getDescricao().equals("")) {
            JOptionPane.showMessageDialog(null, 
              "Preencha o campo Descrição", "Erro", 0,
                new ImageIcon("imagens/ico_sair.png"));//mensagem de erro
            return false;
        }else if(obj.getTipo().equals("Selecione um Item")) {
            JOptionPane.showMessageDialog(null, 
              "Selecione o um tipo no campo Tipo", "Erro", 0,
                new ImageIcon("imagens/ico_sair.png"));//mensagem de erro
            return false;
        }else if(obj.getValor() <= 0 || obj.getValor() == null) {
            JOptionPane.showMessageDialog(null, 
              "Preencha o campo Valor com valor acima de 0", "Erro", 0,
                new ImageIcon("imagens/ico_sair.png"));//mensagem de erro
            return false;
        }else {//caso estiver tudo preenchido
            cardapioDAO.inserir(obj);
            return true;
        }
    }
    public String controleDeCódigo () {
        return CardapioDAO.proximoNumero();
    }
    
    public void controlePesquisa(String pesquisa, DefaultTableModel modeloTabela){
        cardapioDAO.buscar(pesquisa, modeloTabela);
    }
    public CardapioBeans controlePreencherCampos(int codigo){
        return cardapioDAO.preencherCampos(codigo);
    }
    
    public boolean verificarDadosEditar(CardapioBeans obj){
        if(obj.getDescricao().equals("")) {
            JOptionPane.showMessageDialog(null, 
              "Preencha o campo Descrição", "Erro", 0,
                new ImageIcon("imagens/ico_sair.png"));//mensagem de erro
            return false;
        }else if(obj.getTipo().equals("Selecione um Item")) {
            JOptionPane.showMessageDialog(null, 
              "Selecione o uma Cargo no campo Tipo", "Erro", 0,
                new ImageIcon("imagens/ico_sair.png"));//mensagem de erro
            return false;
        }else if(obj.getValor() <= 0 || obj.getValor() == null) {
            JOptionPane.showMessageDialog(null, 
              "Selecione o uma Cargo no campo Valor", "Erro", 0,
                new ImageIcon("imagens/ico_sair.png"));//mensagem de erro
            return false;
        }else {//caso estiver tudo preenchido
            cardapioDAO.inserir(obj);
            return true;
        }
    }
}
