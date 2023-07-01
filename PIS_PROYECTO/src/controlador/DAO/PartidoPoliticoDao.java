/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.DAO;

import controlador.ed.listas.exception.ListaNullException;
import controlador.ed.listas.exception.PosicionNoEncontradaException;
import java.io.IOException;
import modelo.PartidoPolitico;

/**
 *
 * @author cobos
 */
public class PartidoPoliticoDao extends AdaptadorDAO<PartidoPolitico>{
     private PartidoPolitico datos;

    public PartidoPoliticoDao() {
        super(PartidoPolitico.class);
    }

    public PartidoPolitico getDatos() {
        if (this.datos == null) {
            this.datos = new PartidoPolitico();
        }
        return datos;
    }

    public void setDatos(PartidoPolitico datos) {
        this.datos = datos;
    }

    public void guardar() throws IOException {
        datos.setId_partido(generateID());
        this.guardar(datos);
    }

    public void modificar(Integer pos) throws ListaNullException, PosicionNoEncontradaException, IOException {
        this.modificar(datos, pos);
    }

    private Integer generateID() {
        return listar().size() + 1;
    }
    
}
