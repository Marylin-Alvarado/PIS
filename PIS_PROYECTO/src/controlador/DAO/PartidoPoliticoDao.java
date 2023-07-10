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
        datos.setId(generateID());
        this.guardar(datos);
    }

    public void modificar(Integer pos) throws ListaNullException, PosicionNoEncontradaException, IOException {
        this.modificar(datos, pos);
    }

    private Integer generateID() {
        return listar().size() + 1;
    }
    
    public PartidoPolitico buscarPorNombre(String dato) throws ListaNullException, PosicionNoEncontradaException{
        PartidoPolitico resultado = null;
        ListaEnlazada<PartidoPolitico> lista = listar();
        for (int i = 0; i < lista.size(); i++) {
            PartidoPolitico aux = lista.obtener(i);
            if (aux.getNombre_partido().toLowerCase().equals(dato.toLowerCase())) {
                resultado = aux;
                break;
            }
        }
        return resultado;
    }
    
    public ListaEnlazada<PartidoPolitico> ordenarNombre(ListaEnlazada<PartidoPolitico> lista,  Integer tipo) {
        try {
            PartidoPolitico[] matriz = lista.toArray();
            for (int i = 1; i < lista.size(); i++) {
                PartidoPolitico key = matriz[i];
                int j = i - 1;
                switch(tipo){
                    case 0: 
                        
                }
                while (j >= 0 && (matriz[j].getNombre_partido().compareToIgnoreCase(key.getNombre_partido())) > 0) {
                    //lista.update(j+1, lista.get(j));
                    matriz[j + 1] = matriz[j];
                    j = j - 1;
                }
                //lista.update(j+1, key);
                matriz[j + 1] = key;
            }
            lista.toList(matriz);
        } catch (Exception e) {
        }
        return lista;
    }
}
