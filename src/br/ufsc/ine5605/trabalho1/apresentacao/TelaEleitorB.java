/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.trabalho1.apresentacao;

import br.ufsc.ine5605.trabalho1.constantes.Actions;
import br.ufsc.ine5605.trabalho1.controle.ControladorCidade;
import br.ufsc.ine5605.trabalho1.controle.ControladorEleitor;
import br.ufsc.ine5605.trabalho1.entidade.Cidade;
import br.ufsc.ine5605.trabalho1.entidade.Eleitor;
import br.ufsc.ine5605.trabalho1.exception.NomeVazio;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author lucas
 */
public class TelaEleitorB extends Tela<Eleitor>{
    
    private JTabbedPane jTabbedPane;
    private ActionManager actionManager = new ActionManager();
    private Eleitor eleitorModificado;
    
    // Panel Lista
    private JPanel jpnLista;
    private JTable jTable;
    
    //Panel Cadastro
    private JPanel jpnCadastro;
    
    private JLabel jlbNome;
    private JLabel jlbTitulo;
    private JLabel jlbCidade;
    private JLabel jlbSecao;
    private JLabel jlbZona;
    
    private JButton jbtCadastro;
    
    private JTextField jtfNome;
    private JTextField jtfTitulo;
    private JTextField jtfSecao;
    private JTextField jtfZona;
    
    private JComboBox<Cidade> jcbCidade;
    
    //Panel Modifica
    private JPanel jpnModifica;
    
    private JButton jbtModificar;
    private JButton jbtProcuraPorTitulo;
    private JButton jbtProcuraPorNome;
    private JButton jbtRemove;
    
    private JLabel jlbNomeModifica;
    private JLabel jlbTituloModifica;
    private JLabel jlbCidadeModifica;
    private JLabel jlbSecaoModifica;
    private JLabel jlbZonaModifica;
    
    private JTextField jtfModificaNome;
    private JTextField jtfModificaTitulo;
    private JTextField jtfModificaSecao;
    private JTextField jtfModificaZona;
    
    private JComboBox<String> jcbModificaCidade;
    
    
    public TelaEleitorB(){
        setTitle("Eleitores");
        initComponents();
        setButtonActions();
        listaEleitores();
    }
    
    private void listaEleitores() {
        addRows(ControladorEleitor.getInstance().getLista(), jTable);
    }
    
    private void initComponents(){
        
        jTabbedPane = new JTabbedPane();
        jTabbedPane.addChangeListener((javax.swing.event.ChangeEvent evt) -> {
            if (jTabbedPane.getSelectedIndex() == 0) {
                listaEleitores();
            }
        });
        getContentPane().add(jTabbedPane);
        setSize(450, 350);

        //Lista
        jTable = new JTable();
        jpnLista = new JPanel();

        JScrollPane tableContainer = new JScrollPane(jTable);

        jTable.setModel(new javax.swing.table.DefaultTableModel(
                new String[][]{}, new String[]{
                    "Nome", "Título", "Cidade", "Zona", "Seção"
                }
        ) {

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        });
        
        jpnLista.add(tableContainer);
        jTabbedPane.add("Lista", jpnLista);
        
        //Cadastro
        jpnCadastro = new JPanel();
        jbtCadastro = new JButton("Cadastrar");

        jtfNome = new JTextField();
        jtfTitulo = new JTextField();
        jtfZona = new JTextField();
        jtfSecao = new JTextField();
        
        jlbNome = new JLabel("Nome");
        jlbTitulo = new JLabel("Título");
        jlbCidade = new JLabel("Cidade");
        jlbZona = new JLabel("Zona");
        jlbSecao = new JLabel("Seção");
        
        jcbCidade = new JComboBox<>();
        
        jpnCadastro.setLayout(new GridBagLayout());
        
        GridBagConstraints c1 = new GridBagConstraints();
        c1.fill = GridBagConstraints.HORIZONTAL;
        

        c1.insets = new Insets(40, 60, 0, 0);
        c1.gridx = 0;
        c1.gridy = 0;
        c1.weightx = 0;
        jpnCadastro.add(jlbNome, c1);

        c1.insets = new Insets(40, 40, 0, 0);
        c1.gridx = 1;
        c1.gridy = 0;
        c1.weightx = 1;
        jpnCadastro.add(jtfNome, c1);

        c1.insets = new Insets(15, 60, 0, 0);
        c1.gridx = 0;
        c1.gridy = 1;
        c1.weightx = 0;
        jpnCadastro.add(jlbTitulo, c1);

        c1.insets = new Insets(15, 40, 0, 0);
        c1.gridx = 1;
        c1.gridy = 1;
        c1.weightx = 1;
        jpnCadastro.add(jtfTitulo, c1);

        c1.insets = new Insets(15, 60, 0, 0);
        c1.gridx = 0;
        c1.gridy = 2;
        c1.weightx = 0;
        jpnCadastro.add(jlbCidade, c1);

        c1.insets = new Insets(15, 40, 0, 0);
        c1.gridx = 1;
        c1.gridy = 2;
        c1.weightx = 1;
        jpnCadastro.add(jcbCidade, c1);

        c1.insets = new Insets(15, 60, 0, 0);
        c1.gridx = 0;
        c1.gridy = 3;
        c1.weightx = 0;
        jpnCadastro.add(jlbSecao, c1);

        c1.insets = new Insets(15, 40, 0, 0);
        c1.gridx = 1;
        c1.gridy = 3;
        c1.weightx = 1;
        jpnCadastro.add(jtfSecao, c1);

        c1.insets = new Insets(15, 60, 0, 0);
        c1.gridx = 0;
        c1.gridy = 4;
        c1.weightx = 0;
        jpnCadastro.add(jlbZona, c1);

        c1.insets = new Insets(15, 40, 0, 0);
        c1.gridx = 1;
        c1.gridy = 4;
        c1.weightx = 1;
        jpnCadastro.add(jtfZona, c1);

        c1.insets = new Insets(27, 10, 20, 15);
        c1.gridx = 2;
        c1.gridy = 5;
        c1.weightx = .01;
        c1.weighty = 1;
        jpnCadastro.add(jbtCadastro, c1);

        jTabbedPane.add("Cadastro", jpnCadastro);
        
        //Modifica
        jpnModifica = new JPanel();

        jbtModificar = new JButton("Modificar");
        jbtProcuraPorTitulo = new JButton("Pesquisar");
        jbtProcuraPorNome = new JButton ("Pesquisar");
        jbtRemove = new JButton("Remover");

        jtfModificaNome = new JTextField();
        jtfModificaTitulo = new JTextField();
        jtfModificaZona = new JTextField();
        jtfModificaSecao = new JTextField();
        
        jlbNomeModifica = new JLabel("Nome");
        jlbTituloModifica = new JLabel("Título");
        jlbCidadeModifica = new JLabel("Cidade");
        jlbZonaModifica = new JLabel("Zona");
        jlbSecaoModifica = new JLabel("Seção");

        jcbModificaCidade = new JComboBox<>();
        

        jpnModifica.setLayout(new GridBagLayout());
        
        GridBagConstraints c2 = new GridBagConstraints();
        c2.fill = GridBagConstraints.HORIZONTAL;

        c2.insets = new Insets(40, 60, 0, 0);
        c2.gridx = 0;
        c2.gridy = 0;
        c2.weightx = 0;
        jpnModifica.add(jlbNomeModifica, c2);

        c2.insets = new Insets(40, 40, 0, 0);
        c2.gridx = 1;
        c2.gridy = 0;
        c2.weightx = 1;
        jpnModifica.add(jtfModificaNome, c2);
        
        c2.insets = new Insets(40, 20, 0, 20);
        c2.gridx = 2;
        c2.gridy = 0;
        c2.weightx = 0;
        jpnModifica.add(jbtProcuraPorNome, c2);

        c2.insets = new Insets(15, 60, 0, 0);
        c2.gridx = 0;
        c2.gridy = 1;
        c2.weightx = 0;
        jpnModifica.add(jlbTituloModifica, c2);

        c2.insets = new Insets(15, 40, 0, 0);
        c2.gridx = 1;
        c2.gridy = 1;
        c2.weightx = 1;
        jpnModifica.add(jtfModificaTitulo, c2);

        c2.insets = new Insets(15, 20, 0, 20);
        c2.gridx = 2;
        c2.gridy = 1;
        c2.weightx = 0;
        jpnModifica.add(jbtProcuraPorTitulo, c2);

        c2.insets = new Insets(15, 60, 0, 0);
        c2.gridx = 0;
        c2.gridy = 2;
        c2.weightx = 0;
        jpnModifica.add(jlbCidadeModifica, c2);

        c2.insets = new Insets(15, 40, 0, 0);
        c2.gridx = 1;
        c2.gridy = 2;
        c2.weightx = 1;
        jpnModifica.add(jcbModificaCidade, c2);

        c2.insets = new Insets(15, 60, 0, 0);
        c2.gridx = 0;
        c2.gridy = 3;
        c2.weightx = 0;
        jpnModifica.add(jlbSecaoModifica, c2);

        c2.insets = new Insets(15, 40, 0, 0);
        c2.gridx = 1;
        c2.gridy = 3;
        c2.weightx = 1;
        jpnModifica.add(jtfModificaSecao, c2);

        c2.insets = new Insets(15, 60, 0, 0);
        c2.gridx = 0;
        c2.gridy = 4;
        c2.weightx = 0;
        jpnModifica.add(jlbZonaModifica, c2);

        c2.insets = new Insets(15, 40, 0, 0);
        c2.gridx = 1;
        c2.gridy = 4;
        c2.weightx = 1;
        jpnModifica.add(jtfModificaZona, c2);

        c2.insets = new Insets(27, 100, 20, 15);
        c2.gridx = 1;
        c2.gridy = 5;
        c2.weightx = 0;
        c2.fill = GridBagConstraints.NONE;
        c2.weighty = 1;
        jpnModifica.add(jbtRemove, c2);

        c2.insets = new Insets(27, 5, 20, 15);
        c2.gridx = 2;
        c2.gridy = 5;
        c2.weightx = 0;
        c2.weighty = 1;
        jpnModifica.add(jbtModificar, c2);

        jTabbedPane.add("Modificar", jpnModifica);
        
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
    }
    
    private void setButtonActions() {
        jbtCadastro.addActionListener(actionManager);
        jbtCadastro.setActionCommand(Actions.CADASTRAR);
        
        jbtModificar.addActionListener(actionManager);
        jbtModificar.setActionCommand(Actions.MODIFICAR);
        
        jbtProcuraPorNome.addActionListener(actionManager);
        jbtProcuraPorNome.setActionCommand(Actions.PROCURAR_POR_NOME);
        
        jbtProcuraPorTitulo.addActionListener(actionManager);
        jbtProcuraPorTitulo.setActionCommand(Actions.PROCURAR_POR_NUMERO);
        
        jbtRemove.addActionListener(actionManager);
        jbtRemove.setActionCommand(Actions.REMOVER);

    }

    @Override
    Object[] atributosParaArray(Eleitor eleitor) {
        return new Object[]{eleitor.getNome(), eleitor.getTitulo(), 
            eleitor.getCidade().getNome(), eleitor.getZonaEleitoral(), 
            eleitor.getSecaoEleitoral()};
    }
    
    class ActionManager implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals(Actions.CADASTRAR)) {
                if (verificaTitulo(jtfTitulo.getText())) {
                    try {
                        
                        Cidade cidade = ControladorCidade.getInstance().getCidade(jcbCidade.getSelectedItem().toString());

                        Eleitor eleitor = new Eleitor(Integer.parseInt(jtfZona.getText()),Integer.parseInt(jtfSecao.getText()), Long.parseLong(jtfTitulo.getText()), verificaNome(jtfNome.getText()), cidade);
                        if (ControladorEleitor.getInstance().cadastra(eleitor)) {

                            JOptionPane.showMessageDialog(null, "Candidato cadastrado com sucesso!", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "Erro ao cadastrar eleitor", "Erro", JOptionPane.ERROR_MESSAGE);
                        }

                    } catch (NullPointerException nullPointerException) {
                        JOptionPane.showMessageDialog(null, "Erro ao cadastrar, certifique-se de selecionar todas as caixas de seleção.", "Erro", JOptionPane.ERROR_MESSAGE);
                    } catch (NomeVazio ex) {
                        JOptionPane.showMessageDialog(null, "Erro ao cadastrar, nome em branco.", "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                }

            }
            if (e.getActionCommand().equals(Actions.MODIFICAR)) {
                int x = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja modificar o eleitor?", "Aviso", JOptionPane.YES_NO_OPTION);
                if (x == JOptionPane.YES_OPTION && verificaTitulo(jtfModificaTitulo.getText())) {
                    try {
                        Cidade cidade = ControladorCidade.getInstance().getCidade(jcbModificaCidade.getSelectedItem().toString());

                        Eleitor eleitor = new Eleitor(Integer.parseInt(jtfModificaZona.getText()),Integer.parseInt(jtfModificaSecao.getText()), Long.parseLong(jtfModificaTitulo.getText()), verificaNome(jtfModificaNome.getText()), cidade);
                        ControladorEleitor.getInstance().modifica(eleitorModificado, eleitor);
                    } catch (NullPointerException nullPointerException) {
                        JOptionPane.showMessageDialog(null, "Erro ao modificar, certifique-se de selecionar todas as caixas de seleção.", "Erro", JOptionPane.ERROR_MESSAGE);
                    } catch (NomeVazio ex) {
                        JOptionPane.showMessageDialog(null, "Erro ao modificar, nome em branco.", "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                }

            }
            if (e.getActionCommand().equals(Actions.REMOVER)) {
                int x = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover o eleitor?", "Aviso", JOptionPane.YES_NO_OPTION);
                if (x == JOptionPane.YES_OPTION) {
                    if (ControladorEleitor.getInstance().remove(eleitorModificado)) {
                        jbtModificar.setEnabled(false);
                        jbtRemove.setEnabled(false);
                    }
                }

            }
            if (e.getActionCommand().equals(Actions.PROCURAR_POR_NUMERO)) {
                if (verificaTitulo(jtfModificaTitulo.getText())) {
                    eleitorModificado = ControladorEleitor.getInstance().getEleitor(Long.parseLong(jtfModificaTitulo.getText()));
                    if (eleitorModificado != null) {
                        jtfModificaNome.setText(eleitorModificado.getNome());
                        jtfModificaZona.setText(Integer.toString(eleitorModificado.getZonaEleitoral()));
                        jtfModificaSecao.setText(Integer.toString(eleitorModificado.getSecaoEleitoral()));
                        jcbModificaCidade.setSelectedItem(eleitorModificado.getCidade().getNome());

                        jbtModificar.setEnabled(true);
                        jbtRemove.setEnabled(true);
                    } else {
                        JOptionPane.showMessageDialog(null, "Eleitor não encontrado", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                        jbtModificar.setEnabled(false);
                        jbtRemove.setEnabled(false);
                    }
                }
            }

        }

        private boolean verificaTitulo(String titulo) {
            try {
                Long.parseLong(titulo);
                return true;
            } catch (NumberFormatException x) {
                JOptionPane.showMessageDialog(null, "Título inválido, insira somente números.", "Erro", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        
        
    }
    
}