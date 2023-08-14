/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.ed.listas;

/**
 *
 * @author Marylin
 */
public class NodoLista<E> {

    /**
     * Atributo de dato
     */
    private E dato;
    /**
     * Atributo de nodo lista siguiente
     */
    private NodoLista<E> siguiente;

    /**
     * Constructor de nodo lista
     * @param dato
     * @param siguiente 
     */
    public NodoLista(E dato, NodoLista<E> siguiente) {
        this.dato = dato;
        this.siguiente = siguiente;
    }

    /**
     * Metodo de nodo lista null
     */
    public NodoLista() {
        this.dato = null;
        this.siguiente = null;
    }

    /**
     * Metodo de get de dato
     * @return 
     */
    public E getDato() {
        return dato;
    }
    /**
     * Metodo de set de dato
     * @param dato 
     */

    public void setDato(E dato) {
        this.dato = dato;
    }

    /**
     * Metodo de get siguiente
     * @return 
     */
    public NodoLista<E> getSiguiente() {
        return siguiente;
    }

   /**
    * Metodo de set siguiente 
    * @param siguiente 
    */
    public void setSiguiente(NodoLista<E> siguiente) {
        this.siguiente = siguiente;
    }

}
