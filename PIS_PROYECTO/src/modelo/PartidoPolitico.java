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

    private Integer id_partidoPolitico;
    private String nombre_partidoPolitico;
    private Integer numero_candidatos;
    private String esloganPartido;
    private String lider_partidoPolitoco;

    public Integer getId_partidoPolitico() {
        return id_partidoPolitico;
    }

    public void setId_partidoPolitico(Integer id_partidoPolitico) {
        this.id_partidoPolitico = id_partidoPolitico;
    }

    public String getNombre_partidoPolitico() {
        return nombre_partidoPolitico;
    }

    public void setNombre_partidoPolitico(String nombre_partidoPolitico) {
        this.nombre_partidoPolitico = nombre_partidoPolitico;
    }

    public Integer getNumero_candidatos() {
        return numero_candidatos;
    }

    public void setNumero_candidatos(Integer numero_candidatos) {
        this.numero_candidatos = numero_candidatos;
    }

    public String getEsloganPartido() {
        return esloganPartido;
    }

    public void setEsloganPartido(String esloganPartido) {
        this.esloganPartido = esloganPartido;
    }

    public String getLider_partidoPolitoco() {
        return lider_partidoPolitoco;
    }

    public void setLider_partidoPolitoco(String lider_partidoPolitoco) {
        this.lider_partidoPolitoco = lider_partidoPolitoco;
    }

  

}
