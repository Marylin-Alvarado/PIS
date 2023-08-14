/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.DAO;

import controlador.ed.listas.ListaEnlazada;
import controlador.ed.listas.exception.ListaNullException;
import controlador.ed.listas.exception.PosicionNoEncontradaException;
import java.util.Objects;
import modelo.Partido_Politico;

/**
 *
 * @author cobos
 */
public class PartidoPoliticoDao extends AdaptadorDAO<Partido_Politico> {

    /**
     * Atributo de partido politico
     */
    private Partido_Politico datos;

    /**
     * Constructor de partido politico
     */
    public PartidoPoliticoDao() {
        super(Partido_Politico.class);
    }

    /**
     * Metodo de get de Datos de partido politico
     * @return 
     */
    public Partido_Politico getDatos() {
        if (this.datos == null) {
            this.datos = new Partido_Politico();
        }
        return datos;
    }
    
    /**
     * Metodo de set de datos del partido politico
     * @param datos 
     */

    public void setDatos(Partido_Politico datos) {
        this.datos = datos;
    }
    
    /**
     * Metodo de guardar
     * @return
     * @throws Exception 
     */

    public Integer guardar() throws Exception {
        return this.guardar(datos);   
    }

    /**
     * Metodo de modificar 
     * @return
     * @throws Exception 
     */
    public boolean modificar() throws Exception {
         this.modificar(datos);
         return true;
    }

    /**
     * Metodo de buscar por el nombre el partido politico
     * @param dato
     * @return
     * @throws ListaNullException
     * @throws PosicionNoEncontradaException 
     */
    public Partido_Politico buscarPorNombre(String dato) throws ListaNullException, PosicionNoEncontradaException {
        Partido_Politico resultado = null;
        ListaEnlazada<Partido_Politico> lista = listar();
        for (int i = 0; i < lista.size(); i++) {
            Partido_Politico aux = lista.obtener(i);
            if (aux.getNombre_partido_politico().toLowerCase().equals(dato.toLowerCase())) {
                resultado = aux;
                break;
            }
        }
        return resultado;
    }
    
    /**
     * Metodo de buscar por id el partido politico
     * @param dato
     * @return
     * @throws ListaNullException
     * @throws PosicionNoEncontradaException 
     */
    public Partido_Politico buscarPorId(Integer dato) throws ListaNullException, PosicionNoEncontradaException {
        Partido_Politico resultado = null;
        ListaEnlazada<Partido_Politico> lista = listar();
        for (int i = 0; i < lista.size(); i++) {
            Partido_Politico aux = lista.obtener(i);
            if (Objects.equals(dato, aux.getNombre_partido_politico())) {
                resultado = aux;
                break;
            }
        }
        return resultado;
    }

    /**
     * Metodo de ordenar por nombre el partido politico
     * @param lista
     * @param tipo
     * @return 
     */
    public ListaEnlazada<Partido_Politico> ordenarNombre(ListaEnlazada<Partido_Politico> lista, Integer tipo) {
        try {
            Partido_Politico[] matriz = lista.toArray();
            for (int i = 1; i < lista.size(); i++) {
                Partido_Politico key = matriz[i];
                int j = i - 1;
                switch (tipo) {
                    case 0:

                }
                while (j >= 0 && (matriz[j].getNombre_partido_politico().compareToIgnoreCase(key.getNombre_partido_politico())) > 0) {
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