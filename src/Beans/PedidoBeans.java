package Beans;

import java.util.ArrayList;
import java.util.List;

/**
 *Beans Modelo = Model
 * @author welingtonmarquezini
 */
public class PedidoBeans {
    private int CodigoPedido;
    private int CodigoCliente;
    private int CodigoFuncionario;
    private int CodigoEntregador;
    private String Data;
    private String Hora;
    private String Status;
    private Double Valor;
    private List<Integer>CodCadapio;
    private List<Integer>Quantidade;

    //contrutor
    public PedidoBeans() {
        CodCadapio = new ArrayList<>();
        Quantidade = new ArrayList<>();
    }
    //get and set

    public int getCodigoPedido() {
        return CodigoPedido;
    }

    public void setCodigoPedido(int CodigoPedido) {
        this.CodigoPedido = CodigoPedido;
    }

    public int getCodigoCliente() {
        return CodigoCliente;
    }

    public void setCodigoCliente(int CodigoCliente) {
        this.CodigoCliente = CodigoCliente;
    }

    public int getCodigoFuncionario() {
        return CodigoFuncionario;
    }

    public void setCodigoFuncionario(int CodigoFuncionario) {
        this.CodigoFuncionario = CodigoFuncionario;
    }

    public int getCodigoEntregador() {
        return CodigoEntregador;
    }

    public void setCodigoEntregador(int CodigoEntregador) {
        this.CodigoEntregador = CodigoEntregador;
    }

    public String getData() {
        return Data;
    }

    public void setData(String Data) {
        this.Data = Data;
    }

    public String getHora() {
        return Hora;
    }

    public void setHora(String Hora) {
        this.Hora = Hora;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public Double getValor() {
        return Valor;
    }

    public void setValor(Double Valor) {
        this.Valor = Valor;
    }

    public Integer getCodCadapio(int posicao) {
        return CodCadapio.get(posicao);
    }

    public void setCodCadapio(int CodCardapio) {
        this.CodCadapio.add(CodCardapio);
    }

    public Integer getQuantidade(int posicao) {
        return Quantidade.get(posicao);
    }

    public void setQuantidade(int Quantidade) {
        this.Quantidade.add(Quantidade);
    }
    
    
}
