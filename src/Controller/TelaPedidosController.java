/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.TelaPedidoDAO;
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
}
