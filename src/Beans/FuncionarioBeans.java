package Beans;
/**
 *
 * @author welingtonmarquezini
 */
public class FuncionarioBeans {
    private int Codigo;
    private String Nome;
    private String Cargo;
    private String Permissao;
    private String DataCad;
    //construtor
    public FuncionarioBeans() {
    }
    
    public FuncionarioBeans(int Codigo, String Nome, String Cargo, String Permissao, String DataCad) {
        this.Codigo = Codigo;
        this.Nome = Nome;
        this.Cargo = Cargo;
        this.Permissao = Permissao;
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

    public String getCargo() {
        return Cargo;
    }

    public void setCargo(String Cargo) {
        this.Cargo = Cargo;
    }

    public String getPermissao() {
        return Permissao;
    }

    public void setPermissao(String Permissao) {
        this.Permissao = Permissao;
    }

    public String getDataCad() {
        return DataCad;
    }

    public void setDataCad(String DataCad) {
        this.DataCad = DataCad;
    }
}