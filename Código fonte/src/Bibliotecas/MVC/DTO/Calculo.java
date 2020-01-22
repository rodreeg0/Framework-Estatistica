package Bibliotecas.MVC.DTO;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import sun.security.pkcs11.wrapper.Functions;

/**
 *
 * @author rodri
 */
@XmlRootElement()
public class Calculo {

    private List<Double> dados;
    private double media;
    private double mediana;
    private double moda;
    private double amplitude;
    private double variancia;
    private double desvioPadrao;
    private double coeficienteDeVariacao;
    private String descricao;

    public Calculo() {
        dados = new ArrayList<>();
    }

    /**
     * Zera todos os atributos
     */
    public void clearData() {
        dados.clear();
        media = 0;
        moda = 0;
        mediana = 0;
        amplitude = 0;
        variancia = 0;
        desvioPadrao = 0;
        coeficienteDeVariacao = 0;
    }

    /**
     * Realiza os calculos com base na lista e popula todos os atributos
     */
    public void realizarCalculo() {
        double soma = 0;
        double maiorValor = 0;
        double menorValor = 0;
        Collections.sort(dados);
        maiorValor = dados.get(dados.size() - 1);
        menorValor = dados.get(0);
        soma = dados.stream().map((d) -> d).reduce(soma, (accumulator, _item) -> accumulator + _item);
        media = soma / dados.size();
        if (dados.size() % 2 == 0) {
            mediana = (dados.get(dados.size() / 2) + dados.get(dados.size() / 2 - 1)) / 2;
        } else {
            mediana = dados.get(dados.size() / 2);
        }
        moda = this.mostCommon(dados);
        soma = 0;
        for (double d : this.dados) {
            soma += (d - media) * (d - media);
        }
        amplitude = maiorValor - menorValor;
        variancia = soma / this.dados.size();
        desvioPadrao = Math.sqrt(variancia);
        coeficienteDeVariacao = (desvioPadrao / media) * 100;
    }

    /**
     * Metodo private invocado apenas pelo método "realizar calculo" Serve para
     * obter a moda dos valores.
     *
     * @param list - lista de valores
     * @return - Moda.
     */
    private Double mostCommon(List<Double> list) {

        Map<Double, Integer> stringsCount = new HashMap<>();
        for (Double s : list) {
            Integer c = stringsCount.get(s);
            if (c == null) {
                c = new Integer(0);
            }
            c++;
            stringsCount.put(s, c);
        }

        Map.Entry<Double, Integer> mostRepeated = null;
        Map.Entry<Double, Integer> aux = null;
        boolean flag = false;
        for (Map.Entry<Double, Integer> e : stringsCount.entrySet()) {
            if (!flag) {
                aux = e;
                flag = true;
            }
            if (aux.getValue() < e.getValue()) {
                mostRepeated = e;
            }
        }

        return mostRepeated == null ? 0.0 : mostRepeated.getKey();

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

    public String getDescricao() {
        return descricao;
    }

    @XmlElement()
    public void setDescricao(String atribute) {
        this.descricao = atribute;
    }

}
