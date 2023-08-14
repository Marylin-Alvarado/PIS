/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.awt.Label;


/**
 *
 * @author Marylin
 */
public class Resultados {
    private Integer id;
    private Integer id_candidato;
    private Integer id_voto;
    private Double porciento;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId_candidato() {
        return id_candidato;
    }

    public void setId_candidato(Integer id_candidato) {
        this.id_candidato = id_candidato;
    }

    public Integer getId_voto() {
        return id_voto;
    }

    public void setId_voto(Integer id_voto) {
        this.id_voto = id_voto;
    }

    public Double getPorciento() {
        return porciento;
    }

    public void setPorciento(Double porciento) {
        this.porciento = porciento;
    }

    @Override
    public String toString() {
        return "Resultados{" + "id=" + id + ", id_candidato=" + id_candidato + ", id_voto=" + id_voto + ", porciento=" + porciento + '}';
    }
    
   

   
}
