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

import modelo.Candidato;

/**
 *
 * @author cobos
 */
public class CandidatoDao extends AdaptadorDAO<Candidato> {
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

    public Integer guardar() throws Exception {
        return this.guardar(datos);
    }

    public boolean modificar() throws Exception {
        this.modificar(datos);
        return true;
    }

    public ListaEnlazada<Candidato> buscarCandidatoPorPartidoPolitico(int id) {
        ListaEnlazada<Candidato> cadidatos = listar();
        ListaEnlazada<Candidato> resultado = new ListaEnlazada<>();

        Candidato[] aux = cadidatos.toArray();

        for (int i = 0; i < aux.length; i++) {

            if (aux[i].getId_partido_politico() == i) {
                resultado.insertar(aux[i]);
            }
        }

        return resultado;
    }

    public Candidato buscarPorDignidad(int id, String dignidad) throws Exception {
        ListaEnlazada<Candidato> aux = buscarCandidatoPorPartidoPolitico(id);
        Candidato c = new Candidato();
        
        c.setNombre_candidato("");
        
        for (int i = 0; i < aux.size(); i++) {
            if (new DignidadDao().buscarPorId(aux.obtener(i).getId_dignidad()).getTipo().equals(dignidad)){
                c = aux.obtener(i);
            }
        }
        
        return c;
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
                        if (arreglo[j].getId_partido_politico() < pivote.getId_partido_politico()) {
                            i++;
                            intercambio(arreglo, i, j);
                        }
                    } else {
                        if (arreglo[j].getId_partido_politico() > pivote.getId_partido_politico()) {
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

    public Candidato buscarPorNombre(String dato) throws ListaNullException, PosicionNoEncontradaException {
        Candidato resultado = null;
        ListaEnlazada<Candidato> lista = listar();
        for (int i = 0; i < lista.size(); i++) {
            Candidato aux = lista.obtener(i);
            if (aux.getNombre_candidato().toLowerCase().equals(dato.toLowerCase())) {
                resultado = aux;
                break;
            }
        }
        return resultado;
    }

    public ListaEnlazada<Candidato> ordenarNombre(ListaEnlazada<Candidato> lista, Integer tipo) {
        try {
            Candidato[] matriz = lista.toArray();
            for (int i = 1; i < lista.size(); i++) {
                Candidato key = matriz[i];
                int j = i - 1;
                switch (tipo) {
                    case 0:

                }
                while (j >= 0 && (matriz[j].getNombre_candidato().compareToIgnoreCase(key.getNombre_candidato())) > 0) {
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
