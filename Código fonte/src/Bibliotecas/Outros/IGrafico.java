/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BIBLIOTECAS.Outros;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author rodriguh
 */
public interface IGrafico {

    /**
     *
     * @param dm - Modelo de tabela para servir de base na construção da String
     * html
     * @return - String HTML
     */
    public String drawChart(DefaultTableModel dm);
}
