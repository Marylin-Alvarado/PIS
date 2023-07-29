/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.DAO;

import controlador.ed.listas.ListaEnlazada;
import controlador.ed.listas.exception.ListaNullException;
import controlador.ed.listas.exception.ListaVaciaException;
import controlador.ed.listas.exception.PosicionNoEncontradaException;
import java.io.IOException;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import modelo.Cuenta;

/**
 *
 * @author Edison
 */
public class CuentaDAO extends AdaptadorDAO<Cuenta> {

    private ListaEnlazada<Cuenta> cuent = new ListaEnlazada<>();
    private Cuenta cuenta;

    public CuentaDAO() {
        super(Cuenta.class);
    }

    public Cuenta getCuenta() {
        if (this.cuenta == null) {
            this.cuenta = new Cuenta();
        }
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public ListaEnlazada<Cuenta> getCuent() {
        if (cuent == null) {
            cuent = new ListaEnlazada<>();
        }
        return cuent;
    }

    public void setCuent(ListaEnlazada<Cuenta> cuentas) {
        this.cuent = cuentas;
    }

    public Integer guardar() throws Exception {
        return this.guardar(cuenta);
    }

    public boolean modificar() throws Exception {
        this.modificar(cuenta);
        return true;
    }

    private Integer generateID() {
        return listar().size() + 1;
    }

//    public Cuenta obtener(String usuario) throws ListaVaciaException, PosicionNoEncontradaException, IllegalArgumentException, IllegalAccessException, Exception {
//        try {
//            if (!busBinaria("usuario", usuario).equals(usuario)) {
//                return cuent.obtener(buscar(usuario));
//            }
//        } catch (Exception e) {
//
//        }
//        return null;
//    }
    public Cuenta obtener(String usuario) throws ListaVaciaException, PosicionNoEncontradaException, IllegalArgumentException, IllegalAccessException, Exception {
        try {
            // Asegurarse de que la lista esté ordenada por nombre de usuario
            ListaEnlazada<Cuenta> listaOrdenada = quicksortAs(cuent);

            // Realizar la búsqueda binaria en la lista ordenada
            ListaEnlazada<Cuenta> resultadoBusqueda = busBinaria(listaOrdenada, usuario);

            // Si se encuentra una cuenta, devolverla
            if (!resultadoBusqueda.estaVacia()) {
                return resultadoBusqueda.obtener(0);
            }

            // Si no se encuentra, intentar la búsqueda secuencial
            int indiceCuenta = buscar(usuario);
            if (indiceCuenta != -1) {
                return cuent.obtener(indiceCuenta);
            }
        } catch (Exception e) {
            // Manejar cualquier excepción aquí si es necesario
        }

        // Si no se encuentra la cuenta, o ha habido alguna excepción, devolver null
        return null;
    }

    public int buscar(String usuario) throws ListaVaciaException, PosicionNoEncontradaException, ListaNullException {
        int n = -1;
        for (int i = 0; i < cuent.getSize(); i++) {
            if (cuent.obtener(i).getUsuario().equals(usuario)) {
                n = i;
                break;
            }
        }
        return n;
    }

    public ListaEnlazada<Cuenta> busBinaria(ListaEnlazada<Cuenta> lista, String dato) {
        Cuenta[] arreglo = lista.toArray();
        int inicio = 0;
        int fin = arreglo.length - 1;
        int pos;

        while (inicio <= fin) {
            pos = (inicio + fin) / 2;
            if (arreglo[pos].getUsuario().toLowerCase().equals(dato.toLowerCase())) {
                ListaEnlazada<Cuenta> res = new ListaEnlazada<>();

                res.insertar(arreglo[pos]);
                return res;
            }
            if (arreglo[pos].getUsuario().compareToIgnoreCase(dato) < 0) {
                inicio = pos + 1;
            } else {
                fin = pos - 1;
            }
        }
        return lista;
    }

    public ListaEnlazada<Cuenta> buscarNombreCliente(String dato) {
        ListaEnlazada<Cuenta> lista = listar();
        quicksortAs(lista);
        return busBinaria(lista, dato);
    }

    public ListaEnlazada<Cuenta> quicksortAs(ListaEnlazada<Cuenta> lista) {
        if (lista == null || lista.size() == 0) {
            return lista;
        }
        Cuenta[] arreglo = lista.toArray();
        ordenarAs(arreglo, 0, arreglo.length - 1);
        return lista.toList(arreglo);
    }

    private static void ordenarAs(Cuenta[] lista, int bajo, int alto) {
        if (bajo < alto) {
            int particionIndex = particionAs(lista, bajo, alto);
            ordenarAs(lista, bajo, particionIndex - 1);
            ordenarAs(lista, particionIndex + 1, alto);
        }
    }

    private static int particionAs(Cuenta[] lista, int bajo, int alto) {
        Cuenta pivot = lista[alto];
        int i = bajo - 1;
        for (int j = bajo; j < alto; j++) {
            if (lista[j].getUsuario().toLowerCase().compareToIgnoreCase(pivot.getUsuario().toLowerCase()) < 0) {
                i++;
                swapAs(lista, i, j);
            }
        }
        swapAs(lista, i + 1, alto);
        return i + 1;
    }

    private static void swapAs(Cuenta[] lista, int i, int j) {
        Cuenta temp = lista[i];
        lista[i] = lista[j];
        lista[j] = temp;
    }

}
