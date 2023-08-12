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
import modelo.Persona;
import modelo.Persona;

/**
 *
 * @author Edison
 */
public class PersonaDAO extends AdaptadorDAO<Persona> {
    private Persona persona;
    private ListaEnlazada<Persona> person = new ListaEnlazada<>();
    
    public PersonaDAO() {
        super(Persona.class);
    }

    public Persona getPersona() {
        if (this.persona == null) {
            this.persona = new Persona();
        }
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Integer guardar() throws Exception {
        return this.guardar(persona);   
    }

    public boolean modificar() throws Exception {
         this.modificar(persona);
         return true;
    }

    private Integer generateID() {
        return listar().size() + 1;
    }
    
     public Persona obtener(String usuario) throws ListaVaciaException, PosicionNoEncontradaException, IllegalArgumentException, IllegalAccessException, Exception {
        try {
            // Asegurarse de que la lista esté ordenada por nombre de usuario
            ListaEnlazada<Persona> listaOrdenada = quicksortAs(person);

            // Realizar la búsqueda binaria en la lista ordenada
            ListaEnlazada<Persona> resultadoBusqueda = busBinaria(listaOrdenada, usuario);

            // Si se enpersonra una persona, devolverla
            if (!resultadoBusqueda.estaVacia()) {
                return resultadoBusqueda.obtener(0);
            }

            // Si no se enpersonra, intentar la búsqueda secuencial
            int indicePersona = buscar(usuario);
            if (indicePersona != -1) {
                return person.obtener(indicePersona);
            }
        } catch (Exception e) {
            // Manejar cualquier excepción aquí si es necesario
        }

       
        return null;
    }

    public int buscar(String usuario) throws ListaVaciaException, PosicionNoEncontradaException, ListaNullException {
        int n = -1;
        for (int i = 0; i < person.getSize(); i++) {
            if (person.obtener(i).getNombres_completos().equals(usuario)) {
                n = i;
                break;
            }
        }
        return n;
    }

    public ListaEnlazada<Persona> busBinaria(ListaEnlazada<Persona> lista, String dato) {
        Persona[] arreglo = lista.toArray();
        int inicio = 0;
        int fin = arreglo.length - 1;
        int pos;

        while (inicio <= fin) {
            pos = (inicio + fin) / 2;
            if (arreglo[pos].getNombres_completos().toLowerCase().equals(dato.toLowerCase())) {
                ListaEnlazada<Persona> res = new ListaEnlazada<>();

                res.insertar(arreglo[pos]);
                return res;
            }
            if (arreglo[pos].getNombres_completos().compareToIgnoreCase(dato) < 0) {
                inicio = pos + 1;
            } else {
                fin = pos - 1;
            }
        }
        return lista;
    }

    public ListaEnlazada<Persona> buscarNombreCliente(String dato) {
        ListaEnlazada<Persona> lista = listar();
        quicksortAs(lista);
        lista.imprimir();
        return busBinaria(lista, dato);
    }
    
    public Persona buscarUsaurio(String user) throws Exception {
        Persona c = null;
        ListaEnlazada<Persona> lista = listar();
        for(int i = 0; i < lista.size();i++) {
            Persona aux = lista.obtener(i);
            if(user.equals(aux.getNombres_completos())) {
                c = aux;
                break;
            }
        }
        return c;
    }
    
    public Persona inicioSesion(String user, String clave) throws Exception {
        Persona c = buscarUsaurio(user);
        if(c != null) {
            System.out.println(c+"  "+c.getIdentificacion()+ " "+clave);
            if(!c.getIdentificacion().equals(clave)) {
                c = null;
            }
        }
        
        return c;
    }

    public ListaEnlazada<Persona> quicksortAs(ListaEnlazada<Persona> lista) {
        if (lista == null || lista.size() == 0) {
            return lista;
        }
        Persona[] arreglo = lista.toArray();
        ordenarAs(arreglo, 0, arreglo.length - 1);
        return lista.toList(arreglo);
    }

    private static void ordenarAs(Persona[] lista, int bajo, int alto) {
        if (bajo < alto) {
            int particionIndex = particionAs(lista, bajo, alto);
            ordenarAs(lista, bajo, particionIndex - 1);
            ordenarAs(lista, particionIndex + 1, alto);
        }
    }

    private static int particionAs(Persona[] lista, int bajo, int alto) {
        Persona pivot = lista[alto];
        int i = bajo - 1;
        for (int j = bajo; j < alto; j++) {
            if (lista[j].getNombres_completos().toLowerCase().compareToIgnoreCase(pivot.getNombres_completos().toLowerCase()) < 0) {
                i++;
                swapAs(lista, i, j);
            }
        }
        swapAs(lista, i + 1, alto);
        return i + 1;
    }

    private static void swapAs(Persona[] lista, int i, int j) {
        Persona temp = lista[i];
        lista[i] = lista[j];
        lista[j] = temp;
    }
    
}
