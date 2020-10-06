/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Beans.ClienteBeans;
import Beans.PedidoBeans;
import Controller.ClienteController;
import Controller.PedidoController;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author welingtonmarquezini
 */
public class PedidosForm extends javax.swing.JInternalFrame {
    /**
     * Creates new form PedidosForm
     */
    
    ClienteBeans clienteBeans;
    ClienteController clienteController;
    PedidoBeans pedidoBeans;
    PedidoController pedidoController;
    List<String> lista;
    List<String> listaDeItens;
    
    MaskFormatter formatoTel;
    public PedidosForm() {
        initComponents();
        habilitarCampos(false);
        
        clienteBeans =  new ClienteBeans();
        clienteController = new ClienteController();
        pedidoBeans = new PedidoBeans();
        pedidoController = new PedidoController();
        
        lista = new ArrayList<>();
        listaDeItens = new ArrayList<>();
        
        painelPai.setEnabledAt(1, false);//segunda tela inativa
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelPai = new javax.swing.JTabbedPane();
        painelClientes = new javax.swing.JPanel();
        btn_pesquisar = new javax.swing.JButton();
        cb_Clientes = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        txt_codigo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txt_nome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_rua = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_bairro = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        try {
            formatoTel = new MaskFormatter("(##) #####-####");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                "Erro inserir Telefone", "Erro", 0);//mensagem de erro
        }
        txt_telefone = new JFormattedTextField(formatoTel);
        jLabel6 = new javax.swing.JLabel();
        txt_data = new javax.swing.JTextField();
        btn_pedido = new javax.swing.JButton();
        btn_fechar = new javax.swing.JButton();
        painelPedidos = new javax.swing.JPanel();
        txt_nome_cliente = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txt_item = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        cb_itens = new javax.swing.JComboBox<>();
        btn_valor = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txt_Valor = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txt_quant = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txt_cod_ped = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        btn_adicionar = new javax.swing.JButton();
        btn_retirar = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        txt_total = new javax.swing.JTextField();
        btn_calcular = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        btn_finalizar = new javax.swing.JButton();
        btn_fechar_two = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);

        painelPai.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btn_pesquisar.setText("Pesquisar");
        btn_pesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pesquisarActionPerformed(evt);
            }
        });

        cb_Clientes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<-- Pesquise um Clinte ao Lado -->" }));
        cb_Clientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_ClientesActionPerformed(evt);
            }
        });

        jLabel1.setText("Código:");

        txt_codigo.setEditable(false);

        jLabel2.setText("Nome:");

        jLabel3.setText("Rua:");

        jLabel4.setText("Bairro:");

        txt_bairro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_bairroActionPerformed(evt);
            }
        });

        jLabel5.setText("Telefone:");

        jLabel6.setText("Data:");

        txt_data.setEditable(false);

        btn_pedido.setText("Pedido");
        btn_pedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pedidoActionPerformed(evt);
            }
        });

        btn_fechar.setText("Fechar");

        javax.swing.GroupLayout painelClientesLayout = new javax.swing.GroupLayout(painelClientes);
        painelClientes.setLayout(painelClientesLayout);
        painelClientesLayout.setHorizontalGroup(
            painelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelClientesLayout.createSequentialGroup()
                .addGroup(painelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelClientesLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(btn_pesquisar))
                    .addGroup(painelClientesLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(painelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, painelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, painelClientesLayout.createSequentialGroup()
                        .addGroup(painelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txt_codigo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_rua, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_nome, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_bairro, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(10, Short.MAX_VALUE))
                    .addGroup(painelClientesLayout.createSequentialGroup()
                        .addGroup(painelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(painelClientesLayout.createSequentialGroup()
                                .addComponent(txt_telefone, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_data, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(painelClientesLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btn_pedido)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn_fechar)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(painelClientesLayout.createSequentialGroup()
                        .addComponent(cb_Clientes, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        painelClientesLayout.setVerticalGroup(
            painelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelClientesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_pesquisar)
                    .addGroup(painelClientesLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(cb_Clientes, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(txt_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_rua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGroup(painelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelClientesLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel4))
                    .addGroup(painelClientesLayout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(txt_bairro, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_telefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(painelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_data, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)
                        .addComponent(jLabel6)))
                .addGap(32, 32, 32)
                .addGroup(painelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_fechar)
                    .addComponent(btn_pedido))
                .addContainerGap(115, Short.MAX_VALUE))
        );

        painelPai.addTab("Cliente", painelClientes);

        txt_nome_cliente.setEditable(false);
        txt_nome_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nome_clienteActionPerformed(evt);
            }
        });

        jLabel7.setText("Item:");

        txt_item.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_itemActionPerformed(evt);
            }
        });
        txt_item.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_itemKeyReleased(evt);
            }
        });

        jLabel8.setText("Selecionar:");

        cb_itens.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Buscar item ao lado" }));
        cb_itens.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_itensActionPerformed(evt);
            }
        });

        btn_valor.setText("Valor");
        btn_valor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_valorActionPerformed(evt);
            }
        });

        jLabel9.setText("Valor:");

        txt_Valor.setEditable(false);

        jLabel10.setText("Quant.:");

        jLabel11.setText("Código.:");

        txt_cod_ped.setEditable(false);

        jLabel12.setText("Cliente:");

        btn_adicionar.setText("+");

        btn_retirar.setText("-");
        btn_retirar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_retirarActionPerformed(evt);
            }
        });

        jLabel13.setText("Valor Total:");

        btn_calcular.setText("Calcular");

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código Item", "Descrição", "Valor Unitário", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabela);

        btn_finalizar.setText("Finalizar");

        btn_fechar_two.setText("Fechar");

        javax.swing.GroupLayout painelPedidosLayout = new javax.swing.GroupLayout(painelPedidos);
        painelPedidos.setLayout(painelPedidosLayout);
        painelPedidosLayout.setHorizontalGroup(
            painelPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelPedidosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(painelPedidosLayout.createSequentialGroup()
                        .addComponent(btn_valor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_calcular)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_total, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, painelPedidosLayout.createSequentialGroup()
                        .addGroup(painelPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painelPedidosLayout.createSequentialGroup()
                                .addComponent(btn_adicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_retirar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(painelPedidosLayout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(18, 18, 18)
                                .addComponent(txt_Valor, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(12, 12, 12)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_quant, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_cod_ped, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, painelPedidosLayout.createSequentialGroup()
                        .addGroup(painelPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(painelPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painelPedidosLayout.createSequentialGroup()
                                .addComponent(txt_item, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cb_itens, 0, 1, Short.MAX_VALUE))
                            .addComponent(txt_nome_cliente))))
                .addGap(288, 288, 288))
            .addGroup(painelPedidosLayout.createSequentialGroup()
                .addGap(235, 235, 235)
                .addComponent(btn_finalizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_fechar_two)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        painelPedidosLayout.setVerticalGroup(
            painelPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelPedidosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_nome_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txt_item, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(cb_itens, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(painelPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txt_Valor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(txt_quant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(txt_cod_ped, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelPedidosLayout.createSequentialGroup()
                        .addComponent(btn_valor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(painelPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_adicionar)
                            .addComponent(btn_retirar)))
                    .addGroup(painelPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel13)
                        .addComponent(btn_calcular)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_fechar_two)
                    .addComponent(btn_finalizar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        painelPai.addTab("Pedidos", painelPedidos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(painelPai, javax.swing.GroupLayout.PREFERRED_SIZE, 469, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(painelPai, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        setBounds(200, 50, 505, 492);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_bairroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_bairroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_bairroActionPerformed

    private void txt_nome_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nome_clienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nome_clienteActionPerformed

    private void btn_retirarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_retirarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_retirarActionPerformed

    private void btn_pesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pesquisarActionPerformed
        // TODO add your handling code here:
        cb_Clientes.removeAllItems();//remove todos os itens
        lista.clear();//limpar a lista
        String pesquisa = JOptionPane.showInputDialog(null, "Digite o Nome do Cliente", "Pedidos", 3);//input dos dados 
        clienteController.controlePesquisa(pesquisa, lista);//fazer pesquisa
        for(String i: lista){//ir ate o final da lista
            cb_Clientes.addItem(i);//preencher lista item a item
        }
    }//GEN-LAST:event_btn_pesquisarActionPerformed

    private void cb_ClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_ClientesActionPerformed
        // TODO add your handling code here:
        if (!(cb_Clientes.getSelectedItem() == null)) {//caso não for nulo
            String cod = cb_Clientes.getSelectedItem().toString();//codigo do cliente selecionado
            cod = cod.substring(0, cod.indexOf(" "));
            clienteBeans = clienteController.controlePreencherCampos(Integer.parseInt(cod));
            txt_codigo.setText(clienteBeans.getCodigo() + "");
            txt_nome.setText(clienteBeans.getNome());
            txt_rua.setText(clienteBeans.getRua());
            txt_bairro.setText(clienteBeans.getBairro());
            txt_telefone.setText(clienteBeans.getTelefone());
            txt_data.setText(clienteBeans.getDataCad());
        }
    }//GEN-LAST:event_cb_ClientesActionPerformed

    private void btn_pedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pedidoActionPerformed
        // TODO add your handling code here:
        painelPai.setEnabledAt(0, false);//segunda tela inativa
        painelPai.setEnabledAt(1, true);//segunda tela ativa
        painelPai.setSelectedIndex(1);//ir para a 2 tela
    }//GEN-LAST:event_btn_pedidoActionPerformed

    private void txt_itemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_itemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_itemActionPerformed

    private void btn_valorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_valorActionPerformed
        // TODO add your handling code here:
        txt_Valor.setText(pedidoController.controleDeValor(cb_itens.getSelectedItem().toString()) + "");
        txt_cod_ped.setText(pedidoController.controleDeCodigo(cb_itens.getSelectedItem().toString()) + "");
        
    }//GEN-LAST:event_btn_valorActionPerformed

    private void txt_itemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_itemKeyReleased
        // TODO add your handling code here:
        txt_Valor.setText("");//limpar o campo
        cb_itens.removeAllItems();//remover todos os itens
        listaDeItens.clear();
        pedidoController.controleItens(txt_item.getText(), listaDeItens);
        listaDeItens.forEach((i) -> { //for each
            cb_itens.addItem(i);
        });
    }//GEN-LAST:event_txt_itemKeyReleased

    private void cb_itensActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_itensActionPerformed
        // TODO add your handling code here:
        txt_Valor.setText("");
        txt_quant.setText("");
    }//GEN-LAST:event_cb_itensActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_adicionar;
    private javax.swing.JButton btn_calcular;
    private javax.swing.JButton btn_fechar;
    private javax.swing.JButton btn_fechar_two;
    private javax.swing.JButton btn_finalizar;
    private javax.swing.JButton btn_pedido;
    private javax.swing.JButton btn_pesquisar;
    private javax.swing.JButton btn_retirar;
    private javax.swing.JButton btn_valor;
    private javax.swing.JComboBox<String> cb_Clientes;
    private javax.swing.JComboBox<String> cb_itens;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel painelClientes;
    private javax.swing.JTabbedPane painelPai;
    private javax.swing.JPanel painelPedidos;
    private javax.swing.JTable tabela;
    private javax.swing.JTextField txt_Valor;
    private javax.swing.JTextField txt_bairro;
    private javax.swing.JTextField txt_cod_ped;
    private javax.swing.JTextField txt_codigo;
    private javax.swing.JTextField txt_data;
    private javax.swing.JTextField txt_item;
    private javax.swing.JTextField txt_nome;
    private javax.swing.JTextField txt_nome_cliente;
    private javax.swing.JTextField txt_quant;
    private javax.swing.JTextField txt_rua;
    private javax.swing.JTextField txt_telefone;
    private javax.swing.JTextField txt_total;
    // End of variables declaration//GEN-END:variables
    
    final void habilitarCampos(boolean valor){
        txt_bairro.setEnabled(valor);
        txt_rua.setEnabled(valor);
        txt_nome.setEnabled(valor);
        txt_telefone.setEnabled(valor);
        txt_data.setEnabled(valor);
    }
}