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
public class GraficoLinha implements IGrafico {

    String header;
    String footer;

    public GraficoLinha() {
        header = " <html>\n"
                + "  <head>\n"
                + "    <script type=\"text/javascript\" src=\"https://www.gstatic.com/charts/loader.js\"></script>\n"
                + "    <script type=\"text/javascript\">\n"
                + "      google.charts.load('current', {'packages':['corechart']});\n"
                + "      google.charts.setOnLoadCallback(drawChart);\n"
                + "\n"
                + "      function drawChart() {\n"
                + "        var data = google.visualization.arrayToDataTable([";
        footer = "var options = {\n"
                + "          title: 'Grafico de linha',\n"
                + "          curveType: 'line_material',\n"
                + "          legend: { position: 'bottom' }\n"
                + "        };\n"
                + "\n"
                + "        var chart = new google.visualization.LineChart(document.getElementById('curve_chart'));\n"
                + "\n"
                + "        chart.draw(data, options);\n"
                + "      }\n"
                + "    </script>\n"
                + "  </head>\n"
                + "  <body>\n"
                + "    <div id=\"curve_chart\" style=\"width: 900px; height: 500px\"></div>\n"
                + "  </body>\n"
                + "</html>";
    }

    @Override
    public String drawChart(DefaultTableModel dm) {
        StringBuilder sb = new StringBuilder();
        sb.append(header);
        sb.append("['Intervalo' , 'Idade'],");
        for (int i = 0; i < dm.getRowCount(); i++) {
            sb.append("['").append(dm.getValueAt(i, 0)).append("',").append(dm.getValueAt(i, 1)).append("]");
            if(i == dm.getRowCount() -1)
                sb.append("\n");
            else
                sb.append(",\n");
        }
        sb.append("]);\n").append("\n");
//        
        sb.append(footer);
        System.out.println(sb.toString());
        return sb.toString();
    }
}
