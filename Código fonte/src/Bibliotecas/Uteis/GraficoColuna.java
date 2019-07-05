/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bibliotecas.Uteis;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author rodriguh
 */
public class GraficoColuna implements IGrafico {

    String header;
    String footer;

    public GraficoColuna() {
        header = "<script type=\"text/javascript\" src=\"https://www.gstatic.com/charts/loader.js\"></script>\n"
                + "  <script type=\"text/javascript\">\n"
                + "    google.charts.load(\"current\", {packages:['corechart']});\n"
                + "    google.charts.setOnLoadCallback(drawChart);\n"
                + "    function drawChart() {\n"
                + "      var data = google.visualization.arrayToDataTable([";
        footer = "var view = new google.visualization.DataView(data);\n"
                + "      view.setColumns([0, 1,\n"
                + "                       { calc: \"stringify\",\n"
                + "                         sourceColumn: 1,\n"
                + "                         type: \"string\",\n"
                + "                         role: \"annotation\" },\n"
                + "                       2]);\n"
                + "\n"
                + "      var options = {\n"
                + "        title: \"Grafico de colunas\",\n"
                + "        width: 600,\n"
                + "        height: 400,\n"
                + "        bar: {groupWidth: \"95%\"},\n"
                + "        legend: { position: \"none\" },\n"
                + "      };\n"
                + "      var chart = new google.visualization.ColumnChart(document.getElementById(\"columnchart_values\"));\n"
                + "      chart.draw(view, options);\n"
                + "  }\n"
                + "  </script>\n"
                + "<div id=\"columnchart_values\" style=\"width: 900px; height: 300px;\"></div>";
    }

    @Override
    public String drawChart(DefaultTableModel dm) {
        StringBuilder sb = new StringBuilder();
        sb.append(header);
        sb.append("[\"Grafico\" , \"coluna\", { role: \"style\" }],");
        for (int i = 0; i < dm.getRowCount(); i++) {
            sb.append("[\"").append(dm.getValueAt(i, 0)).append("\",").append(dm.getValueAt(i, 1)).append(",\"blue\"").append("]");
            if(i == dm.getRowCount() -1)
                sb.append("\n");
            else
                sb.append(",\n");
        }
        sb.append("]);\n").append("\n");
//        sb.append("var options = {\n").append("title: '").append(dm.getColumnName(0)).append("\"\n").append("};\n\n");
        sb.append(footer);
        System.out.println(sb.toString());
        return sb.toString();
    }

}
