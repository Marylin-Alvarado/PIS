/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.util.Date;

/**
 *
 * @author Gonzalez G
 */
public class Voto {
     private Integer id ;
     private TipoVoto tipo_voto;
     private Date fechade_emision;
    //Estado del voto True si la persona voto y false si no voto
     private Boolean estado ;
   

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TipoVoto getTipoVoto() {
        return tipo_voto;
    }

    public void setTipoVoto(TipoVoto tipoVoto) {
        this.tipo_voto = tipoVoto;
    }

    public TipoVoto getTipo_voto() {
        return tipo_voto;
    }

    public void setTipo_voto(TipoVoto tipo_voto) {
        this.tipo_voto = tipo_voto;
    }

    public Date getFechade_emision() {
        return fechade_emision;
    }

    public void setFechade_emision(Date fechade_emision) {
        this.fechade_emision = fechade_emision;
    }

   


    

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

  
     
}
