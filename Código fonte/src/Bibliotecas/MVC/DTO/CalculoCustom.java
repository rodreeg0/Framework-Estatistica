/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bibliotecas.MVC.DTO;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author rodriguh
 */
@XmlRootElement()
public class CalculoCustom extends Calculo {

    private String descricao;

    public CalculoCustom() {

    }

    public String getDescricao() {
        return descricao;
    }

    @XmlElement()
    public void setDescricao(String atribute) {
        this.descricao = atribute;
    }

    /**
     * Valor usado por padrão no combobox
     *
     * @return String nome
     */
    @Override
    public String toString() {
        return this.getDescricao();
    }
}
