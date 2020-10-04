package Utilitarios;

import java.sql.Connection;
import com.mysql.jdbc.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author welingtonmarquezini
 */
public class Conexao {
    //local host
    private final String URL = "jdbc:mysql://localhost:3306/lanchonete";
    private final String Driver = "com.mysql.jdbc.Driver";
    private final String Usuario = "root";
    private final String Senha = "";
    private static Connection Con;
    
    //hospedado
    /*private final String URL = "jdbc:mysql://sql185.main-hosting.eu:3306/u980658351_damata";
    private final String Driver = "com.mysql.jdbc.Driver";
    private final String Usuario = "u980658351_root";
    private final String Senha = "@wel1988";
    private static Connection Con;*/
    
    public Conexao() {
        try {
            Con = DriverManager.getConnection(URL, Usuario, Senha);
            Con.setAutoCommit(false);
            JOptionPane.showMessageDialog(null,  "Conectado com Sucesso....", "Banco", 1);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, 
                    "Erro ao Conectar no Banco de Dados " + e, "Erro", 0);//mensagem de erro
        }
    }
    
    public static Connection getConnection(){
        if(Con == null){
            new Conexao();
        }
        return Con;
    }
    
    public static void fecharConexao(){
        try {
            if (!Con.isClosed()) {// sempre digite o isclosed
                Con.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String args[]) {
        Conexao.getConnection();
    }
}
