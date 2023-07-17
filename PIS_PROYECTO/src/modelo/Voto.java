/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Gonzalez G
 */
public class Voto {
     private Integer id ;
     private TipoVoto tipoVoto;
     private String fechadeEmision;
    //Estado del voto True si la persona voto y false si no voto
     private Boolean estado ;
     private Integer id_Eleccion ;
   

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TipoVoto getTipoVoto() {
        return tipoVoto;
    }

    public void setTipoVoto(TipoVoto tipoVoto) {
        this.tipoVoto = tipoVoto;
    }

   


    public String getFechadeEmision() {
        return fechadeEmision;
    }

    public void setFechadeEmision(String fechadeEmision) {
        this.fechadeEmision = fechadeEmision;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Integer getId_Eleccion() {
        return id_Eleccion;
    }

    public void setId_Eleccion(Integer id_Eleccion) {
        this.id_Eleccion = id_Eleccion;
    }

  
     
}
