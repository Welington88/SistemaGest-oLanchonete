package GUI;//GUI refere-se a denominação "Graphical User Interface"

import Utilitarios.Conexao;
import Utilitarios.FundoTela;
import java.awt.GridLayout;
import java.io.InputStream;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 * View tela de visualicao do usuario
 * @author welingtonmarquezini
 */
public class Index extends javax.swing.JFrame {
    /**
     * Creates new form Index
     */
    FundoTela tela;
    ClienteForm clienteForm;
    FuncionarioForm funcionarioForm;
    CardapioForm cardapioForm;
    EntregadorForm entregadorForm;
    PedidosForm pedidosForm;
    TelaPedidos telaPedidos;
    EntradaForm entradaForm;
    Connection conexao = null;
    
    public Index() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);//entrar com tela cheia
        setLayout(new GridLayout());//para setar tela no inicio
        tela =  new FundoTela("/Icones/fundo_tela.jpg");
        getContentPane().add(tela);//adcionar fundo a tela
        menuCliente.setIcon(new ImageIcon(getClass().getResource("/Icones/ico_clientes.png")));
        menuFuncionario.setIcon(new ImageIcon(getClass().getResource("/Icones/ico_func.png")));
        menuCardapio.setIcon(new ImageIcon(getClass().getResource("/Icones/ico_cardapio.png")));
        menuEntregador.setIcon(new ImageIcon(getClass().getResource("/Icones/ico_boy.png")));
        
        menuCadastro.setIcon(new ImageIcon(getClass().getResource("/Icones/inserir-32.png")));
        menuCaixa.setIcon(new ImageIcon(getClass().getResource("/Icones/ico_caixa.png")));
        menuRelatorios.setIcon(new ImageIcon(getClass().getResource("/Icones/ico_rel.png")));
        menuSair.setIcon(new ImageIcon(getClass().getResource("/Icones/ico_sair.png")));
        menuSairFilho.setIcon(new ImageIcon(getClass().getResource("/Icones/ico_sair.png")));
        menuPedidos.setIcon(new ImageIcon(getClass().getResource("/Icones/ico_pedidos.png")));
        menuRelClientes.setIcon(new ImageIcon(getClass().getResource("/Icones/ico_clientes.png")));
        menuRelEstoque.setIcon(new ImageIcon(getClass().getResource("/Icones/ico_func.png")));
        menuTelaPedidosTela.setIcon(new ImageIcon(getClass().getResource("/Icones/ico_tela.png")));
        menuEntradaEstoque.setIcon(new ImageIcon(getClass().getResource("/Icones/inserir-32.png")));
        telaPedido.setIcon(new ImageIcon(getClass().getResource("/Icones/ico_tela.png")));
        
        //imagem do topo
        ImageIcon icone = new ImageIcon(getClass().getResource("/Icones/ico_cardapio.png"));
        setIconImage(icone.getImage());
        
        conexao = Conexao.getConnection();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        menuCadastro = new javax.swing.JMenu();
        menuCliente = new javax.swing.JMenuItem();
        menuFuncionario = new javax.swing.JMenuItem();
        menuCardapio = new javax.swing.JMenuItem();
        menuEntregador = new javax.swing.JMenuItem();
        menuCaixa = new javax.swing.JMenu();
        menuPedidos = new javax.swing.JMenuItem();
        menuEntradaEstoque = new javax.swing.JMenuItem();
        menuRelatorios = new javax.swing.JMenu();
        menuRelClientes = new javax.swing.JMenuItem();
        menuRelEstoque = new javax.swing.JMenuItem();
        menuTelaPedidosTela = new javax.swing.JMenu();
        telaPedido = new javax.swing.JMenuItem();
        menuSair = new javax.swing.JMenu();
        menuSairFilho = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sacras Leopoldina");

        menuCadastro.setText("Cadastro");
        menuCadastro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        menuCliente.setText("Clientes");
        menuCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuClienteActionPerformed(evt);
            }
        });
        menuCadastro.add(menuCliente);

        menuFuncionario.setText("Funcionários");
        menuFuncionario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuFuncionarioActionPerformed(evt);
            }
        });
        menuCadastro.add(menuFuncionario);

        menuCardapio.setText("Cardápio");
        menuCardapio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuCardapio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCardapioActionPerformed(evt);
            }
        });
        menuCadastro.add(menuCardapio);

        menuEntregador.setText("Entregador");
        menuEntregador.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuEntregador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuEntregadorActionPerformed(evt);
            }
        });
        menuCadastro.add(menuEntregador);

        jMenuBar1.add(menuCadastro);

        menuCaixa.setText("Caixa");
        menuCaixa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        menuPedidos.setText("Pedidos");
        menuPedidos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuPedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuPedidosActionPerformed(evt);
            }
        });
        menuCaixa.add(menuPedidos);

        menuEntradaEstoque.setText("Entrada Estoque");
        menuEntradaEstoque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuEntradaEstoqueActionPerformed(evt);
            }
        });
        menuCaixa.add(menuEntradaEstoque);

        jMenuBar1.add(menuCaixa);

        menuRelatorios.setText("Relatórios");
        menuRelatorios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        menuRelClientes.setText("Clientes");
        menuRelClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuRelClientesActionPerformed(evt);
            }
        });
        menuRelatorios.add(menuRelClientes);

        menuRelEstoque.setText("Estoque");
        menuRelatorios.add(menuRelEstoque);

        jMenuBar1.add(menuRelatorios);

        menuTelaPedidosTela.setText("Tela Pedidos");

        telaPedido.setText("Tela");
        telaPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                telaPedidoActionPerformed(evt);
            }
        });
        menuTelaPedidosTela.add(telaPedido);

        jMenuBar1.add(menuTelaPedidosTela);

        menuSair.setText("Sair");
        menuSair.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        menuSairFilho.setText("Sair");
        menuSairFilho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSairFilhoActionPerformed(evt);
            }
        });
        menuSair.add(menuSairFilho);

        jMenuBar1.add(menuSair);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 279, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuClienteActionPerformed
        // TODO add your handling code here:
        clienteForm = new ClienteForm();//chamar o form
        tela.add(clienteForm);
        clienteForm.setVisible(true);
    }//GEN-LAST:event_menuClienteActionPerformed

    private void menuFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuFuncionarioActionPerformed
        // TODO add your handling code here:
        funcionarioForm = new FuncionarioForm();//chamar o form
        tela.add(funcionarioForm);
        funcionarioForm.setVisible(true);
    }//GEN-LAST:event_menuFuncionarioActionPerformed

    private void menuPedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuPedidosActionPerformed
        // TODO add your handling code here:
        pedidosForm = new PedidosForm();
        tela.add(pedidosForm);
        pedidosForm.setVisible(true);
    }//GEN-LAST:event_menuPedidosActionPerformed

    private void menuEntregadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEntregadorActionPerformed
        // TODO add your handling code here:
        entregadorForm = new EntregadorForm();//chamar o form
        tela.add(entregadorForm);
        entregadorForm.setVisible(true);
    }//GEN-LAST:event_menuEntregadorActionPerformed

    private void menuCardapioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCardapioActionPerformed
        // TODO add your handling code here:
        cardapioForm = new CardapioForm();//chamar o form
        tela.add(cardapioForm);
        cardapioForm.setVisible(true);
    }//GEN-LAST:event_menuCardapioActionPerformed

    private void menuRelClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuRelClientesActionPerformed
        try {
            // TODO add your handling code here:
            
            InputStream caminho = 
                    getClass().getResourceAsStream("/Rel/rel_clientes.jasper");
            JasperPrint print = JasperFillManager.fillReport(caminho, null, conexao);//relatorio
            JasperViewer.viewReport(print,false);
            /*JasperViewer jasperViewer = new JasperViewer(print,false);
            jasperViewer.setVisible(true);*/
            
        } catch (JRException ex) {
            Logger.getLogger(Index.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_menuRelClientesActionPerformed

    private void telaPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_telaPedidoActionPerformed
        // TODO add your handling code here:
        telaPedidos = new TelaPedidos();
        
        telaPedidos.setVisible(true);
    }//GEN-LAST:event_telaPedidoActionPerformed

    private void menuSairFilhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSairFilhoActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_menuSairFilhoActionPerformed

    private void menuEntradaEstoqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEntradaEstoqueActionPerformed
        // TODO add your handling code here:
        entradaForm = new EntradaForm();//chamar o form
        tela.add(entradaForm);
        entradaForm.setVisible(true);
    }//GEN-LAST:event_menuEntradaEstoqueActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Index().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu menuCadastro;
    private javax.swing.JMenu menuCaixa;
    private javax.swing.JMenuItem menuCardapio;
    private javax.swing.JMenuItem menuCliente;
    private javax.swing.JMenuItem menuEntradaEstoque;
    private javax.swing.JMenuItem menuEntregador;
    private javax.swing.JMenuItem menuFuncionario;
    private javax.swing.JMenuItem menuPedidos;
    private javax.swing.JMenuItem menuRelClientes;
    private javax.swing.JMenuItem menuRelEstoque;
    private javax.swing.JMenu menuRelatorios;
    private javax.swing.JMenu menuSair;
    private javax.swing.JMenuItem menuSairFilho;
    private javax.swing.JMenu menuTelaPedidosTela;
    private javax.swing.JMenuItem telaPedido;
    // End of variables declaration//GEN-END:variables
}
