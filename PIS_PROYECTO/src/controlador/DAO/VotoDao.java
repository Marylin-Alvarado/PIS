/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.DAO;


import controlador.ed.listas.exception.ListaNullException;
import controlador.ed.listas.exception.PosicionNoEncontradaException;
import java.io.IOException;
import modelo.Voto;



/**
 *
 * @author wilson7578
 */
public class VotoDao extends AdaptadorDAO<Voto> {

    /**
     * Atributo de voto
     */
    private Voto voto;

    /**
     * Controlador de votoDao
     */
    public VotoDao() {
        super(Voto.class);
    }

    /**
     * Metodo de get de voto
     * @return 
     */
    public Voto getVoto() {
        if (this.voto == null) {
            this.voto = new Voto();
        }
        return voto;
    }

    /**
     * Metodo de set de voto
     * @param persona 
     */
    public void setVoto(Voto persona) {
        this.voto = persona;
    }

    /**
     * Metodo de guardar
     * @throws Exception 
     */
    public void guardar() throws Exception {
        voto.setId(generateID());
        this.guardar(voto);
    }

    /**
     * Metodo de modificar 
     * @param pos
     * @throws Exception 
     */
    public void modificar(Integer pos) throws Exception{
        this.modificar(voto);
    }
    /**
     * Metodo de generate id
     * @return 
     */

    private Integer generateID() {
        return listar().getSize()+ 1;
    }

   
}
