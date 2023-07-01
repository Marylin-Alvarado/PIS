/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.DAO;


import controlador.ed.listas.exception.ListaNullException;
import controlador.ed.listas.exception.PosicionNoEncontradaException;
import java.io.IOException;
import modelo.Dignidad;
import modelo.Voto;



/**
 *
 * @author wilson7578
 */
public class DignidadDao extends AdaptadorDAO<Dignidad> {

    private Dignidad dignidad;

    public DignidadDao() {
        super(Dignidad.class);
    }

    public Dignidad getDignidad() {
        if (this.dignidad == null) {
            this.dignidad = new Dignidad();
        }
        return dignidad;
    }

    public void setDignidad(Dignidad dignidad) {
        this.dignidad = dignidad;
    }

    public void guardar() throws IOException {
        dignidad.setId(generateID());
        this.guardar(dignidad);
    }

    public void modificar(Integer pos) throws PosicionNoEncontradaException, ListaNullException, IOException{
        this.modificar(dignidad, pos);
    }

    private Integer generateID() {
        return listar().getSize()+ 1;
    }

   
}
