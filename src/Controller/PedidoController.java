package Controller;

import DAO.PedidoDAO;
import java.util.List;

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
    
    public double controleDeCodigo(String pesquisa){
        return pedidoDAO.valorDoCodigo(pesquisa);
    }
}
