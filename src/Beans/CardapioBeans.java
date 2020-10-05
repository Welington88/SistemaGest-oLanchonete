package Beans;

/**
 *Beans Modelo = Model
 * @author welingtonmarquezini
 */
public class CardapioBeans {
    private int Codigo;
    private String descricao;
    private String tipo;
    private Double valor;

    //contrutor
    public CardapioBeans() {
    }

    public CardapioBeans(int Codigo, String descricao, String tipo, Double valor) {
        this.Codigo = Codigo;
        this.descricao = descricao;
        this.tipo = tipo;
        this.valor = valor;
    }
    //get and set

    public int getCodigo() {
        return Codigo;
    }

    public void setCodigo(int Codigo) {
        this.Codigo = Codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}
