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

    private Integer id_partido;
    private Integer id;
    private String nombre_candidato;
    private String preparacion_candidato;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getId_partido() {
        return id_partido;
    }

    public void setId_partido(Integer id_partido) {
        this.id_partido = id_partido;
    }

    @Override
    public String toString() {
        return "Candidato{" + "id_partido=" + id_partido + ", id=" + id + ", nombre_candidato=" + nombre_candidato + ", preparacion_candidato=" + preparacion_candidato + '}';
    }
    
    
}
