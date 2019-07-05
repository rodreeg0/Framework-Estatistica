/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bibliotecas.MVC.DAO;

import Bibliotecas.MVC.DTO.Calculo;
import Bibliotecas.MVC.DTO.CalculoCustom;

/**
 *
 * @author rodriguh
 * @param <e>
 */
public interface ICalculo {
    
    public void exportar(CalculoCustom a, String filename);
    public CalculoCustom importar(String path);
}
