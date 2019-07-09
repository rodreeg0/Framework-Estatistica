/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BIBLIOTECAS.Outros;

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

   
    public DefaultTableModel modeloTabela;
    public IGrafico grafico;
    List<Double> listaDados = new ArrayList<>();
    int qtdClasses;
    int amplitudeClasse;

    public void setGrafico(IGrafico g) {
        grafico = g;
    }

    /**
     * Construtor - Calcula os parametros necessários para a construção do
     * modelo da tabela de intervalos de classe com base nos dados passados por
     * parametro.
     *
     * @param listaDados - Dados inseridos pelo cliente. Método é chamado pelo
     * framework.
     */
    public TabelaFrequencia(List<Double> listaDados) {
        this.listaDados.addAll(listaDados);
        this.sort();
        qtdClasses = (int) Math.round(1 + (3.3 * (Math.log10(Integer.parseInt(String.valueOf(this.listaDados.size()))))));
        amplitudeClasse = Integer.parseInt(String.valueOf(this.listaDados.get(this.listaDados.size() - 1) - this.listaDados.get(0)).split("\\.")[0]) / qtdClasses;
        modeloTabela = this.generateDefaultTableModel();
    }

    /**
     * Método private chamado apenas pelo construtor, responsavel por gerar o
     * modelo de tabela.
     *
     * @return - Modelo de tabela.
     */
    private DefaultTableModel generateDefaultTableModel() {
        modeloTabela = new DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "Intervalos de classe", "Frequência", "Frequência relativa"
                }
        );
        modeloTabela.setRowCount(qtdClasses);
        int aux = Integer.parseInt(String.valueOf(listaDados.get(0) - 1).split("\\.")[0]);
        int cont = aux + amplitudeClasse;
        for (int i = 0; i < modeloTabela.getColumnCount(); i++) {
            switch (i) {
                case 0:
                    for (int j = 0; j < modeloTabela.getRowCount(); j++) {
                        modeloTabela.setValueAt(aux + "--|" + ((j == modeloTabela.getRowCount() - 1) ? String.valueOf(listaDados.get(listaDados.size() - 1)).split("\\.")[0] : cont), j, i);
                        aux = cont;
                        cont = aux + amplitudeClasse;
                    }
                    break;
                case 1:

                    aux = Integer.parseInt(String.valueOf(listaDados.get(0) - 1).split("\\.")[0]);
                    for (int j = 0; j < modeloTabela.getRowCount(); j++) {
                        if (j == modeloTabela.getRowCount() - 1) {
                            cont = Integer.parseInt(String.valueOf(listaDados.get(listaDados.size() - 1) + 1).split("\\.")[0]);
                        } else {
                            cont = aux + amplitudeClasse;
                        }

                        modeloTabela.setValueAt((this.listElementCount(aux, cont)), j, i);
                        aux = cont;
                    }

                    break;

                default:
                    cont = 0;
                    for (int k = 0; k < modeloTabela.getRowCount(); k++) {
                        cont = (int) Math.round(Double.parseDouble(modeloTabela.getValueAt(k, 1).toString()) / listaDados.size() * 100);
                        modeloTabela.setValueAt(cont + "%", k, 2);
                    }
                    break;
            }
        }
        return modeloTabela;
    }

    /**
     * Método para contar quantos elementos estão entre algum determinado
     * intervalo de dados
     *
     * @param a - Valor minimo
     * @param b - Valor maximo
     * @return - Qtd elementos entre os dois valores.
     */
    private int listElementCount(int a, int b) {
        int cont = 0;
        for (Double i : listaDados) {
            if (i > a && i <= b) {
                cont++;
            }
        }
        return cont;
    }

    /**
     * Ordena a lista em ordem crescente
     */
    private void sort() {
        Collections.sort(listaDados);
    }

//    public JTable getTabela() {
//        return tabela;
//    }
//
//    public void setTabela(JTable tabela) {
//        this.tabela = tabela;
//    }

}
