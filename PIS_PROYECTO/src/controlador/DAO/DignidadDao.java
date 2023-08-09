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
}
