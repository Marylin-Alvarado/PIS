//<<<<<<< HEAD
//=======
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

    //Atributo tipo integer de id del partido politico
    private Integer id_partido_politico;

    //Atributo de tipo integer de id del candidato
    private Integer id;

    //Atributo tipo integer de id de la dignidad
    private Integer id_dignidad;

    //Atributo tipo String de nombre del candidato
    private String nombre_candidato;

    //Atributo tipo String de preparacion del candidato
    private String preparacion_candidato;

    //Metodo de get de id del candidato
    public Integer getId() {
        return id;
    }

    //Metodo de set de id del candidato
    public void setId(Integer id) {
        this.id = id;
    }

    //Metodo de get de tipo string de nombre del candidato
    public String getNombre_candidato() {
        return nombre_candidato;
    }

    //Metodo de set de tipo string de nombre del candidato
    public void setNombre_candidato(String nombre_candidato) {
        this.nombre_candidato = nombre_candidato;
    }

    //Metodo de get de tipo string de preparacion del candidato
    public String getPreparacion_candidato() {
        return preparacion_candidato;
    }

    //Metodo de set de tipo string de preparacion del candidato
    public void setPreparacion_candidato(String preparacion_candidato) {
        this.preparacion_candidato = preparacion_candidato;
    }

    //Metodo de get de tipo inetegr de id del partido politico
    public Integer getId_partido_politico() {
        return id_partido_politico;
    }

    //Metodo de set de tipo inetegr de id del partido politico
    public void setId_partido_politico(Integer id_partido_politico) {
        this.id_partido_politico = id_partido_politico;
    }

    //Metodo de get de tipo inetegr de id de la dignidad
    public Integer getId_dignidad() {
        return id_dignidad;
    }

    //Metodo de set de tipo inetegr de id de la dignidad
    public void setId_dignidad(Integer id_dignidad) {
        this.id_dignidad = id_dignidad;
    }

}
