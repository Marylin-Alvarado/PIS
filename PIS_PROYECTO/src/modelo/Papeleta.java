/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import controlador.ed.listas.ListaEnlazada;

public class Papeleta {
    private Integer id_papeleta;
    private ListaEnlazada<Candidato> candidatos;
    private Integer id_eleccion;
    private Integer id_persona;

    public Papeleta() {
    }
    
    public Papeleta(ListaEnlazada<Candidato> candidatos) {
        this.candidatos = candidatos;
    }

    public Integer getId_papeleta() {
        return id_papeleta;
    }

    public void setId_papeleta(Integer id_papeleta) {
        this.id_papeleta = id_papeleta;
    }

    public ListaEnlazada<Candidato> getCandidatos() {
        return candidatos;
    }

    public void setCandidatos(ListaEnlazada<Candidato> candidatos) {
        this.candidatos = candidatos;
    }

    public Integer getId_eleccion() {
        return id_eleccion;
    }

    public void setId_eleccion(Integer id_eleccion) {
        this.id_eleccion = id_eleccion;
    }

    public Integer getId_persona() {
        return id_persona;
    }

    public void setId_persona(Integer id_persona) {
        this.id_persona = id_persona;
    }    

    @Override
    public String toString() {
        return "Papeleta{" + "id_papeleta=" + id_papeleta + ", candidatos=" + candidatos + ", id_eleccion=" + id_eleccion + ", id_persona=" + id_persona + '}';
    }
    
}
