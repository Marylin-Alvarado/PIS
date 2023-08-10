/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.DAO;

/**
 *
 * @author wilson7578
 */
public class DignidadDao extends AdaptadorDAO<Dignidad> {

    public DignidadDao() {
        super(Dignidad.class);
    }
        Dignidad resultado = null;
        ListaEnlazada<Dignidad> lista = listar();
        Integer contador = 0;
        for (int i = 0; i < lista.size(); i++) {
            Dignidad aux = lista.obtener(i);

                resultado = aux;
                if (i < lista.size()) {
                    contador++;
                }

            }
        }
        return contador;
    }

        Dignidad resultado = null;
        ListaEnlazada<Dignidad> lista = listar();
        for (int i = 0; i < lista.size(); i++) {
            Dignidad aux = lista.obtener(i);

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
