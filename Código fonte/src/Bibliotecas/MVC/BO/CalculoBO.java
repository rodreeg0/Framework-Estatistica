/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BIBLIOTECAS.MVC.BO;

import BIBLIOTECAS.MVC.DAO.CalculoDAOJSON;
import BIBLIOTECAS.MVC.DAO.CalculoDAOXML;
import BIBLIOTECAS.MVC.DAO.ICalculo;
import BIBLIOTECAS.MVC.DTO.Calculo;

/**
 *
 * @author rodriguh
 */
public class CalculoBO {

    
    ICalculo persistencia;
    
    /**
     * Construtor, inicializa tipo de persistencia
     * @param tipopersistencia - Tipo de persistencia desejado, JSON ou XML.
     */
    public CalculoBO(String tipopersistencia) {
        if ("XML".equalsIgnoreCase(tipopersistencia)) {
            persistencia = new CalculoDAOXML();
        } else {
            persistencia = new CalculoDAOJSON();
        }
    }

    /** Seta o tipo de persistencia desejado
     * @param tipo - Tipo de persistencia desejado, JSON ou XML.
     */
    public void setPersistencia(String tipo) {
        if ("XML".equalsIgnoreCase(tipo)) {
            if (!persistencia.getClass().isInstance(new CalculoDAOXML())) {
                persistencia = new CalculoDAOXML();
            }
        }else {
            if (!persistencia.getClass().isInstance(new CalculoDAOJSON())) {
                persistencia = new CalculoDAOJSON();
            }
        }
    }

    /**
     * 
     * @param path - Caminho do arquivo a ser importado, método é invocado pelo framework e invoca
     * o método importar da classe DAO (persistencia)
     * @return - Objeto calculo.
     */
    public Calculo importar(String path) {
        return persistencia.importar(path);
    }

    /**
     * Invoda o método "exportar" da classe DAO (persistencia)
     * @param calculo - Objeto a ser salvo na persistencia
     * @param filename - Nome do arquivo a ser salvo
     */
    public void exportar(Calculo calculo, String filename) {
        persistencia.exportar(calculo, filename);
    }
}
