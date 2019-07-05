
import Bibliotecas.MVC.BO.CalculoBO;
import Bibliotecas.MVC.DTO.Calculo;
import Bibliotecas.MVC.DTO.CalculoCustom;
import Bibliotecas.Uteis.HTMLViewer;
import Bibliotecas.Uteis.TabelaFrequencia;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.JFXPanel;
import javafx.stage.FileChooser;
import javax.swing.JFileChooser;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author rodriguh
 * @param <T> - subclasse da classe calculo
 * @param <E> - tipo do número. (inteiro, float, double...)
 */
public class Framework<T extends Calculo, E extends Number> {

    protected CalculoCustom calculo;
    protected TabelaFrequencia tabela;
    protected HTMLViewer html;
    protected CalculoBO calcBO;
    private List<Double> dados;

    public Framework(CalculoCustom clazz) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        this.calculo = clazz;
        this.initAttributes();
    }

    public void initAttributes() {
        dados = new ArrayList<>();
        calcBO = new CalculoBO("JSON");
        html = new HTMLViewer();
    }

    public void realizarCalculo() {
        calculo.realizarCalculo();
    }

    public void setDados(List<E> lista) {
        for (E l : lista) {
            this.dados.add(Double.parseDouble(String.valueOf(l)));
        }
        calculo.setDados(dados);
    }

    public void importarCalculo() {
        JFileChooser fc = new JFileChooser();
        fc.setCurrentDirectory(new File("ArquivosExportados"));
        int returnVal = fc.showOpenDialog(fc);
        File file = null;
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            file = fc.getSelectedFile();
        }
        if (fc.getSelectedFile() != null) {
            if (file.getAbsolutePath().endsWith("xml")) {
                calcBO.setPersistencia("xml");
            } else if (file.getAbsolutePath().endsWith("json")) {
                calcBO.setPersistencia("json");
            }
            calculo = calcBO.importar(file.getAbsolutePath());
            calculo.realizarCalculo();
        }
    }

    public DefaultTableModel gerarTabelaDeFreq() {
        this.tabela = new TabelaFrequencia(dados);

        return this.tabela.dtm;
    }

    public JFXPanel gerarGrafico(String htmlFileName) {
        try {
            return html.generateHTML(this.tabela.grafico.drawChart(tabela.dtm), "teste");
        } catch (IOException ex) {
            return null;
        }
    }
}
