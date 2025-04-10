package gui;

import dao.ProdutoDAO;
import dao.PromocaoDAO;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import persistencia.Produto;
import persistencia.Promocao;

/**
 *
 * @author Matheus Prestjord
 */
public class TelaPromocoes extends javax.swing.JFrame {
    // Método para carregar todos os produtos no combo box
    private void carregarProdutosNoComboBox() {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        List<Produto> produtos = produtoDAO.listarTodos();

        // Limpa o comboBox antes de adicionar novos itens
        cmbBoxProduto.removeAllItems();

        // Adiciona um item padrão/vazio (opcional)
        cmbBoxProduto.addItem("Selecione um produto...");

        if (produtos != null) {
            for (Produto produto : produtos) {
                // Adiciona cada produto ao ComboBox
                cmbBoxProduto.addItem(produto.getNome());

                // Ou, se quiser mostrar apenas o nome:
                // cmbProdutos.addItem(produto.getNome());
            }
        }
    }
    
    // Método para preencher a jTable
     public void preencherTabela() {
        PromocaoDAO promocaoDAO = new PromocaoDAO();

        List<Promocao> promocoes = promocaoDAO.listarTodos();

        DefaultTableModel tabelaPromocoes = (DefaultTableModel) tblPromocoes.getModel();

        tabelaPromocoes.setNumRows(0); // Limpa a tabela antes de adicionar novos dados
        
        LocalDate hoje = LocalDate.now();

        tblPromocoes.setRowSorter(new TableRowSorter(tabelaPromocoes));
        
        for (Promocao p : promocoes) {
            // Verifica se a data fim já passou
            if (p.getDataFim().isBefore(hoje)) {
                // Remove a promoção expirada do banco de dados
                promocaoDAO.remover(p.getId());
                continue; // Pula para a próxima promoção sem adicionar à tabela
            }
        }

        for (Promocao p : promocoes) {
            Object[] obj = new Object[]{
                p.getId(),
                p.getProdutoRelacionado().getNome(),
                p.getDataInicio(),
                p.getDataFim(),
                p.getDescricao()
            };
            tabelaPromocoes.addRow(obj);
        }
    }

    /**
     * Creates new form TelaRelatorio
     */
    public TelaPromocoes() {
        initComponents();
        setLocationRelativeTo(null);
        carregarProdutosNoComboBox();
        preencherTabela();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblPromocoes = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lblProduto = new javax.swing.JLabel();
        cmbBoxProduto = new javax.swing.JComboBox<>();
        lblDataInicio = new javax.swing.JLabel();
        lblDescricao = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtADescricao = new javax.swing.JTextArea();
        btnEnviar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblPromocoes = new javax.swing.JTable();
        fmtTxtDataInicio = new javax.swing.JFormattedTextField();
        lblDataFim = new javax.swing.JLabel();
        fmtTxtDataFim = new javax.swing.JFormattedTextField();
        lblRemoverPromocao = new javax.swing.JLabel();
        txtRemover = new javax.swing.JFormattedTextField();
        btnRemover = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblPromocoes.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblPromocoes.setText("PROMOÇÕES");

        lblProduto.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblProduto.setText("Produto:");

        cmbBoxProduto.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cmbBoxProduto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Produto exemplo", "Produto exemplo 2", "Produto exemplo 3", "Produto exemplo 4" }));

        lblDataInicio.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblDataInicio.setText("Data início:");

        lblDescricao.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblDescricao.setText("Descrição:");

        txtADescricao.setColumns(20);
        txtADescricao.setRows(5);
        jScrollPane1.setViewportView(txtADescricao);

        btnEnviar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnEnviar.setText("Enviar");
        btnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarActionPerformed(evt);
            }
        });

        tblPromocoes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Produto", "Data início", "Data fim", "Descrição"
            }
        ));
        jScrollPane2.setViewportView(tblPromocoes);

        fmtTxtDataInicio.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.SHORT))));
        fmtTxtDataInicio.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        lblDataFim.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblDataFim.setText("Data fim:");

        fmtTxtDataFim.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.SHORT))));
        fmtTxtDataFim.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        lblRemoverPromocao.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblRemoverPromocao.setText("Remover promoção (ID): ");

        txtRemover.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getIntegerInstance())));
        txtRemover.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        btnRemover.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnRemover.setText("Remover");
        btnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lblPromocoes)
                        .addComponent(lblDescricao)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblDataInicio)
                                .addComponent(lblProduto)
                                .addComponent(lblDataFim))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(fmtTxtDataFim)
                                .addComponent(cmbBoxProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(fmtTxtDataInicio)))
                        .addComponent(jScrollPane1))
                    .addComponent(btnEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblRemoverPromocao)
                        .addGap(18, 18, 18)
                        .addComponent(txtRemover, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRemover)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblPromocoes)
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblProduto)
                            .addComponent(cmbBoxProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblDataInicio)
                            .addComponent(fmtTxtDataInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblDataFim)
                            .addComponent(fmtTxtDataFim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(lblDescricao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblRemoverPromocao)
                        .addComponent(txtRemover, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnRemover))
                    .addComponent(btnEnviar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarActionPerformed
        // Verificar se os campos estão vazios
        if (!String.valueOf(cmbBoxProduto.getSelectedItem()).equals("Selecione um produto...") && 
                !fmtTxtDataInicio.getText().trim().isEmpty() && 
                !fmtTxtDataFim.getText().trim().isEmpty() && 
                !txtADescricao.getText().trim().isEmpty()) {

            // Criar o objeto promoção
            Promocao promocao = new Promocao();

            // Atribuir os valores dos campos à variáveis
            String produtoRelacionado = String.valueOf(cmbBoxProduto.getSelectedItem());
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate dataInicio = LocalDate.parse(fmtTxtDataInicio.getText(), formato);
            LocalDate dataFim = LocalDate.parse(fmtTxtDataFim.getText(), formato);
            String descricao = txtADescricao.getText();

            // Atribuir os valores ao objeto
            ProdutoDAO produtoDAO = new ProdutoDAO();
            promocao.setProdutoRelacionado(produtoDAO.buscarPorNome(produtoRelacionado));
            promocao.setDataInicio(dataInicio);
            promocao.setDataFim(dataFim);
            promocao.setDescricao(descricao);

            PromocaoDAO promocaoDAO = new PromocaoDAO();
            promocaoDAO.cadastrarPromocao(promocao);

            // Limpar os campos
            cmbBoxProduto.setSelectedIndex(0);
            fmtTxtDataInicio.setText("");
            fmtTxtDataFim.setText("");
            txtADescricao.setText("");

            // Atualizar a tabela
            preencherTabela();

            // Exibir mensagem de êxito
            JOptionPane.showMessageDialog(this, "Produto cadastrado com sucesso!");
        } else {
            // Exibir mensagem de aviso
            JOptionPane.showMessageDialog(this, "Preencha todos os campos.", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnEnviarActionPerformed

    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed
        // Verificar se o campo está vazio
        if (!txtRemover.getText().trim().isEmpty()) {
            // Pegar o ID do campo
            int id = Integer.parseInt(txtRemover.getText());

            PromocaoDAO promocaoDAO = new PromocaoDAO();
            promocaoDAO.remover(id);

            // Limpar o campo
            txtRemover.setText("");

            // Atualizar a tabela
            preencherTabela();

            // Mostrar mensagem de êxito
            JOptionPane.showMessageDialog(this, "Promoção removida com sucesso!");
        } else {
            // Exibir mensagem de aviso
            JOptionPane.showMessageDialog(this, "Preencha todos os campos.", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnRemoverActionPerformed

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
            java.util.logging.Logger.getLogger(TelaPromocoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPromocoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPromocoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPromocoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPromocoes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEnviar;
    private javax.swing.JButton btnRemover;
    private javax.swing.JComboBox<String> cmbBoxProduto;
    private javax.swing.JFormattedTextField fmtTxtDataFim;
    private javax.swing.JFormattedTextField fmtTxtDataInicio;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblDataFim;
    private javax.swing.JLabel lblDataInicio;
    private javax.swing.JLabel lblDescricao;
    private javax.swing.JLabel lblProduto;
    private javax.swing.JLabel lblPromocoes;
    private javax.swing.JLabel lblRemoverPromocao;
    private javax.swing.JTable tblPromocoes;
    private javax.swing.JTextArea txtADescricao;
    private javax.swing.JFormattedTextField txtRemover;
    // End of variables declaration//GEN-END:variables
}
