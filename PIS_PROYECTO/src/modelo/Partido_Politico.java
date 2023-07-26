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
public class Partido_Politico {

    private Integer id_partido_politico;
    private String nombre_partido_politico;
    private Integer numero_candidatos;
    private String eslogan_partido;

    public Integer getId_partido_politico() {
        return id_partido_politico;
    }

    public void setId_partido_politico(Integer id_partido_politico) {
        this.id_partido_politico = id_partido_politico;
    }

    public String getNombre_partido_politico() {
        return nombre_partido_politico;
    }

    public void setNombre_partido_politico(String nombre_partido_politico) {
        this.nombre_partido_politico = nombre_partido_politico;
    }

    public Integer getNumero_candidatos() {
        return numero_candidatos;
    }

    public void setNumero_candidatos(Integer numero_candidatos) {
        this.numero_candidatos = numero_candidatos;
    }

    public String getEslogan_partido() {
        return eslogan_partido;
    }

    public void setEslogan_partido(String eslogan_partido) {
        this.eslogan_partido = eslogan_partido;
    }

    @Override
    public String toString() {
        return nombre_partido_politico;
    }
    
}