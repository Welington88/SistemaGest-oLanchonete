package Utilitarios;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author welingtonmarquezini
 */
public class Licenca {

    public Licenca() {
    }
    
    public boolean licencaProduto(){
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        
        try {
            boolean status = true;
            Date hoje = new Date();
            String dataFinal = "30/11/2020";
            Date dataFinalDate = formato.parse(dataFinal);
            if (dataFinalDate.before(hoje)) {//before = antes de 
               status = true;
            }else if (dataFinalDate.after(hoje)) {//after depois de 
               status = false;
            } 
            return status;
        } catch (ParseException e) {
            return false;
        } 
    }
    
}
