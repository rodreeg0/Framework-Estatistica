package Bibliotecas.MVC.DTO;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author rodri
 */
@XmlTransient()
public class Calculo {

    private List<Double> dados;
    private double media;
    private double mediana;
    private double moda;
    private double amplitude;
    private double variancia;
    private double desvioPadrao;
    private double coeficienteDeVariacao;

    
    public Calculo() {

        dados = new ArrayList<>();
    }

    public void addDado(double dado) {
        dados.add(dado);
    }

    public void clearData() {
        dados.clear();
        media = 0;
        amplitude = 0;
        variancia = 0;
        desvioPadrao = 0;
        coeficienteDeVariacao = 0;

    }

    public void realizarCalculo() {
        double soma = 0;
        double maiorValor = 0;
        double menorValor = 0;
        for (double d : this.dados) {
            if (this.dados.indexOf(d) == 0) {
                menorValor = d;
            }
            soma += d;
            if (d > maiorValor) {
                maiorValor = d;
            }
            if (d < menorValor) {
                menorValor = d;
            }
        }
        media = soma / dados.size();
        soma = 0;
        for (double d : this.dados) {
            soma += (d - media) * (d - media);
        }
        amplitude = maiorValor - menorValor;
        variancia = soma / this.dados.size();
        desvioPadrao = Math.sqrt(variancia);
        coeficienteDeVariacao = (desvioPadrao / media) * 100;
    }

    public double getMedia() {
        return media;
    }

    public double getMediana() {
        return mediana;
    }

    public void setMediana(double mediana) {
        this.mediana = mediana;
    }

    public double getModa() {
        return moda;
    }

    public void setModa(double moda) {
        this.moda = moda;
    }

    public void setMedia(double media) {
        this.media = media;
    }

    public List<Double> getDados() {
        return dados;
    }

    public void setDados(List<Double> dados) {
        this.dados = dados;
    }

    public double getAmplitude() {
        return amplitude;
    }

    public void setAmplitude(double amplitude) {
        this.amplitude = amplitude;
    }

    public double getVariancia() {
        return variancia;
    }

    public void setVariancia(double variancia) {
        this.variancia = variancia;
    }

    public double getDesvioPadrao() {
        return desvioPadrao;
    }

    public void setDesvioPadrao(double desvioPadrao) {
        this.desvioPadrao = desvioPadrao;
    }

    public double getCoeficienteDeVariacao() {
        return coeficienteDeVariacao;
    }

    public void setCoeficienteDeVariacao(double coeficienteDeVariacao) {
        this.coeficienteDeVariacao = coeficienteDeVariacao;
    }

}
