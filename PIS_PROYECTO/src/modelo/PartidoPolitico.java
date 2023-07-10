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
public class PartidoPolitico {

    private Integer id;
    private String nombre_partido;
    private Integer numero_candidatos;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre_partido() {
        return nombre_partido;
    }

    public void setNombre_partido(String nombre_partido) {
        this.nombre_partido = nombre_partido;
    }

    public Integer getNumero_candidatos() {
        return numero_candidatos;
    }

    public void setNumero_candidatos(Integer numero_candidatos) {
        this.numero_candidatos = numero_candidatos;
    }

    @Override
    public String toString() {
        return nombre_partido;
    }

}
