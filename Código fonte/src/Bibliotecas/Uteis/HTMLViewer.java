/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bibliotecas.Uteis;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
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

    public JFXPanel generateHTML(String html, String filename) throws IOException {
        File arquivo = new File("ArquivosExportados/html/" + filename + ".html");
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
