/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bibliotecas.MVC.DAO;

import Bibliotecas.MVC.DTO.CalculoCustom;
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

    @Override
    public CalculoCustom importar(String path) {
        CalculoCustom a = null;
        File file = new File(path);
        JAXBContext jaxbContext = null;
        try {
            jaxbContext = JAXBContext.newInstance(CalculoCustom.class);
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
            a = (CalculoCustom) unmarshaller.unmarshal(file);
        } catch (JAXBException ex) {
            Logger.getLogger(CalculoDAOXML.class.getName()).log(Level.SEVERE, null, ex);
        }
        return a;
    }

    @Override
    public void exportar(CalculoCustom a, String filename) {
        JAXBContext jaxbContext = null;
        try {
            jaxbContext = JAXBContext.newInstance(CalculoCustom.class);
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
            marshaller.marshal(a, new File("ArquivosExportados/xml/"+filename+".xml"));
        } catch (JAXBException ex) {
            Logger.getLogger(CalculoDAOXML.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            marshaller.marshal(a, System.out);
        } catch (JAXBException ex) {
            Logger.getLogger(CalculoDAOXML.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
