/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.DAO;


import controlador.ed.listas.ListaEnlazada;
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
    

    public void guardar() throws  Exception {
        dignidad.setId(generateID());
        this.guardar(dignidad);
    }

    public void modificar(Integer pos) throws  Exception{
        this.modificar(dignidad);
    }

    private Integer generateID() {
        return listar().getSize()+ 1;
    }

       public Integer contadorCategoria(String dato) throws Exception{
        Dignidad resultado = null;
        ListaEnlazada<Dignidad> lista = listar();
        Integer contador = 0;
        for (int i = 0; i < lista.size(); i++) {
            Dignidad aux = lista.obtener(i);
            if (aux.getCategoria().toLowerCase().equals(dato.toLowerCase())) {
                resultado = aux;
                if (i < lista.size()) {
                    contador++;
                }
                
            }
        }
        return contador;
    }
       public ListaEnlazada<Dignidad> buscarPorCategorias(String dato) throws Exception {
    ListaEnlazada<Dignidad> lista = listar();
    ListaEnlazada<Dignidad> resultados = new ListaEnlazada<>();
    
    for (int i = 0; i < lista.size(); i++) {
        Dignidad aux = lista.obtener(i);
        if (aux.getCategoria().toLowerCase().equals(dato.toLowerCase())) {
            resultados.insertar(aux);
   
        }
    }
    return resultados;
}
}
