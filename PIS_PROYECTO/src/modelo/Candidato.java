/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author cobos
 */
public class Candidato {

    private Integer id_partido_politico;
    private Integer id_candidato;
    private Integer id_dignidad;
    private String nombre_candidato;
    private String preparacion_candidato;

    public Integer getId_candidato() {
        return id_candidato;
    }

    public void setId_candidato(Integer id_candidato) {
        this.id_candidato = id_candidato;
    }

    public String getNombre_candidato() {
        return nombre_candidato;
    }

    public void setNombre_candidato(String nombre_candidato) {
        this.nombre_candidato = nombre_candidato;
    }

    public String getPreparacion_candidato() {
        return preparacion_candidato;
    }

    public void setPreparacion_candidato(String preparacion_candidato) {
        this.preparacion_candidato = preparacion_candidato;
    }

    public Integer getId_partido_politico() {
        return id_partido_politico;
    }

    public void setId_partido_politico(Integer id_partido_politico) {
        this.id_partido_politico = id_partido_politico;
    }

    public Integer getId_dignidad() {
        return id_dignidad;
    }

    public void setId_dignidad(Integer id_dignidad) {
        this.id_dignidad = id_dignidad;
    }
    
    
    
}
