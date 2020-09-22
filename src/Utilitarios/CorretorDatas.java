/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilitarios;

/**
 *
 * @author welingtonmarquezini
 */
public class CorretorDatas {
    public String ConverterParaSQL(String Data){
        //dd-mm-aaa
        return Data.substring(6,10) + "-" + Data.substring(3,5) + 
                "-" + Data.substring(0,2) ;
    }
    
    public String ConverterParaJava(String Data){
        //dd-mm-aaa
        return Data.substring(8,10) + "-" + Data.substring(6,7) + 
                "-" + Data.substring(0,4) ;
    } 
}
