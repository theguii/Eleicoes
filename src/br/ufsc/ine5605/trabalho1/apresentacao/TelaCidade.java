package br.ufsc.ine5605.trabalho1.apresentacao;

import br.ufsc.ine5605.trabalho1.controle.ControladorCidade;
import br.ufsc.ine5605.trabalho1.controle.ControladorPrincipal;
import br.ufsc.ine5605.trabalho1.entidade.Cidade;
import br.ufsc.ine5605.trabalho1.exception.NomeVazio;
import javax.swing.JOptionPane;

public class TelaCidade extends Tela<Cidade> {

    private final ControladorCidade controladorCidade;
    private Cidade cidadeModificada;

    public TelaCidade(ControladorCidade controladorCidade) {
        this.controladorCidade = controladorCidade;
        initComponents();
        setLocationRelativeTo(null);
    }

    private void cadastraCidade() {
        try {
            Cidade cidade = new Cidade(verificaNome(txt_Nome.getText()));
            if (controladorCidade.cadastra(cidade)) {
                JOptionPane.showMessageDialog(null, "Cidade cadastrada com sucesso!", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Não foi possivel cadastrar a cidade", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (NomeVazio ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar, nome em branco.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void listaCidades() {
        addRows(controladorCidade.getLista(), jTable1);
    }

    private void removeCidade() {
        int x = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja remover a cidade?", "Aviso", JOptionPane.YES_NO_OPTION);
        if (x == JOptionPane.YES_OPTION) {
            if (controladorCidade.remove(cidadeModificada)) {
                btn_Modificar.setEnabled(false);
                btn_Remove.setEnabled(false);
            }
        }
    }

    private void modificaCidade() {
        int x = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja modificar a cidade?", "Aviso", JOptionPane.YES_NO_OPTION);
        if (x == JOptionPane.YES_OPTION) {
            try {
                controladorCidade.modifica(cidadeModificada, new Cidade(verificaNome(txt_ModificaNome.getText())));
            } catch (NomeVazio ex) {
                JOptionPane.showMessageDialog(null, "Erro ao modificar, nome em branco.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void procuraCidade() {
        cidadeModificada = controladorCidade.getCidade(txt_ModificaNome.getText());
        if (cidadeModificada != null) {
            txt_ModificaNome.setText(cidadeModificada.getNome());

            btn_Modificar.setEnabled(true);
            btn_Remove.setEnabled(true);
        } else {
            JOptionPane.showMessageDialog(null, "Cidade não encontrada", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            btn_Modificar.setEnabled(false);
            btn_Remove.setEnabled(false);
        }
    }

    @Override
    Object[] atributosParaArray(Cidade cidade) {
        return new Object[]{cidade.getNome()};
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane2 = new javax.swing.JTabbedPane();
        panel_Lista = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        panel_Cadastro = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btn_Cadastro = new javax.swing.JButton();
        txt_Nome = new javax.swing.JTextField();
        panel_Modifica = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        btn_Modificar = new javax.swing.JButton();
        txt_ModificaNome = new javax.swing.JTextField();
        btn_ProcuraPorNome = new javax.swing.JButton();
        btn_Remove = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cidades");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jTabbedPane2.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jTabbedPane2StateChanged(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cidade"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout panel_ListaLayout = new javax.swing.GroupLayout(panel_Lista);
        panel_Lista.setLayout(panel_ListaLayout);
        panel_ListaLayout.setHorizontalGroup(
            panel_ListaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_ListaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE)
                .addContainerGap())
        );
        panel_ListaLayout.setVerticalGroup(
            panel_ListaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_ListaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(75, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Lista", panel_Lista);

        jLabel1.setText("Nome");

        btn_Cadastro.setText("Cadastrar");
        btn_Cadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Cadastro_CadastroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_CadastroLayout = new javax.swing.GroupLayout(panel_Cadastro);
        panel_Cadastro.setLayout(panel_CadastroLayout);
        panel_CadastroLayout.setHorizontalGroup(
            panel_CadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_CadastroLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
                .addComponent(txt_Nome, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74))
            .addGroup(panel_CadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_CadastroLayout.createSequentialGroup()
                    .addContainerGap(289, Short.MAX_VALUE)
                    .addComponent(btn_Cadastro)
                    .addGap(25, 25, 25)))
        );
        panel_CadastroLayout.setVerticalGroup(
            panel_CadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_CadastroLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(panel_CadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_Nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(225, Short.MAX_VALUE))
            .addGroup(panel_CadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panel_CadastroLayout.createSequentialGroup()
                    .addContainerGap(219, Short.MAX_VALUE)
                    .addComponent(btn_Cadastro)
                    .addGap(30, 30, 30)))
        );

        jTabbedPane2.addTab("Cadastro", panel_Cadastro);

        jLabel4.setText("Nome");

        btn_Modificar.setText("Modificar");
        btn_Modificar.setEnabled(false);
        btn_Modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Modificar_CadastroActionPerformed(evt);
            }
        });

        btn_ProcuraPorNome.setText("Procurar");
        btn_ProcuraPorNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ProcuraPorNomeActionPerformed(evt);
            }
        });

        btn_Remove.setText("Remover");
        btn_Remove.setEnabled(false);
        btn_Remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_RemoveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_ModificaLayout = new javax.swing.GroupLayout(panel_Modifica);
        panel_Modifica.setLayout(panel_ModificaLayout);
        panel_ModificaLayout.setHorizontalGroup(
            panel_ModificaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_ModificaLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(panel_ModificaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_ModificaLayout.createSequentialGroup()
                        .addGap(185, 185, 185)
                        .addComponent(btn_Remove)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_Modificar)
                        .addGap(25, 25, 25))
                    .addGroup(panel_ModificaLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                        .addComponent(txt_ModificaNome, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_ProcuraPorNome)
                        .addContainerGap())))
        );
        panel_ModificaLayout.setVerticalGroup(
            panel_ModificaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_ModificaLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(panel_ModificaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_ModificaNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(btn_ProcuraPorNome))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 168, Short.MAX_VALUE)
                .addGroup(panel_ModificaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Modificar)
                    .addComponent(btn_Remove))
                .addGap(30, 30, 30))
        );

        jTabbedPane2.addTab("Modifica", panel_Modifica);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        ControladorPrincipal.getInstance().telaPrincipal.setEnabled(true);
    }//GEN-LAST:event_formWindowClosing

    private void btn_Cadastro_CadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Cadastro_CadastroActionPerformed
        cadastraCidade();
    }//GEN-LAST:event_btn_Cadastro_CadastroActionPerformed

    private void btn_Modificar_CadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Modificar_CadastroActionPerformed
        modificaCidade();
    }//GEN-LAST:event_btn_Modificar_CadastroActionPerformed

    private void btn_ProcuraPorNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ProcuraPorNomeActionPerformed
        procuraCidade();
    }//GEN-LAST:event_btn_ProcuraPorNomeActionPerformed

    private void btn_RemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_RemoveActionPerformed
        removeCidade();
    }//GEN-LAST:event_btn_RemoveActionPerformed

    private void jTabbedPane2StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jTabbedPane2StateChanged
        if (jTabbedPane2.getSelectedIndex() == 0) {
            listaCidades();
        }
    }//GEN-LAST:event_jTabbedPane2StateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Cadastro;
    private javax.swing.JButton btn_Modificar;
    private javax.swing.JButton btn_ProcuraPorNome;
    private javax.swing.JButton btn_Remove;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JPanel panel_Cadastro;
    private javax.swing.JPanel panel_Lista;
    private javax.swing.JPanel panel_Modifica;
    private javax.swing.JTextField txt_ModificaNome;
    private javax.swing.JTextField txt_Nome;
    // End of variables declaration//GEN-END:variables

}
