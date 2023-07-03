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

    private Voto voto;

    public VotoDao() {
        super(Voto.class);
    }

    public Voto getVoto() {
        if (this.voto == null) {
            this.voto = new Voto();
        }
        return voto;
    }

    public void setPersona(Voto persona) {
        this.voto = persona;
    }

    public void guardar() throws IOException {
        voto.setId(generateID());
        this.guardar(voto);
    }

    public void modificar(Integer pos) throws PosicionNoEncontradaException, ListaNullException, IOException{
        this.modificar(voto, pos);
    }

    private Integer generateID() {
        return listar().getSize()+ 1;
    }

   
}