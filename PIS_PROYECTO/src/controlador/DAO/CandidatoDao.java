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
import modelo.Candidato;

/**
 *
 * @author cobos
 */
public class CandidatoDao extends AdaptadorDAO<Candidato>{
    
    private Candidato datos;

    public CandidatoDao() {
        super(Candidato.class);
    }

    public Candidato getDatos() {
        if (this.datos == null) {
            this.datos = new Candidato();
        }
        return datos;
    }

    public void setDatos(Candidato datos) {
        this.datos = datos;
    }

    public void guardar() throws IOException, Exception {
        datos.setId_candidato(generateID());
        this.guardar(datos);
    }

    public void modificar(Integer pos) throws ListaNullException, PosicionNoEncontradaException, IOException, Exception {
        this.modificar(datos);
    }

    private Integer generateID() {
        return listar().size() + 1;
    }
      
      /**
     *
     * @param lista
     * @param tipoOrden
     * @return
     */
    public ListaEnlazada<Candidato> quickSort(ListaEnlazada<Candidato> lista, Integer tipoOrden, Integer atributoOrden) {
        // Comprueba si la lista está vacía o solo contiene un elemento, en cuyo caso ya está ordenada
        if (lista == null || lista.size() <= 1) {
            return lista;
        }
        // Convierte la lista en un arreglo para facilitar el ordenamiento
        Candidato[] arreglo = lista.toArray();
        // Llama al método quickSort para ordenar el arreglo
        quickSort(arreglo, 0, arreglo.length - 1, tipoOrden, atributoOrden);
        // Convierte el arreglo ordenado nuevamente en una lista enlazada
        return lista.toList(arreglo);
    }

    /**
     *
     * @param arreglo
     * @param bajo
     * @param alto
     * @param tipoOrden
     */
    private static void quickSort(Candidato[] arreglo, int bajo, int alto, int tipoOrden, Integer atributoOrden) {
        // Verifica si hay elementos para ordenar
        if (bajo < alto) {
            // Divide el arreglo y obtiene el índice de la división
            int indiceDivision = division(arreglo, bajo, alto, tipoOrden, atributoOrden);
            // Ordena recursivamente la mitad inferior antes de la división
            quickSort(arreglo, bajo, indiceDivision - 1, tipoOrden, atributoOrden);
            // Ordena recursivamente la mitad superior después de la división
            quickSort(arreglo, indiceDivision + 1, alto, tipoOrden, atributoOrden);
        }
    }

    /**
     *
     * @param arreglo
     * @param bajo
     * @param alto
     * @param tipoOrden
     * @return
     */
    private static int division(Candidato[] arreglo, int bajo, int alto, int tipoOrden, Integer atributoOrden) {
        // Selecciona el pivote como el último elemento del arreglo
        Candidato pivote = arreglo[alto];
        int i = bajo - 1;
        switch (atributoOrden) {
            case 0:
                // Itera sobre el arreglo desde el índice bajo hasta el índice alto - 1
                for (int j = bajo; j < alto; j++) {
                    // Comprueba el tipo de ordenamiento y realiza el intercambio si es necesario
                    if (tipoOrden == 0) {
                        if (arreglo[j].getId_partido()< pivote.getId_partido()) {
                            i++;
                            intercambio(arreglo, i, j);
                        }
                    } else {
                        if (arreglo[j].getId_partido() > pivote.getId_partido()) {
                            i++;
                            intercambio(arreglo, i, j);
                        }
                    }
                }
                
        }
        // Intercambia el pivote con el elemento en la posición i + 1
        intercambio(arreglo, i + 1, alto);
        // Devuelve la posición del pivote después de la división
        return i + 1;
    }

    /**
     *
     * @param arreglo
     * @param i
     * @param j
     */
    private static void intercambio(Candidato[] arreglo, int i, int j) {
        // Intercambia los elementos en las posiciones i y j del arreglo
        Candidato temp = arreglo[i];
        arreglo[i] = arreglo[j];
        arreglo[j] = temp;
    }
}
