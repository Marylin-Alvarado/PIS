/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.DAO;

import controlador.ed.listas.exception.ListaNullException;
import controlador.ed.listas.exception.PosicionNoEncontradaException;
import java.io.IOException;
import modelo.Eleccion;

public class EleccionDao extends AdaptadorDAO<Eleccion>{
    private Eleccion eleccion = new Eleccion();

    public Eleccion getEleccion() {
        if (this.eleccion == null) {
            this.eleccion = new Eleccion();
        }
        return eleccion;
    }

    public void setEleccion(Eleccion eleccion) {
        this.eleccion = eleccion;
    }
    
    public EleccionDao(){
        super(Eleccion.class);
    }
    
    public void guardar() throws IOException{
        eleccion.setId_Eleccion(generateID());
        this.guardar(eleccion);
    }
    
    public void modificar(Integer pos) throws ListaNullException, PosicionNoEncontradaException, IOException{
        this.modificar(eleccion, pos);
    }
    
    private Integer generateID(){
        return listar().size() + 1;
    }
    
}
