package controlador.DAO;

import controlador.ed.listas.ListaEnlazada;
import controlador.ed.listas.exception.ListaNullException;
import controlador.ed.listas.exception.PosicionNoEncontradaException;
import modelo.Dignidad;

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
    
    public Dignidad buscarPorId(int id) throws Exception {
        
        Dignidad resultado = null;
        ListaEnlazada<Dignidad> lista = listar();
        
        for(int i = 0 ; i < lista.size() ; i++){
            if(lista.obtener(i).getId() == id){
                resultado = lista.obtener(i);
            }
        }
        
        return resultado;
    }

    public Integer buscarPorCategoria(String dato) throws Exception {
        Dignidad resultado = null;
        ListaEnlazada<Dignidad> lista = listar();
        Integer contador = 0;
        for (int i = 0; i < lista.size(); i++) {
            Dignidad aux = lista.obtener(i);
            if (aux.getCategorias().toLowerCase().equals(dato.toLowerCase())) {
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
            if (aux.getCategorias().toLowerCase().equals(dato.toLowerCase())) {
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
            if (aux.getCategorias().toLowerCase().equals(dato.toLowerCase())) {
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
                while (j >= 0 && (matriz[j].getCategorias().compareToIgnoreCase(key.getTipo())) > 0) {
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