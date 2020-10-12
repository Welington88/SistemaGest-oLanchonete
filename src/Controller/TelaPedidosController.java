/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.TelaPedidoDAO;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author welingtonmarquezini
 */
public class TelaPedidosController {
    
    TelaPedidoDAO telaPedidoDAO;
    public TelaPedidosController() {
        telaPedidoDAO = new TelaPedidoDAO();
    }
    
    public void controlePesquisa(DefaultTableModel modelo) {
        telaPedidoDAO.MostrarPedidos(modelo);
    }
    
    public void alterarPedido(String statusPedidos, int codigoCliente){
        if (codigoCliente <= 0) {
            JOptionPane.showMessageDialog(null, 
              "Preencha o campo Nº pedido selecione um pedido", "Erro", 0,
                new ImageIcon("imagens/ico_sair.png"));//mensagem de erro
        } else {
            telaPedidoDAO.alterarPedido(statusPedidos,codigoCliente);
        }
    }
    public List<String> consultarPedido(int codigoPedido){
        if (codigoPedido > 0) {
            return telaPedidoDAO.consultarPedido(codigoPedido);
        } else{
            return null;
        }
    }
    
    public double consultarPedidoValor(int codigoPedido){
        if (codigoPedido > 0) {
            return telaPedidoDAO.consultarPedidoValor(codigoPedido);
        } else{
            return 0;
        }
    }
}
