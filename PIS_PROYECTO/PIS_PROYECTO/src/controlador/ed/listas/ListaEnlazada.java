/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.ed.listas;

import controlador.ed.listas.exception.ListaNullException;
import controlador.ed.listas.exception.ListaVaciaException;
import controlador.ed.listas.exception.PosicionNoEncontradaException;
import java.lang.reflect.Array;

/**
 *
 * @author Marylin
 */
public class ListaEnlazada<E> {

    private NodoLista<E> cabecera;
    private Integer size;
    private final Integer ascendente = 1;
    private final Integer descendente = 2;

    public ListaEnlazada() {
        cabecera = null;
        size = 0;
    }

    /**
     * Método para verificar si una lista está vacia
     *
     * @return
     */
    public Boolean estaVacia() {
        return cabecera == null;
    }
    
     public Integer size() {

        return size;
    }

    /**
     * Método para insertar un dato a la lista
     *
     * @param dato
     */
    public void insertar(E dato) {
        NodoLista<E> nodo = new NodoLista<>(dato, null);
        if (estaVacia()) {
            this.cabecera = nodo;
        } else {
            NodoLista<E> aux = cabecera;
            while (aux.getSiguiente() != null) {
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(nodo);
        }
        size++;
    }

    /**
     * Método para insertar un dato al comienzo de la lista
     *
     * @param dato
     */
    public void insertarCabecera(E dato) {
        if (estaVacia()) {
            insertar(dato);
        } else {
            NodoLista<E> nodo = new NodoLista<>(dato, null);
            nodo.setSiguiente(cabecera);
            cabecera = nodo;
            size++;
        }
    }

    /**
     * Método para modiifar un dato de la lista en la posición dada
     *
     * @param dato
     * @param pos
     * @throws PosicionNoEncontradaException
     */
    public void update(Integer pos, E dato) throws ListaNullException, PosicionNoEncontradaException {
        if (estaVacia()) {
            throw new ListaNullException();
        } else {
            if (pos >= 0 && pos < size()) {
                if (pos == 0) {
                    dato = cabecera.getDato();

                } else {
                    NodoLista<E> aux = cabecera;
                    for (int i = 0; i < pos; i++) {
                        aux = aux.getSiguiente();
                    }
                    aux.setDato(dato);
                }
            } else {
                throw new PosicionNoEncontradaException();
            }
        }

    }

    /**
     * Método para eliminar un elemento de la lista
     *
     * @param pos
     * @return
     * @throws ListaVaciaException
     * @throws PosicionNoEncontradaException
     */
    public E eliminar(Integer pos) throws ListaVaciaException, PosicionNoEncontradaException {
        if (!estaVacia()) {
            E dato = null;
            if (pos >= 0 && pos < size) {
                if (pos == 0) {
                    dato = cabecera.getDato();
                    cabecera = cabecera.getSiguiente();
                    size--;

                } else {
                    NodoLista<E> aux = cabecera;

                    for (int i = 0; i < pos - 1; i++) {
                        aux = aux.getSiguiente();
                    }

                    dato = aux.getDato();
                    NodoLista<E> proximo = aux.getSiguiente();
                    aux.setSiguiente(proximo.getSiguiente());
                    size--;
                }

            } else {
                throw new PosicionNoEncontradaException();
            }
            return dato;
        } else {
            throw new ListaVaciaException();
        }

    }

    /**
     * Método para imprimir por consola la lista
     */
    public void imprimir() {
        System.out.println("--------------LISTA ENLAZADA------------------");
        NodoLista<E> aux = cabecera;
        while (aux != null) {
            System.out.println(aux.getDato().toString() + "\t");
            aux = aux.getSiguiente();
        }
        System.out.println("\n--------------------------------------");
    }

    /**
     * Método para obtener el elemento de la lista en la posición dada
     *
     * @param pos
     * @return
     * @throws PosicionNoEncontradaException
     * @throws ListaNullException
     */
    public E obtener(Integer pos) throws PosicionNoEncontradaException, ListaNullException {

        if (!estaVacia()) {
            E dato = null;
            if (pos >= 0 && pos < size) {
                if (pos == 0) {
                    dato = cabecera.getDato();
                } else {
                    NodoLista<E> aux = cabecera;
                    for (int i = 0; i < pos; i++) {
                        aux = aux.getSiguiente();
                    }
                    dato = aux.getDato();
                }
            } else {
                throw new PosicionNoEncontradaException();
            }
            return dato;
        } else {
            throw new ListaNullException();
        }
    }

    /**
     * Método para pasar una lista enlazada a un arreglo
     *
     * @return
     */
    public E[] toArray() {
        E[] matriz = null;
        if (this.size > 0) {
            matriz = (E[]) Array.newInstance(cabecera.getDato().getClass(), this.size);
            NodoLista<E> aux = cabecera;
            for (int i = 0; i < this.size; i++) {
                matriz[i] = aux.getDato();
                aux = aux.getSiguiente();
            }
        }
        return matriz;
    }

    /**
     * Método para pasar un arreglo a una lista enlazada
     *
     * @param matriz
     * @return
     */
    public ListaEnlazada<E> toList(E[] matriz) {
        this.vaciar();
        for (int i = 0; i < matriz.length; i++) {
            this.insertar(matriz[i]);
        }
        return this;
    }

    /**
     * Método para vaciar una lista enlazada
     */
    public void vaciar() {
        this.cabecera = null;
        this.size = 0;
    }

    public NodoLista<E> getCabecera() {
        return cabecera;
    }

    public void setCabecera(NodoLista<E> cabecera) {
        this.cabecera = cabecera;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

}
