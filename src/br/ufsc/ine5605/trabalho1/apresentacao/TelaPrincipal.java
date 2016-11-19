package br.ufsc.ine5605.trabalho1.apresentacao;

import br.ufsc.ine5605.trabalho1.controle.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class TelaPrincipal extends JFrame {

    private final ControladorPrincipal controladorPrincipal;

    public TelaPrincipal(ControladorPrincipal controladorPrincipal) {
        this.controladorPrincipal = controladorPrincipal;
        initComponents();
        setLocationRelativeTo(null);
    }

    public void unlockTelaPrincipal() {
        setEnabled(true);
    }

    public void unlockBotaoResultado() {
        btn_TelaResultados.setEnabled(true);
    }

    public void mostraTelaCandidatos() {
        setEnabled(false);
        ControladorCandidato.getInstance().exibeTela();
    }

    public void mostraTelaEleitor() {
        setEnabled(false);
        ControladorEleitor.getInstance().exibeTela();
    }

    public void mostraTelaCidade() {
        setEnabled(false);
        ControladorCidade.getInstance().exibeTela();
    }

    public void mostraTelaUrna() {
        setEnabled(false);
        ControladorUrna.getInstance().exibeTela();
    }

    public void mostraTelaPartido() {
        setEnabled(false);
        ControladorPartido.getInstance().exibeTela();
    }

    private void iniciaEleicoes() {
        if (ControladorUrna.getInstance().getLista().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Não há como iniciar as eleições, não há urnas cadastradas", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        btn_TelaCandidato.setEnabled(false);
        btn_TelaEleitor.setEnabled(false);
        btn_TelaCidade.setEnabled(false);
        btn_TelaPartido.setEnabled(false);
        btn_TelaUrna.setEnabled(false);
        btn_IniciarEleicoes.setEnabled(false);

        setEnabled(false);

        ControladorUrna.getInstance().iniciaEleicoes();
    }

    private void mostraTelaResultados() {
        ControladorUrna.getInstance().exibeTelaResultado();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_TelaCandidato = new javax.swing.JButton();
        btn_TelaCidade = new javax.swing.JButton();
        btn_TelaEleitor = new javax.swing.JButton();
        btn_TelaPartido = new javax.swing.JButton();
        btn_TelaUrna = new javax.swing.JButton();
        btn_IniciarEleicoes = new javax.swing.JButton();
        btn_TelaResultados = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Eleições");
        setResizable(false);

        btn_TelaCandidato.setText("Tela Candidato");
        btn_TelaCandidato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_TelaCandidatoActionPerformed(evt);
            }
        });

        btn_TelaCidade.setText("Tela Cidade");
        btn_TelaCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_TelaCidadeActionPerformed(evt);
            }
        });

        btn_TelaEleitor.setText("Tela Eleitor");
        btn_TelaEleitor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_TelaEleitorActionPerformed(evt);
            }
        });

        btn_TelaPartido.setText("Tela Partido");
        btn_TelaPartido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_TelaPartidoActionPerformed(evt);
            }
        });

        btn_TelaUrna.setText("Tela Urna");
        btn_TelaUrna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_TelaUrnaActionPerformed(evt);
            }
        });

        btn_IniciarEleicoes.setText("Iniciar Eleições");
        btn_IniciarEleicoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_IniciarEleicoesActionPerformed(evt);
            }
        });

        btn_TelaResultados.setText("Resultados");
        btn_TelaResultados.setEnabled(false);
        btn_TelaResultados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_TelaResultadosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_TelaResultados, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                    .addComponent(btn_IniciarEleicoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_TelaCidade, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                    .addComponent(btn_TelaEleitor, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                    .addComponent(btn_TelaPartido, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                    .addComponent(btn_TelaUrna, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                    .addComponent(btn_TelaCandidato, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE))
                .addGap(150, 150, 150))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(btn_TelaCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btn_TelaEleitor, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btn_TelaPartido, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btn_TelaCandidato, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btn_TelaUrna, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btn_IniciarEleicoes, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btn_TelaResultados, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_TelaCandidatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_TelaCandidatoActionPerformed
        mostraTelaCandidatos();
    }//GEN-LAST:event_btn_TelaCandidatoActionPerformed

    private void btn_TelaCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_TelaCidadeActionPerformed
        mostraTelaCidade();
    }//GEN-LAST:event_btn_TelaCidadeActionPerformed

    private void btn_TelaEleitorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_TelaEleitorActionPerformed
        mostraTelaEleitor();
    }//GEN-LAST:event_btn_TelaEleitorActionPerformed

    private void btn_TelaPartidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_TelaPartidoActionPerformed
        mostraTelaPartido();
    }//GEN-LAST:event_btn_TelaPartidoActionPerformed

    private void btn_TelaUrnaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_TelaUrnaActionPerformed
        mostraTelaUrna();
    }//GEN-LAST:event_btn_TelaUrnaActionPerformed

    private void btn_IniciarEleicoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_IniciarEleicoesActionPerformed
        iniciaEleicoes();
    }//GEN-LAST:event_btn_IniciarEleicoesActionPerformed

    private void btn_TelaResultadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_TelaResultadosActionPerformed
        mostraTelaResultados();
    }//GEN-LAST:event_btn_TelaResultadosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_IniciarEleicoes;
    private javax.swing.JButton btn_TelaCandidato;
    private javax.swing.JButton btn_TelaCidade;
    private javax.swing.JButton btn_TelaEleitor;
    private javax.swing.JButton btn_TelaPartido;
    private javax.swing.JButton btn_TelaResultados;
    private javax.swing.JButton btn_TelaUrna;
    // End of variables declaration//GEN-END:variables

}
