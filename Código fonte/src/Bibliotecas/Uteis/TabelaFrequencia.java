/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bibliotecas.Uteis;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author rodriguh
 */
public class TabelaFrequencia {

    JTable tabela;
    public DefaultTableModel dtm;
    public IGrafico grafico;
    List<Double> listaDados = new ArrayList<>();
    int qtdClasses;
    int amplitudeClasse;

    public void setGrafico(IGrafico g) {
        grafico = g;
    }

    public TabelaFrequencia(List<Double> listaDados) {
        this.listaDados.addAll(listaDados);
        this.sort();
        qtdClasses = (int) Math.round(1 + (3.3 * (Math.log10(Integer.parseInt(String.valueOf(this.listaDados.size()))))));
        amplitudeClasse = Integer.parseInt(String.valueOf(this.listaDados.get(this.listaDados.size() - 1) - this.listaDados.get(0)).split("\\.")[0]) / qtdClasses;
        tabela = new JTable(this.generateDefaultTableModel());
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        for (int i = 0; i < tabela.getColumnCount(); i++) {
            tabela.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
            tabela.getColumnModel().getColumn(i).setHeaderRenderer(centerRenderer);
        }
    }

    private DefaultTableModel generateDefaultTableModel() {
        dtm = new DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "Intervalos de classe", "Frequência", "Frequência relativa"
                }
        );
        dtm.setRowCount(qtdClasses);
        int aux = Integer.parseInt(String.valueOf(listaDados.get(0) - 1).split("\\.")[0]);
        int cont = aux + amplitudeClasse;
        for (int i = 0; i < dtm.getColumnCount(); i++) {
            switch (i) {
                case 0:
                    for (int j = 0; j < dtm.getRowCount(); j++) {
                        dtm.setValueAt(aux + "--|" + ((j == dtm.getRowCount() - 1) ? String.valueOf(listaDados.get(listaDados.size() - 1)).split("\\.")[0] : cont), j, i);
                        aux = cont;
                        cont = aux + amplitudeClasse;
                    }
                    break;
                case 1:

                    aux = Integer.parseInt(String.valueOf(listaDados.get(0) - 1).split("\\.")[0]);
                    for (int j = 0; j < dtm.getRowCount(); j++) {
                        if (j == dtm.getRowCount() - 1) {
                            cont = Integer.parseInt(String.valueOf(listaDados.get(listaDados.size() - 1) + 1).split("\\.")[0]);
                        } else {
                            cont = aux + amplitudeClasse;
                        }

                        dtm.setValueAt((this.listElementCount(aux, cont)), j, i);
                        aux = cont;
                    }

                    break;

                default:
                    cont = 0;
                    for (int k = 0; k < dtm.getRowCount(); k++) {
                        cont = (int) Math.round(Double.parseDouble(dtm.getValueAt(k, 1).toString()) / listaDados.size() * 100);
                        dtm.setValueAt(cont + "%", k, 2);
                    }
                    break;
            }
        }
        return dtm;
    }

    private int listElementCount(int a, int b) {
        int cont = 0;
        for (Double i : listaDados) {
            if (i > a && i <= b) {
                cont++;
            }
        }
        return cont;
    }

    private void sort() {
        Collections.sort(listaDados);
    }

    public JTable getTabela() {
        return tabela;
    }

    public void setTabela(JTable tabela) {
        this.tabela = tabela;
    }

}
