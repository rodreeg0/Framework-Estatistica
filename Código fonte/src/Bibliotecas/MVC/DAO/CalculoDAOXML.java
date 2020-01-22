/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bibliotecas.MVC.DAO;

import Bibliotecas.MVC.DTO.Calculo;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author rodriguh
 */
public class CalculoDAOXML implements ICalculo {

    
    /**
     * Exporta um objeto calculo na persistencia.
     * @param path - Caminho do arquivo XML.
     * @return - Objeto importado.
     */
    @Override
    public Calculo importar(String path) {
        Calculo a = null;
        File file = new File(path);
        JAXBContext jaxbContext = null;
        try {
            jaxbContext = JAXBContext.newInstance(Calculo.class);
        } catch (JAXBException ex) {
            Logger.getLogger(CalculoDAOXML.class.getName()).log(Level.SEVERE, null, ex);
        }
        Unmarshaller unmarshaller = null;
        try {
            unmarshaller = jaxbContext.createUnmarshaller();
        } catch (JAXBException ex) {
            Logger.getLogger(CalculoDAOXML.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            a =  (Calculo) unmarshaller.unmarshal(file);
        } catch (JAXBException ex) {
            Logger.getLogger(CalculoDAOXML.class.getName()).log(Level.SEVERE, null, ex);
        }
        return a;
    }

    
    /**
     * Exporta um objeto calculo
     * @param calculo - Objeto a ser gravado na persistencia
     * @param filename - Nome do arquivo
     */
    @Override
    public void exportar(Calculo calculo, String filename) {
        JAXBContext jaxbContext = null;
        try {
            jaxbContext = JAXBContext.newInstance(Calculo.class);
        } catch (JAXBException ex) {
            Logger.getLogger(CalculoDAOXML.class.getName()).log(Level.SEVERE, null, ex);
        }
        Marshaller marshaller = null;
        try {
            marshaller = jaxbContext.createMarshaller();
        } catch (JAXBException ex) {
            Logger.getLogger(CalculoDAOXML.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        } catch (PropertyException ex) {
            Logger.getLogger(CalculoDAOXML.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            marshaller.marshal(calculo, new File("ArquivosExportados/xml/"+filename+".xml"));
        } catch (JAXBException ex) {
            Logger.getLogger(CalculoDAOXML.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            marshaller.marshal(calculo, System.out);
        } catch (JAXBException ex) {
            Logger.getLogger(CalculoDAOXML.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
