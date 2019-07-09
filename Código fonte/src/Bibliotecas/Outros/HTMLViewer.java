/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BIBLIOTECAS.Outros;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.web.WebView;

/**
 *
 * @author rodriguh
 */
public class HTMLViewer {

    JFXPanel jfxPanel;

    public JFXPanel getJfxPanel() {
        return jfxPanel;
    }

    public void setJfxPanel(JFXPanel jfxPanel) {
        this.jfxPanel = jfxPanel;
    }

    /**
     * Gera painel HTML
     * @param html - Html do gráfico.
     * @param htmlFileName - Nome do arquivo HTML a ser salvo na persistencia.
     * Como a função retorna um painel aceito somente pelo Frame, é realizado o
     * salvamento da string html em um arquivo HTML, que fica salvo em
     * "ArquivosExportados/html/filename.html".
     *
     * @return - Painel HTML.
     * @throws IOException - passa por essa exceção se o arquivo nao for encontrado.
     */
    public JFXPanel generateHTML(String html, String htmlFileName) throws IOException {
        File arquivo = new File("ArquivosExportados/html/" + htmlFileName + ".html");
        try (FileWriter bw = new FileWriter((arquivo.getAbsolutePath()))) {
            bw.write(html);
        }
        jfxPanel = new JFXPanel(); // Scrollable JCompenent
        Platform.runLater(() -> { // FX components need to be managed by JavaFX
            WebView webView = new WebView();
            URL a = null;
            try {
                a = arquivo.toURI().toURL();
            } catch (MalformedURLException ex) {
            }
            webView.getEngine().loadContent("<html>Gráfico</html>");
            webView.getEngine().load(a.toString());
            jfxPanel.setScene(new Scene(webView));
        });
        return jfxPanel;
    }
}
