/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bibliotecas.MVC.DAO;

import Bibliotecas.MVC.DTO.Calculo;
import Bibliotecas.MVC.DTO.CalculoCustom;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rodriguh
 * @param <T>
 */
public class CalculoDAOJSON implements ICalculo {

    @Override
    public void exportar(CalculoCustom a, String filename) {
        
    }

    @Override
    public CalculoCustom importar(String path) {
       BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(path));
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        Type listType = new TypeToken<CalculoCustom>() {
        }.getType();
        CalculoCustom calc;
        calc = new Gson().fromJson(bufferedReader, listType);
        return calc;
    }

}
