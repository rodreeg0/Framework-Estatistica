/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bibliotecas.MVC.BO;

import Bibliotecas.MVC.DAO.CalculoDAOJSON;
import Bibliotecas.MVC.DAO.CalculoDAOXML;
import Bibliotecas.MVC.DAO.ICalculo;
import Bibliotecas.MVC.DTO.Calculo;
import Bibliotecas.MVC.DTO.CalculoCustom;

/**
 *
 * @author rodriguh
 * @param <T>
 */
public class CalculoBO {

    ICalculo persistencia;

    public CalculoBO(){
        
    }
    
    public CalculoBO(String tipopersistencia) {
        if ("XML".equalsIgnoreCase(tipopersistencia)) {
            persistencia = new CalculoDAOXML();
        } else {
            persistencia = new CalculoDAOJSON();
        }
    }

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

    public CalculoCustom importar(String path) {
        return persistencia.importar(path);
    }

    public void exportar(CalculoCustom a, String filename) {
        persistencia.exportar(a, filename);
    }
}
