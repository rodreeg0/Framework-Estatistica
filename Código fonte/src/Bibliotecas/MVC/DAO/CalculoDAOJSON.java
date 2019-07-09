/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BIBLIOTECAS.MVC.DAO;

import BIBLIOTECAS.MVC.DTO.Calculo;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rodriguh
 */
public class CalculoDAOJSON implements ICalculo {

    /**
     * Exporta um objeto calculo na persistencia
     * @param calculo - Objeto a ser exportado em JSON.
     * @param filename - Nome do arquivo.
     */
    @Override
    public void exportar(Calculo calculo, String filename) {
        File file = new File("ArquivosExportados/json/" + filename + ".json");

        if (file != null) {
            GsonBuilder gBuilder = new GsonBuilder();
            Gson gson = gBuilder.create();
            FileWriter writer = null;
            try {
                writer = new FileWriter(file.getAbsolutePath());
            } catch (IOException ex) {
                Logger.getLogger(CalculoDAOJSON.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                writer.write(gson.toJson(calculo));
            } catch (IOException ex) {
                Logger.getLogger(CalculoDAOJSON.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                writer.close();
            } catch (IOException ex) {
                Logger.getLogger(CalculoDAOJSON.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * Importa um arquivo json em objeto calculo.
     * @param path - Caminho do arquivo JSON.
     * @return - Objeto calculo importado.
     */
    @Override
    public Calculo importar(String path) {
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(path));
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        Type listType = new TypeToken<Calculo>() {
        }.getType();
        Calculo calc;
        calc = new Gson().fromJson(bufferedReader, listType);
        return calc;
    }

}
