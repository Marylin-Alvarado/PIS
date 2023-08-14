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
    
    //Atributo tipo integer de id de resultado
    private Integer id;
    
    //Atributo tipo integer de id de candidato 
    private Integer id_candidato;
    
    //Atributo integer de id del voto
    private Integer id_voto;
    

    //Metodo de get de id resultado
    public Integer getId() {
        return id;
    }

    //Metodo de set de id resultado
    public void setId(Integer id) {
        this.id = id;
    }

    //Metodo de get de id del candidato
    public Integer getId_candidato() {
        return id_candidato;
    }

    //Metodo de set de id del candidato
    public void setId_candidato(Integer id_candidato) {
        this.id_candidato = id_candidato;
    }

    //Metodo de get de id del voto
    public Integer getId_voto() {
        return id_voto;
    }

    //Metodo de set del voto
    public void setId_voto(Integer id_voto) {
        this.id_voto = id_voto;
    }

   //To string de los atributos de resultado

    @Override
    public String toString() {
        return "Resultados{" + "id=" + id + ", id_candidato=" + id_candidato + ", id_voto=" + id_voto + ", porciento=" + '}';
    }
    
   

   
}
