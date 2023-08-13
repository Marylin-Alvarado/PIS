package controlador.DAO;

import controlador.ed.listas.ListaEnlazada;
import controlador.ed.listas.exception.ListaNullException;
import controlador.ed.listas.exception.PosicionNoEncontradaException;
import modelo.Dignidad;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author wilson7578
 */
public class DignidadDao extends AdaptadorDAO<Dignidad> {

    private Dignidad datos;

    public DignidadDao() {
        super(Dignidad.class);
    }

    public Dignidad getDatos() {
        if (this.datos == null) {
            this.datos = new Dignidad();
        }
        return datos;
    }

    public void setDatos(Dignidad datos) {
        this.datos = datos;
    }

    public Integer guardar() throws Exception {
        return this.guardar(datos);
    }

    public boolean modificar() throws Exception {
        this.modificar(datos);
        return true;
    }

    /**
     * Busca y devuelve una instancia de Dignidad que corresponde a un ID
     * específico.
     *
     * @param id El ID de la dignidad que se desea buscar.
     * @return Una instancia de Dignidad que tiene el ID especificado, o null si
     * no se encuentra.
     * @throws Exception Si ocurre un error durante el proceso de búsqueda.
     */
    public Dignidad buscarPorId(int id) throws Exception {

        Dignidad resultado = null;
        ListaEnlazada<Dignidad> lista = listar();

        for (int i = 0; i < lista.size(); i++) {
            if (lista.obtener(i).getId() == id) {
                resultado = lista.obtener(i);
            }
        }

        return resultado;
    }

    /**
     * Busca y devuelve una lista de dignidades que pertenecen a una categoría
     * específica (ignorando mayúsculas y minúsculas).
     *
     * @param dato La categoría que se desea buscar.
     * @return Una ListaEnlazada que contiene las dignidades encontradas en la
     * categoría especificada.
     * @throws Exception Si ocurre un error durante el proceso de búsqueda.
     */
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

    /**
     * Busca y devuelve una lista de dignidades que pertenecen a una categoría
     * específica.
     *
     * @param dato La categoría que se desea buscar.
     * @return Una ListaEnlazada que contiene las dignidades encontradas en la
     * categoría especificada.
     * @throws Exception Si ocurre un error durante el proceso de búsqueda.
     */
    public Dignidad categoriaDignidad(String dato) throws ListaNullException, PosicionNoEncontradaException {
        Dignidad resultado = null;
        ListaEnlazada<Dignidad> lista = listar();
        for (int i = 0; i < lista.size(); i++) {
            Dignidad aux = lista.obtener(i);
            if (aux.getCategoria().toLowerCase().equals(dato.toLowerCase())) {
                resultado = aux;
                break;
            }
        }
        return resultado;
    }

    /**
     * Ordena una lista de dignidades según su categoría en orden alfabético
     * (insensible a mayúsculas y minúsculas).
     *
     * @param lista La lista de dignidades que se desea ordenar.
     * @return Una ListaEnlazada que contiene las dignidades ordenadas por
     * categoría.
     */
    public ListaEnlazada<Dignidad> ordenarCategoria(ListaEnlazada<Dignidad> lista) {
        try {
            Dignidad[] matriz = lista.toArray();
            for (int i = 1; i < lista.size(); i++) {
                Dignidad key = matriz[i];
                int j = i - 1;
                while (j >= 0 && (matriz[j].getCategoria().compareToIgnoreCase(key.getTipo())) > 0) {
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

    /**
     * Busca y cuenta la cantidad de ocurrencias de una categoría específica en
     * la lista de dignidades.
     *
     * @param dato La categoría que se desea buscar.
     * @return El número de ocurrencias de la categoría en la lista de
     * dignidades.
     * @throws Exception Si ocurre un error durante el proceso de búsqueda.
     */
    public Integer contadorCategoria(String dato) throws Exception {
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

}
