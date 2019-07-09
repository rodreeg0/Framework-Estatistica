/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BIBLIOTECAS.MVC.DAO;

import BIBLIOTECAS.MVC.DTO.Calculo;

/**
 *
 * @author rodriguh
 
 */
public interface ICalculo {
    
    public void exportar(Calculo a, String filename);
    public Calculo importar(String path);
}
