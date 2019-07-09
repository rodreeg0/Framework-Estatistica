/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import BIBLIOTECAS.MVC.DTO.Calculo;
import BIBLIOTECAS.Outros.GraficoColuna;
import BIBLIOTECAS.Outros.GraficoLinha;
import BIBLIOTECAS.Outros.GraficoPizza;
import BIBLIOTECAS.Outros.HTMLViewer;
import java.awt.Color;
import java.awt.ScrollPane;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author rodrigo
 */
public class Main extends javax.swing.JFrame {

    private DefaultTableModel dm1 = new DefaultTableModel(0, 0);
    protected List<Integer> lista = new ArrayList<>();

    Framework<Integer> framework;

    public Main() {

        this.framework = new Framework();

        initComponents();
        initJComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoBotoes = new javax.swing.ButtonGroup();
        painelPai = new javax.swing.JPanel();
        telaMain = new javax.swing.JPanel();
        mainScrollPane = new javax.swing.JScrollPane();
        mainTabelaDados = new javax.swing.JTable();
        mainCampoDados = new javax.swing.JTextField();
        mainAdd = new javax.swing.JButton();
        mainCalcular = new javax.swing.JButton();
        mainVariancia = new javax.swing.JLabel();
        mainCoeficiente = new javax.swing.JLabel();
        mainDesvioPadrao = new javax.swing.JLabel();
        mainAmplitude = new javax.swing.JLabel();
        mainAviso = new javax.swing.JLabel();
        gerarTabela = new javax.swing.JButton();
        mainDescricao = new javax.swing.JTextField();
        mainZerarValores = new javax.swing.JButton();
        mainImportarDados = new javax.swing.JButton();
        mainMedia = new javax.swing.JLabel();
        mainMediana = new javax.swing.JLabel();
        mainExportar = new javax.swing.JButton();
        freqTablePanel = new javax.swing.JPanel();
        scrollFreqTable = new javax.swing.JScrollPane();
        freqTable = new javax.swing.JTable();
        voltarFreq = new javax.swing.JButton();
        pizza = new javax.swing.JRadioButton();
        linha = new javax.swing.JRadioButton();
        coluna = new javax.swing.JRadioButton();
        gerarGrafico = new javax.swing.JButton();
        graphicPanel = new javax.swing.JPanel();
        scrollgraphic = new javax.swing.JScrollPane();
        jSeparator1 = new javax.swing.JSeparator();
        graphicVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName(""); // NOI18N
        setResizable(false);

        painelPai.setLayout(new java.awt.CardLayout());

        mainTabelaDados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1"
            }
        ));
        mainScrollPane.setViewportView(mainTabelaDados);

        mainCampoDados.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        mainCampoDados.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        mainAdd.setText("ADICIONAR");
        mainAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mainAddActionPerformed(evt);
            }
        });

        mainCalcular.setText("CALCULAR");
        mainCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mainCalcularActionPerformed(evt);
            }
        });

        mainVariancia.setBackground(new java.awt.Color(153, 153, 255));
        mainVariancia.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        mainVariancia.setText("Variância");
        mainVariancia.setToolTipText("");

        mainCoeficiente.setText("Coeficiente de variação");

        mainDesvioPadrao.setText("Desvio padrão");

        mainAmplitude.setText("Amplitude total");

        mainAviso.setForeground(new java.awt.Color(204, 0, 0));
        mainAviso.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        mainAviso.setText("Por favor, digite um número válido");

        gerarTabela.setText("GERAR TABELA FREQUENCIA");
        gerarTabela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gerarTabelaActionPerformed(evt);
            }
        });

        mainDescricao.setBackground(new java.awt.Color(153, 153, 255));
        mainDescricao.setText("Informe o que está sendo calculado");
        mainDescricao.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                mainDescricaoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                mainDescricaoFocusLost(evt);
            }
        });

        mainZerarValores.setText("ZERAR");
        mainZerarValores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mainZerarValoresActionPerformed(evt);
            }
        });

        mainImportarDados.setText("IMPORTAR");
        mainImportarDados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mainImportarDadosActionPerformed(evt);
            }
        });

        mainMedia.setText("Média");

        mainMediana.setText("Mediana");

        mainExportar.setText("EXPORTAR");
        mainExportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mainExportarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout telaMainLayout = new javax.swing.GroupLayout(telaMain);
        telaMain.setLayout(telaMainLayout);
        telaMainLayout.setHorizontalGroup(
            telaMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, telaMainLayout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addGroup(telaMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(telaMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(mainAviso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, telaMainLayout.createSequentialGroup()
                            .addComponent(mainCampoDados)
                            .addGap(18, 18, 18)
                            .addGroup(telaMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(mainAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(mainCalcular, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(mainVariancia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(mainCoeficiente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(mainDesvioPadrao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(mainAmplitude, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(mainDescricao)
                        .addComponent(mainMedia, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(mainMediana, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 102, Short.MAX_VALUE)
                .addGroup(telaMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(telaMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, telaMainLayout.createSequentialGroup()
                            .addComponent(mainImportarDados)
                            .addGap(18, 18, 18)
                            .addComponent(mainZerarValores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(gerarTabela, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(mainScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(mainExportar))
                .addGap(101, 101, 101))
        );
        telaMainLayout.setVerticalGroup(
            telaMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(telaMainLayout.createSequentialGroup()
                .addGroup(telaMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(telaMainLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(mainAviso)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(telaMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(mainCampoDados, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(telaMainLayout.createSequentialGroup()
                                .addComponent(mainAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(mainCalcular, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mainDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(mainMedia, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(mainMediana, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                        .addComponent(mainAmplitude, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mainVariancia, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mainDesvioPadrao, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(mainCoeficiente, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(telaMainLayout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(mainExportar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(telaMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(mainImportarDados)
                            .addComponent(mainZerarValores))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(mainScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(gerarTabela)))
                .addGap(21, 21, 21))
        );

        painelPai.add(telaMain, "card3");

        freqTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        scrollFreqTable.setViewportView(freqTable);

        voltarFreq.setText("VOLTAR");
        voltarFreq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltarFreqActionPerformed(evt);
            }
        });

        grupoBotoes.add(pizza);
        pizza.setText("GRAFICO PIZZA");

        grupoBotoes.add(linha);
        linha.setText("GRAFICO LINHA");

        grupoBotoes.add(coluna);
        coluna.setText("GRAFICO COLUNA");

        gerarGrafico.setText("GERAR GRAFICO");
        gerarGrafico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gerarGraficoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout freqTablePanelLayout = new javax.swing.GroupLayout(freqTablePanel);
        freqTablePanel.setLayout(freqTablePanelLayout);
        freqTablePanelLayout.setHorizontalGroup(
            freqTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(freqTablePanelLayout.createSequentialGroup()
                .addGroup(freqTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(freqTablePanelLayout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addGroup(freqTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(coluna)
                            .addComponent(pizza)
                            .addGroup(freqTablePanelLayout.createSequentialGroup()
                                .addComponent(linha)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(gerarGrafico)
                                .addGap(44, 44, 44)
                                .addComponent(voltarFreq)
                                .addGap(101, 101, 101))))
                    .addGroup(freqTablePanelLayout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(scrollFreqTable, javax.swing.GroupLayout.PREFERRED_SIZE, 571, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(67, Short.MAX_VALUE))
        );
        freqTablePanelLayout.setVerticalGroup(
            freqTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(freqTablePanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(scrollFreqTable, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pizza)
                .addGap(8, 8, 8)
                .addGroup(freqTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(linha)
                    .addComponent(voltarFreq)
                    .addComponent(gerarGrafico))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(coluna)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        painelPai.add(freqTablePanel, "card3");

        graphicVoltar.setText("VOLTAR");
        graphicVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                graphicVoltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout graphicPanelLayout = new javax.swing.GroupLayout(graphicPanel);
        graphicPanel.setLayout(graphicPanelLayout);
        graphicPanelLayout.setHorizontalGroup(
            graphicPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollgraphic)
            .addGroup(graphicPanelLayout.createSequentialGroup()
                .addComponent(jSeparator1)
                .addContainerGap())
            .addGroup(graphicPanelLayout.createSequentialGroup()
                .addGap(309, 309, 309)
                .addComponent(graphicVoltar)
                .addContainerGap(319, Short.MAX_VALUE))
        );
        graphicPanelLayout.setVerticalGroup(
            graphicPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(graphicPanelLayout.createSequentialGroup()
                .addComponent(scrollgraphic, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(graphicVoltar)
                .addGap(0, 17, Short.MAX_VALUE))
        );

        painelPai.add(graphicPanel, "card4");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelPai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelPai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getAccessibleContext().setAccessibleDescription("");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void initMainComponents() {
        lista.clear();
        for (int i = dm1.getRowCount() - 1; i >= 0; i--) {
            dm1.removeRow(i);
        }
        mainVariancia.setText("Variância");
        mainMedia.setText("Média");
        mainDescricao.setText("Informe o que está sendo calculado");
        mainDesvioPadrao.setText("Desvio padrão");
        mainCoeficiente.setText("Coeficiente");
        mainAmplitude.setText("Amplitude");
    }

    private void initJComponents() {
        grupoBotoes.setSelected(pizza.getModel(), true);
        mainAviso.setVisible(false);

        //Criando modelo de tabela (cabeçalho e alinhamento)
        String header[] = new String[]{"DADOS"};
        dm1.setColumnIdentifiers(header);
        mainTabelaDados.setModel(dm1);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        mainTabelaDados.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        mainTabelaDados.getColumnModel().getColumn(0).setHeaderRenderer(centerRenderer);

    }

    private void changePanel(JPanel panel) {
        painelPai.removeAll();
        painelPai.add(panel);
        painelPai.repaint();
        painelPai.revalidate();
    }

    private void realizarCalculos() {
        framework.calculo.setDescricao(mainDescricao.getText());
        framework.setDados(lista);
        framework.realizarCalculo();
        this.preencherLabels();
    }

    private void preencherLabels() {
        mainMedia.setText("Média: " + String.format("%1$,.2f", framework.calculo.getMedia()));
        mainMediana.setText("Mediana: " + String.format("%1$,.2f", framework.calculo.getMediana()));
        mainAmplitude.setText("Amplitude total: " + String.format("%1$,.2f", framework.calculo.getAmplitude()));
        mainVariancia.setText("Variância: " + String.format("%1$,.2f", framework.calculo.getVariancia()));
        mainDesvioPadrao.setText("Desvio padrão: " + String.format("%1$,.2f", framework.calculo.getDesvioPadrao()));
        mainCoeficiente.setText("Coeficiente de variação: " + String.format("%1$,.2f", framework.calculo.getCoeficienteDeVariacao()) + "%");
    }

    private void mainAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mainAddActionPerformed
        Pattern pattern = Pattern.compile("^\\d+$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(mainCampoDados.getText());
        if (matcher.matches()) {
            mainAviso.setVisible(false);
            lista.add(Integer.parseInt(mainCampoDados.getText()));
            dm1.addRow(new Object[]{Double.parseDouble(mainCampoDados.getText())});
            mainCampoDados.setText("");
            mainCampoDados.requestFocus();
        } else {
            mainCampoDados.setText("");
            mainAviso.setVisible(true);
        }
    }//GEN-LAST:event_mainAddActionPerformed

    private void mainCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mainCalcularActionPerformed
        if (lista.isEmpty()) {
            mainAviso.setText("Nao há dados");
            mainAviso.setVisible(true);
        } else {
            if (mainDescricao.getText().equals("Informe o que está sendo calculado")) {
                mainAviso.setText("Informe o que está sendo calculado");
                mainAviso.setVisible(true);
            } else {
                mainAviso.setVisible(false);
                this.realizarCalculos();
            }
        }
    }//GEN-LAST:event_mainCalcularActionPerformed

    private void mainDescricaoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_mainDescricaoFocusGained
        if (mainDescricao.getText().equals("Informe o que está sendo calculado")) {
            mainDescricao.setText("");
        }

    }//GEN-LAST:event_mainDescricaoFocusGained

    private void mainDescricaoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_mainDescricaoFocusLost
        if (mainDescricao.getText().equals("")) {
            mainDescricao.setText("Informe o que está sendo calculado");
        }
    }//GEN-LAST:event_mainDescricaoFocusLost

    private void mainImportarDadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mainImportarDadosActionPerformed
        framework.importarCalculo();
        this.initMainComponents();
        this.preencherLabels();
        for (int i = 0; i < framework.calculo.getDados().size(); i++) {
            dm1.addRow(new Object[]{Double.parseDouble(String.valueOf(framework.calculo.getDados().get(i)))});
        }
    }//GEN-LAST:event_mainImportarDadosActionPerformed

    private void mainZerarValoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mainZerarValoresActionPerformed
        this.initMainComponents();
    }//GEN-LAST:event_mainZerarValoresActionPerformed

    private void voltarFreqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarFreqActionPerformed
        this.changePanel(telaMain);
    }//GEN-LAST:event_voltarFreqActionPerformed

    private void gerarGraficoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gerarGraficoActionPerformed

        if (pizza.isSelected()) {
            framework.tabela.setGrafico(new GraficoPizza());
        } else if (linha.isSelected()) {
            framework.tabela.setGrafico(new GraficoLinha());
        } else {
            framework.tabela.setGrafico(new GraficoColuna());
        }
        try {
            this.scrollgraphic.setViewportView(framework.html.generateHTML(framework.tabela.grafico.drawChart(framework.tabela.modeloTabela), mainDescricao.getText()));
        } catch (IOException ex) {
            ex.printStackTrace();
            return;
        }
        this.changePanel(graphicPanel);
    }//GEN-LAST:event_gerarGraficoActionPerformed

    private void gerarTabelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gerarTabelaActionPerformed
        this.freqTable.setModel(framework.gerarTabelaDeFreq());

        this.changePanel(freqTablePanel);
    }//GEN-LAST:event_gerarTabelaActionPerformed

    private void graphicVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_graphicVoltarActionPerformed
        this.changePanel(freqTablePanel);
        scrollgraphic.remove(scrollgraphic.getViewport());
    }//GEN-LAST:event_graphicVoltarActionPerformed

    private void mainExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mainExportarActionPerformed
        this.framework.exportarCalculo(mainDescricao.getText(), "xml");
    }//GEN-LAST:event_mainExportarActionPerformed

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
                    UIManager.put("nimbusBase", new Color(204, 0, 0));
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton coluna;
    private javax.swing.JTable freqTable;
    private javax.swing.JPanel freqTablePanel;
    private javax.swing.JButton gerarGrafico;
    private javax.swing.JButton gerarTabela;
    private javax.swing.JPanel graphicPanel;
    private javax.swing.JButton graphicVoltar;
    private javax.swing.ButtonGroup grupoBotoes;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JRadioButton linha;
    private javax.swing.JButton mainAdd;
    private javax.swing.JLabel mainAmplitude;
    private javax.swing.JLabel mainAviso;
    private javax.swing.JButton mainCalcular;
    private javax.swing.JTextField mainCampoDados;
    private javax.swing.JLabel mainCoeficiente;
    private javax.swing.JTextField mainDescricao;
    private javax.swing.JLabel mainDesvioPadrao;
    private javax.swing.JButton mainExportar;
    private javax.swing.JButton mainImportarDados;
    private javax.swing.JLabel mainMedia;
    private javax.swing.JLabel mainMediana;
    private javax.swing.JScrollPane mainScrollPane;
    private javax.swing.JTable mainTabelaDados;
    private javax.swing.JLabel mainVariancia;
    private javax.swing.JButton mainZerarValores;
    private javax.swing.JPanel painelPai;
    private javax.swing.JRadioButton pizza;
    private javax.swing.JScrollPane scrollFreqTable;
    private javax.swing.JScrollPane scrollgraphic;
    private javax.swing.JPanel telaMain;
    private javax.swing.JButton voltarFreq;
    // End of variables declaration//GEN-END:variables
}
