/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilitarios;

import GUI.Index;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;

/**
 *
 * @author welingtonmarquezini
 */ 
public class FundoTela extends JDesktopPane {
    private Image imagem;
    
    public FundoTela(String imagem){
        this.imagem = new ImageIcon(Index.class.getResource(imagem)).getImage(); //pegar a url da imagem
        
    }
    
    @Override
    public void paintComponent(Graphics g){
        g.drawImage(imagem, 0, 0, getWidth(), getHeight(), this);// obj pos x e y largura e altura
    }
}
