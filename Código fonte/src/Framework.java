
import Bibliotecas.MVC.BO.CalculoBO;
import Bibliotecas.MVC.DTO.Calculo;
import Bibliotecas.Outros.HTMLViewer;
import Bibliotecas.Outros.TabelaFrequencia;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javafx.embed.swing.JFXPanel;
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
 * @param <E> - tipo do número. (inteiro, float, double...)
 */
public class Framework< E extends Number> {

    protected Calculo calculo;
    protected TabelaFrequencia tabela;
    protected HTMLViewer html;
    protected CalculoBO calcBO;
    private List<Double> dados;

    /**
     * Construtor - Instancia novo calculo e outros atributos.
     */
    public Framework() {
        this.calculo = new Calculo();
        dados = new ArrayList<>();
        calcBO = new CalculoBO("JSON");
        html = new HTMLViewer();
    }

    /**
     *
     * @param lista - lista com dados definidos pelo usuário
     */
    public void setDados(List<E> lista) {
        for (E l : lista) {
            this.dados.add(Double.parseDouble(String.valueOf(l)));
        }
        calculo.setDados(dados);
    }

    /**
     * invoca o método da classe cálculo
     */
    public void realizarCalculo() {
        calculo.realizarCalculo();
    }

    /**
     * Método utilizado para importar um objeto cálculo salvo em persistencia
     */
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
        this.dados = calculo.getDados();
    }

    /**
     *
     * @param filename - Nome do arquivo a ser exportado
     * @param persistencia - Tipo de persistencia (XML ou JSON)
     */
    public void exportarCalculo(String filename, String persistencia) {
        calcBO.setPersistencia(persistencia);
        calcBO.exportar(calculo, filename);
    }

    /**
     * Invoca o método da tabela de frequencia
     * @return - Modelo de tabela, pronto para setar na view do main
     */
    public DefaultTableModel gerarTabelaDeFreq() {
        this.tabela = new TabelaFrequencia(dados);

        return this.tabela.modeloTabela;
    }

    /**
     * Invoca o método da classe grafico e da classe responsavel por gerar de gerar painel html
     * @param htmlFileName - Nome do arquivo html a ser salvo.
     * @return - Painel com gráfico gerado, já pronto para usuário inserir no frame.
     */
    public JFXPanel gerarGrafico(String htmlFileName) {
        try {
            return html.generateHTML(this.tabela.grafico.drawChart(tabela.modeloTabela), htmlFileName);
        } catch (IOException ex) {
            return null;
        }
    }
}
