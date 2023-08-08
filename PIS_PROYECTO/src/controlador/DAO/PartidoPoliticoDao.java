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

    private Partido_Politico datos;

    public PartidoPoliticoDao() {
        super(Partido_Politico.class);
    }

    public Partido_Politico getDatos() {
        if (this.datos == null) {
            this.datos = new Partido_Politico();
        }
        return datos;
    }

    public void setDatos(Partido_Politico datos) {
        this.datos = datos;
    }

    public Integer guardar() throws Exception {
        return this.guardar(datos);   
    }

    public boolean modificar() throws Exception {
         this.modificar(datos);
         return true;
    }

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