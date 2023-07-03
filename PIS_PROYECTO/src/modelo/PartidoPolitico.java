/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import controlador.ed.listas.ListaEnlazada;

/**
 *
 * @author cobos
 */
public class PartidoPolitico {

    private Integer id_partido;
    private String nombre_partido;
    private Integer numero_candidatos;
    private ListaEnlazada<Candidato> candidato = new ListaEnlazada<>();

    public Integer getId_partido() {
        return id_partido;
    }

    public void setId_partido(Integer id_partido) {
        this.id_partido = id_partido;
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

    public ListaEnlazada<Candidato> getCandidato() {
        return candidato;
    }

    public void setCandidato(ListaEnlazada<Candidato> candidato) {
        this.candidato = candidato;
    }

}
