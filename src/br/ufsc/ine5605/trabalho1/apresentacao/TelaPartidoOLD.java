package br.ufsc.ine5605.trabalho1.apresentacao;

import br.ufsc.ine5605.trabalho1.controle.ControladorPartido;
import br.ufsc.ine5605.trabalho1.controle.ControladorPrincipal;
import br.ufsc.ine5605.trabalho1.entidade.Partido;
import br.ufsc.ine5605.trabalho1.exception.NomeVazio;
import br.ufsc.ine5605.trabalho1.exception.PartidoDuplicado;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class TelaPartidoOLD extends Tela<Partido> {

    private final ControladorPartido controladorPartido;
    private Partido partidoModificado;

    public TelaPartidoOLD(ControladorPartido controladorPartido) {
        this.controladorPartido = controladorPartido;
        initComponents();
        setLocationRelativeTo(null);
    }

    private void cadastraPartido() {
        try {
            Partido partido = new Partido(verificaNome(txt_Nome.getText()), verificaNome(txt_Sigla.getText()));
            if (controladorPartido.cadastra(partido)) {
                JOptionPane.showMessageDialog(null, "Partido cadastrado com sucesso!", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Partido com o mesmo nome ou sigla ja cadastrado.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (NomeVazio ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar, nome em branco.", "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (PartidoDuplicado ex) {
            Logger.getLogger(TelaPartidoOLD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void listaPartidos() {
        addRows(controladorPartido.getLista(), jTable1);
    }

    private void removePartido() {
        int x = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja remover o partido?", "Aviso", JOptionPane.YES_NO_OPTION);
        if (x == JOptionPane.YES_OPTION) {
            if (controladorPartido.remove(partidoModificado)) {
                btn_Modificar.setEnabled(false);
                btn_Remove.setEnabled(false);
            }
        }
    }

    private void modificaPartido() {
        int x = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja modificar o partido?", "Aviso", JOptionPane.YES_NO_OPTION);
        if (x == JOptionPane.YES_OPTION) {
            try {
                controladorPartido.modifica(partidoModificado, new Partido(
                        verificaNome(txt_ModificaNome.getText()),
                        verificaNome(txt_ModificaSigla.getText())));
            } catch (NomeVazio ex) {
                JOptionPane.showMessageDialog(null, "Erro ao modificar, nome em branco.", "Erro", JOptionPane.ERROR_MESSAGE);
            } catch (PartidoDuplicado ex) {
                Logger.getLogger(TelaPartidoOLD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void procuraPartidoPorSigla() {
        partidoModificado = controladorPartido.getPartidoPorSigla(txt_ModificaSigla.getText());
        setPartidoModificado(partidoModificado);
    }

    private void procuraPartidoPorNome() {
        partidoModificado = controladorPartido.getPartidoPorNome(txt_ModificaNome.getText());
        setPartidoModificado(partidoModificado);
    }

    private void setPartidoModificado(Partido partidoModificado) {
        if (partidoModificado != null) {
            txt_ModificaNome.setText(partidoModificado.getNome());
            txt_ModificaSigla.setText(partidoModificado.getSigla());

            btn_Modificar.setEnabled(true);
            btn_Remove.setEnabled(true);
        } else {
            JOptionPane.showMessageDialog(null, "Eleitor não encontrado", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            btn_Modificar.setEnabled(false);
            btn_Remove.setEnabled(false);
        }
    }

    @Override
    Object[] atributosParaArray(Partido partido) {
        return new Object[]{partido.getNome(), partido.getSigla()};
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
        jLabel2 = new javax.swing.JLabel();
        txt_Sigla = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btn_Cadastro = new javax.swing.JButton();
        txt_Nome = new javax.swing.JTextField();
        panel_Modifica = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txt_ModificaSigla = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btn_Modificar = new javax.swing.JButton();
        txt_ModificaNome = new javax.swing.JTextField();
        btn_ProcuraPorNome = new javax.swing.JButton();
        btn_ProcuraPorSigla = new javax.swing.JButton();
        btn_Remove = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
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
                "Nome", "Sigla"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
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

        jLabel2.setText("Sigla");

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
            .addGroup(panel_CadastroLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(panel_CadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
                .addGroup(panel_CadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_Nome, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_Sigla, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel_CadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_Sigla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(194, Short.MAX_VALUE))
            .addGroup(panel_CadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panel_CadastroLayout.createSequentialGroup()
                    .addContainerGap(219, Short.MAX_VALUE)
                    .addComponent(btn_Cadastro)
                    .addGap(30, 30, 30)))
        );

        jTabbedPane2.addTab("Cadastro", panel_Cadastro);

        jLabel3.setText("Sigla");

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

        btn_ProcuraPorSigla.setText("Procurar");
        btn_ProcuraPorSigla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ProcuraPorSiglaActionPerformed(evt);
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
                .addGap(12, 12, 12)
                .addGroup(panel_ModificaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_ModificaLayout.createSequentialGroup()
                        .addGap(198, 198, 198)
                        .addComponent(btn_Remove)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_Modificar)
                        .addGap(25, 25, 25))
                    .addGroup(panel_ModificaLayout.createSequentialGroup()
                        .addGroup(panel_ModificaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
                        .addGroup(panel_ModificaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_ModificaSigla, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_ModificaNome, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel_ModificaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_ProcuraPorSigla)
                            .addComponent(btn_ProcuraPorNome))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel_ModificaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_ModificaSigla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(btn_ProcuraPorSigla))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 134, Short.MAX_VALUE)
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

    private void btn_Cadastro_CadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Cadastro_CadastroActionPerformed
        cadastraPartido();
    }//GEN-LAST:event_btn_Cadastro_CadastroActionPerformed

    private void jTabbedPane2StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jTabbedPane2StateChanged
        if (jTabbedPane2.getSelectedIndex() == 0) {
            listaPartidos();
        }
    }//GEN-LAST:event_jTabbedPane2StateChanged

    private void btn_RemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_RemoveActionPerformed
        removePartido();
    }//GEN-LAST:event_btn_RemoveActionPerformed

    private void btn_ProcuraPorSiglaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ProcuraPorSiglaActionPerformed
        procuraPartidoPorSigla();
    }//GEN-LAST:event_btn_ProcuraPorSiglaActionPerformed

    private void btn_ProcuraPorNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ProcuraPorNomeActionPerformed
        procuraPartidoPorNome();
    }//GEN-LAST:event_btn_ProcuraPorNomeActionPerformed

    private void btn_Modificar_CadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Modificar_CadastroActionPerformed
        modificaPartido();
    }//GEN-LAST:event_btn_Modificar_CadastroActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        ControladorPrincipal.getInstance().liberaTelaPrincipal();
    }//GEN-LAST:event_formWindowClosing

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Cadastro;
    private javax.swing.JButton btn_Modificar;
    private javax.swing.JButton btn_ProcuraPorNome;
    private javax.swing.JButton btn_ProcuraPorSigla;
    private javax.swing.JButton btn_Remove;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JPanel panel_Cadastro;
    private javax.swing.JPanel panel_Lista;
    private javax.swing.JPanel panel_Modifica;
    private javax.swing.JTextField txt_ModificaNome;
    private javax.swing.JTextField txt_ModificaSigla;
    private javax.swing.JTextField txt_Nome;
    private javax.swing.JTextField txt_Sigla;
    // End of variables declaration//GEN-END:variables

}
