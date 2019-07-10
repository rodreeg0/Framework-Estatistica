

import java.util.ArrayList;
import java.util.List;
import junit.framework.TestCase;

/**
 *
 * @author rodriguh
 */
public class TestesFramework extends TestCase{
    
    Framework f = new Framework();
    
    public TestesFramework(){
        List<Double> dados = new ArrayList<>();
        dados.add(12.0);
        dados.add(12.0);
        dados.add(21.0);
        dados.add(24.0);
        dados.add(32.0);
        dados.add(33.0);
        f.calculo.setDados(dados);
        f.calculo.realizarCalculo();
    }
    
    /*O parametro "%1$,.2f", serve para formatar um número decimal em uma String no padrao ##,##.
    * Deste modo a comparação será feita entre Strings.
    */
    
    public void test_media(){
        assertEquals("22,33", String.format("%1$,.2f", f.calculo.getMedia()));
    }
    
    public void test_moda(){
        assertEquals("12,00", String.format("%1$,.2f", f.calculo.getModa()));
    }
    
    public void test_mediana(){
        assertEquals("22,50", String.format("%1$,.2f", f.calculo.getMediana()));
    }
    
    public void test_amplitude(){
        assertEquals("21,00", String.format("%1$,.2f", f.calculo.getAmplitude()));
    }
    
    public void test_variancia(){
        assertEquals("70,89", String.format("%1$,.2f", f.calculo.getVariancia()));
    }
    
    public void test_desviopadrao(){
        assertEquals("8,42", String.format("%1$,.2f", f.calculo.getDesvioPadrao()));
    }
    
    public void test_coeficienteVariacao(){
        assertEquals("37,70", String.format("%1$,.2f", f.calculo.getCoeficienteDeVariacao()));
    }
}
