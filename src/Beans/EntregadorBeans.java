package Beans;

/**
 * Beans Modelo = Model
 * @author welingtonmarquezini
 */
public class EntregadorBeans {
    private int Codigo;
    private String Nome;
    private String Status;
    private String DataCad;
    //contructor
    public EntregadorBeans() {
        
    }
    
    public EntregadorBeans(int Codigo, String Nome, String Status, String DataCad) {
        this.Codigo = Codigo;
        this.Nome = Nome;
        this.Status = Status;
        this.DataCad = DataCad;
    }
    //gets and sets
    public int getCodigo() {
        return Codigo;
    }

    public void setCodigo(int Codigo) {
        this.Codigo = Codigo;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public String getDataCad() {
        return DataCad;
    }

    public void setDataCad(String DataCad) {
        this.DataCad = DataCad;
    }   
}