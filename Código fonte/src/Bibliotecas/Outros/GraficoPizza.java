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
public class GraficoPizza implements IGrafico {

    private String header;
    private String footer;

    /**
     * Atribui header e footer padrão.
     */
    public GraficoPizza() {
        header = "<html>\n"
                + "  <head>\n"
                + "    <script type=\"text/javascript\" src=\"https://www.gstatic.com/charts/loader.js\"></script>\n"
                + "    <script type=\"text/javascript\">\n"
                + "      google.charts.load('current', {'packages':['corechart']});\n"
                + "      google.charts.setOnLoadCallback(drawChart);\n"
                + "\n"
                + "      function drawChart() {\n"
                + "\n"
                + "        var data = google.visualization.arrayToDataTable([";
        footer = "var chart = new google.visualization.PieChart(document.getElementById('piechart'));\n"
                + "\n"
                + "        chart.draw(data, options);\n"
                + "      }\n"
                + "    </script>\n"
                + "  </head>\n"
                + "  <body>\n"
                + "    <div id=\"piechart\" style=\"width: 900px; height: 500px;\"></div>\n"
                + "  </body>\n"
                + "</html>";
    }

    /**
     * Gera a string HTML do grafico
     * @param dm - Modelo de tabela para servir de base na construção da String
     * html
     * @return - String HTML
     */
    @Override
    public String drawChart(DefaultTableModel dm) {
        StringBuilder sb = new StringBuilder();
        sb.append(header);
        sb.append("['Grafico' , 'something'],");
        for (int i = 0; i < dm.getRowCount(); i++) {
            sb.append("['").append(dm.getValueAt(i, 0)).append("',").append(dm.getValueAt(i, 1)).append("]");
            if (i == dm.getRowCount() - 1) {
                sb.append("\n");
            } else {
                sb.append(",\n");
            }
        }
        sb.append("]);\n").append("\n");
        sb.append("var options = {\n").append("title: '").append(dm.getColumnName(0)).append("'\n").append("};\n\n");
        sb.append(footer);
        return sb.toString();
    }
}
