package Beans;
/**
 *
 * @author welingtonmarquezini
 */
public class ClienteBeans {//classe model
    private int Codigo;
    private String Nome;
    private String Rua;
    private String Bairro;
    private String Telefone;
    private String DataCad;

    //construtor
    public ClienteBeans() {
        
    }

    public ClienteBeans(int Codigo, String Nome, String Rua, String Bairro, 
            String Telefone, String DataCad) {
        this.Codigo = Codigo;
        this.Nome = Nome;
        this.Rua = Rua;
        this.Bairro = Bairro;
        this.Telefone = Telefone;
        this.DataCad = DataCad;
    }

    //get and set
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

    public String getRua() {
        return Rua;
    }

    public void setRua(String Rua) {
        this.Rua = Rua;
    }

    public String getBairro() {
        return Bairro;
    }

    public void setBairro(String Bairro) {
        this.Bairro = Bairro;
    }

    public String getTelefone() {
        return Telefone;
    }

    public void setTelefone(String Telefone) {
        this.Telefone = Telefone;
    }

    public String getDataCad() {
        return DataCad;
    }

    public void setDataCad(String DataCad) {
        this.DataCad = DataCad;
    }
}
